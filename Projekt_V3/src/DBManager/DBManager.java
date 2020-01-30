package DBManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBManager 
{
	Connection conn;
	public DBManager() throws ClassNotFoundException, SQLException, org.postgresql.util.PSQLException
	{
		Class.forName("org.postgresql.Driver");
		conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/bestellung", "postgres", "1234" );
	}
	
	public void close() throws SQLException
	{
		conn.close();
	}
	
	public static enum kunde_
	{
		VORNAME,
		NACHNAME,
		TITELV,
		TITELN
	}
	
	public static enum adresse_
	{
		STADT,
		STRASSE,
		HNR,
		PLZ
	}
	
	public static enum artikel_
	{
		PREIS,
		NAME
	}
	
	public static enum bestellung_
	{
		KUNDE_ID,
		ADRESSE_LIEFER_ID,
		ADRESSE_RECHNUNG_ID
	}
	
	//--------------------------------------------------Kunde--------------------------------------------------------------
	
	public void createKunde(String titelv, String titeln, String vorname, String nachname) throws SQLException
	{
		String sql = "INSERT INTO kunde(titelv, titeln, vorname, nachname) VALUES(?,?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1,titelv);
		stmt.setString(2,titeln);
		stmt.setString(3,vorname);
		stmt.setString(4,nachname);
		
		stmt.executeUpdate();
		stmt.close();
	}
	
	public void deleteKundebyID(int id) throws SQLException
	{
		String sql = "DELETE FROM kunde WHERE kunde_id=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1,id);
		
		stmt.executeUpdate();
		stmt.close();
	}
	
	public ArrayList<Kunde> getKunden()throws SQLException
	{
		ArrayList<Kunde> kunden = new ArrayList<>();
		
		String sql = "SELECT * FROM kunde";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		System.out.printf("| %20s | %20s | %20s | %20s | %20s |\n","kunde_id","titelv","titeln","vorname","nachname");
		
		while(rs.next())
		{
			int kunde_id = rs.getInt("kunde_id");
			String titelv = rs.getString("titelv");
			String titeln = rs.getString("titeln");
			String vorname = rs.getString("vorname");
			String nachname = rs.getString("nachname");
			
			System.out.printf("| %20s | %20s | %20s | %20s | %20s |\n",kunde_id,titelv,titeln,vorname,nachname);
			
			Kunde k = new Kunde(kunde_id, titelv, titeln, vorname, nachname);
			kunden.add(k);
		}
		
		rs.close();
		stmt.close();
		return kunden;
	}
	
	public void updateKunde(kunde_ update, String value, int kunde_id)throws SQLException
	{
		String sql = "UPDATE kunde SET "+ update +" = ? WHERE kunde_id=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1,value);
		stmt.setInt(2,kunde_id);
		
		stmt.executeUpdate();
		stmt.close();
	}
	
	//--------------------------------------------------Adresse--------------------------------------------------------------
	
	public void createAdresse(String stadt, String strasse, String hnr, int plz) throws SQLException
	{
		String sql = "INSERT INTO adresse(stadt, strasse, hnr, plz) VALUES(?,?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1,stadt);
		stmt.setString(2,strasse);
		stmt.setString(3,hnr);
		stmt.setInt(4,plz);
		
		stmt.executeUpdate();
		stmt.close();
	}
	
	public void deleteAdressebyID(int id) throws SQLException
	{
		String sql = "DELETE FROM adresse WHERE adresse_id=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1,id);
		
		stmt.executeUpdate();
		stmt.close();
	}
	
	public ArrayList<Adresse> getAdressen()throws SQLException
	{
		ArrayList<Adresse> adressen = new ArrayList<>();
		
		String sql = "SELECT * FROM adresse";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		System.out.printf("| %20s | %20s | %20s | %20s | %20s |\n","adresse_id","stadt","strasse","hnr","plz");
		
		while(rs.next())
		{
			int adresse_id = rs.getInt("adresse_id");
			String stadt = rs.getString("stadt");
			String strasse = rs.getString("strasse");
			String hnr = rs.getString("hnr");
			int plz = rs.getInt("plz");
			
			System.out.printf("| %20s | %20s | %20s | %20s | %20s |\n",adresse_id,stadt,strasse,hnr,plz);
			
			Adresse a = new Adresse(adresse_id,stadt,strasse,hnr,plz);
			adressen.add(a);
		}
		
		rs.close();
		stmt.close();
		return adressen;
	}
	
	public void updateAdressen(adresse_ update, String value, int adresse_id)throws SQLException
	{
		String sql = "UPDATE adresse SET "+update+" = ? WHERE adresse_id=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		if(update == adresse_.PLZ)
		{
			stmt.setInt(1,Integer.valueOf(value));
		}
		else
		{
			stmt.setString(1,value);
		}
		
		stmt.setInt(2,adresse_id);
		
		stmt.executeUpdate();
		stmt.close();
	}
	

	//--------------------------------------------------Artikel--------------------------------------------------------------
	
	public void createArtikel(String name, double preis) throws SQLException
	{
		String sql = "INSERT INTO artikel(name, preis) VALUES(?,?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1,name);
		stmt.setDouble(2,preis);
		
		stmt.executeUpdate();
		stmt.close();
	}
	
	public void deleteArtikelbyID(int id) throws SQLException
	{
		String sql = "DELETE FROM artikel WHERE artikel_id=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1,id);
		
		stmt.executeUpdate();
		stmt.close();
	}
	
	public ArrayList<Artikel> getArtikel()throws SQLException
	{
		ArrayList<Artikel> artikel = new ArrayList<>();
		
		String sql = "SELECT * FROM artikel";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		System.out.printf("| %20s | %20s | %20s |\n","artikel_id", "name", "preis");
		
		while(rs.next())
		{
			int artikel_id = rs.getInt("artikel_id");
			String name = rs.getString("name");
			double preis = rs.getDouble("preis");
			
			
			System.out.printf("| %20s | %20s | %20s |\n",artikel_id, name, preis);
			
			Artikel a = new Artikel(artikel_id,name,preis);
			artikel.add(a);
		}
		
		rs.close();
		stmt.close();
		return artikel;
	}
	
	public void updateArtikelName(String value, int artikel_id)throws SQLException
	{
		String sql = "UPDATE artikel SET name = ? WHERE artikel_id=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1,value);
		stmt.setInt(2,artikel_id);
		
		stmt.executeUpdate();
		stmt.close();
	}
	
	public void updateArtikelPreis(double value, int artikel_id)throws SQLException
	{
		String sql = "UPDATE artikel SET preis = ? WHERE artikel_id=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setDouble(1,value);
		stmt.setInt(2,artikel_id);
		
		stmt.executeUpdate();
		stmt.close();
	}


	//--------------------------------------------------Bestellung--------------------------------------------------------------
	
	public void createBestellung(int kunde_id, int adresse_rechnung_id, int adresse_liefer_id) throws SQLException
	{
		String sql = "INSERT INTO bestellung(kunde_id, adresse_rechnung_id, adresse_liefer_id) VALUES(?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1,kunde_id);
		stmt.setInt(2,adresse_rechnung_id);
		stmt.setInt(3,adresse_liefer_id);
		
		stmt.executeUpdate();
		stmt.close();
	}
	
	public void deleteBestellung(int id) throws SQLException
	{
		String sql = "DELETE FROM bestellung WHERE bestell_id=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1,id);
		
		stmt.executeUpdate();
		stmt.close();
	}
	
	
	public ArrayList<Bestellung> getBestellung()throws SQLException
	{
		ArrayList<Bestellung> bestellungen = new ArrayList<>();
		
		String sql = "SELECT * FROM bestellung";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		System.out.printf("| %20s | %20s | %20s | %20s |\n","bestell_id", "kunde_id", "adresse_rechnung_id", "adresse_liefer_id");
		
		while(rs.next())
		{
			int id = rs.getInt("bestell_id");
			int kunde_id = rs.getInt("kunde_id");
			int adresse_rechnung_id = rs.getInt("adresse_rechnung_id");
			int adresse_liefer_id = rs.getInt("adresse_liefer_id");

			
			
			System.out.printf("| %20s | %20s | %20s | %20s |\n",id, kunde_id, adresse_rechnung_id, adresse_liefer_id);
			
			Bestellung a = new Bestellung(id,kunde_id,adresse_rechnung_id,adresse_liefer_id);
			bestellungen.add(a);
		}
		
		rs.close();
		stmt.close();
		return bestellungen;
	}
	
	
	public void updateBestellung(bestellung_ update, int value, int adresse_id)throws SQLException
	{
		String sql = "UPDATE bestellung SET "+update+" = ? WHERE bestell_id=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1,value);
		stmt.setInt(2,adresse_id);
		
		stmt.executeUpdate();
		stmt.close();
	}


	//--------------------------------------------------Bestellung_Artikel--------------------------------------------------------------
	
	public void addArtikeltoBestellung(int bestell_id, int artikel_id, int menge) throws SQLException
	{
		String sql = "INSERT INTO bestellung_artikel(bestell_id, artikel_id, menge) VALUES(?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1,bestell_id);
		stmt.setInt(2,artikel_id);
		stmt.setInt(3,menge);
		
		stmt.executeUpdate();
		stmt.close();
	}
	
	public void deleteArtikelfromBestellung(int bestell_id, int artikel_id) throws SQLException
	{
		String sql = "DELETE FROM bestellung_artikel WHERE bestell_id=? AND artikel_id=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1,bestell_id);
		stmt.setInt(2,artikel_id);
		
		stmt.executeUpdate();
		stmt.close();
	}
	
	
	public ArrayList<Bestellung_Artikel> getArtikelBestellung()throws SQLException
	{
		ArrayList<Bestellung_Artikel> artikelbestellungen = new ArrayList<>();
		
		String sql = "SELECT * FROM Bestellung_Artikel";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		System.out.printf("| %20s | %20s | %20s |\n","bestell_id", "artikel_id", "menge");
		
		while(rs.next())
		{
			int bestell_id = rs.getInt("bestell_id");
			int artikel_id = rs.getInt("artikel_id");
			int menge = rs.getInt("menge");

			
			System.out.printf("| %20s | %20s | %20s |\n",bestell_id, artikel_id, menge);
			
			Bestellung_Artikel a = new Bestellung_Artikel(bestell_id,artikel_id,menge);
			artikelbestellungen.add(a);
		}
		
		rs.close();
		stmt.close();
		return artikelbestellungen;
	}
	
	
	public void updateBestellungArtikelMenge(int value, int bestell_id, int artikel_id)throws SQLException
	{
		String sql = "UPDATE bestellung_artikel SET menge = ? WHERE bestell_id=? AND artikel_id=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1,value);
		stmt.setInt(2,bestell_id);
		stmt.setInt(3,artikel_id);
		
		stmt.executeUpdate();
		stmt.close();
	}
}