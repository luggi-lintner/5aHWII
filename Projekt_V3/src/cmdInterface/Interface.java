package cmdInterface;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import DBManager.*;

public class Interface
{
	public static void mainMenu()
	{
		while(true)
		{
			int selection;
			Scanner scan = new Scanner(System.in);
			
			do
			{
				System.out.println("--------------------------------------");
				System.out.println("1....Kunden");
				System.out.println("2....Adressen");
				System.out.println("3....Artikel");
				System.out.println("4....Bestellungen");
				System.out.println("5....Beenden");
				System.out.println("--------------------------------------");
				
				System.out.print("Auswahl: ");
				selection = scan.nextInt();
				
				System.out.flush(); 
			}while(selection > 6 || selection < 1);
			
			switch(selection)
			{
			case 1: selectionMenu("Kunden"); break;
			case 2: selectionMenu("Adressen"); break;
			case 3: selectionMenu("Artikel"); break;
			case 4: bestellungMenu(); break;
			default: scan.close(); System.exit(0);
			}
		}
	}
	
	public static void selectionMenu(String type)
	{
		while(true)
		{
			int selection;
			Scanner scan = new Scanner(System.in);
			
			do
			{
				System.out.println("--------------------------------------");
				System.out.println(type+"-ANSICHT");
				System.out.println("--------------------------------------");
				System.out.println("1...."+type+" erstellen");
				System.out.println("2...."+type+" anzeigen");
				System.out.println("3...."+type+" löschen");
				System.out.println("4...."+type+" bearbeiten ");
				System.out.println("5....Zurück zur Auswahl");
				System.out.println("--------------------------------------");
				
				System.out.print("Auswahl: ");
				selection = scan.nextInt();
				System.out.flush(); 
			}while(selection > 6 || selection < 1);
	
			
			if(selection == 1)
			{
				if(type.equals("Kunden")) kundeErstellen();
				else if(type.equals("Adressen")) adresseErstellen();
				else if(type.equals("Artikel")) artikelErstellen();
			}
			else if(selection == 2) 
			{
				anzeigen(type);
			}
			else if(selection == 3) 
			{
				löschen(type);
			}
			else if(selection == 4)
			{
				if(type.equals("Kunden")) kundeBearbeiten();
				else if(type.equals("Adressen")) adresseBearbeiten();
				else if(type.equals("Artikel")) artikelBearbeiten();
			}
			else
			{
				return;
			}
		}
	}
	
	public static void kundeErstellen()
	{
		String vorname=null;
		String nachname=null;
		String titelv=null;
		String titeln=null;
		
		Scanner scan = new Scanner(System.in);
		
		do
		{
			System.out.println("--------------------------------------");
			System.out.println("Kunde Erstellen");
			System.out.println("--------------------------------------");
			
			System.out.print("Vorname: "); vorname = scan.next();
			System.out.print("Nachname: "); nachname = scan.next();
			System.out.print("Titel vorne: "); titelv = scan.next();
			System.out.print("Titel hinten: "); titeln = scan.next();
			
			System.out.flush(); 
		}while(!isStringOnlyAlphabet(vorname) || !isStringOnlyAlphabet(nachname) || !isStringOnlyAlphabet(titelv) || !isStringOnlyAlphabet(titeln));
		
		try
		{
			DBManager db=new DBManager();
			db.createKunde(titelv, titeln, vorname, nachname);
			db.close();
			
		} catch (ClassNotFoundException | SQLException e)
		{
			System.out.println("Fehler beim Erstellen aufgetreten. Ein Kunde mit diesen Eigenschaften könnte schon existieren!");
		}
	}
	
	
	public static void adresseErstellen()
	{
		String stadt=null;
		String strasse=null;
		String hnr=null;
		int plz=0;
		
		Scanner scan = new Scanner(System.in);
		
		do
		{
			System.out.println("--------------------------------------");
			System.out.println("Adresse Erstellen");
			System.out.println("--------------------------------------");
			
			System.out.print("Stadt: "); stadt = scan.next();
			System.out.print("Strasse: "); strasse = scan.next();
			System.out.print("Hausnummer: "); hnr = scan.next();
			try
			{
				System.out.print("PLZ: "); plz = scan.nextInt();
			}catch(InputMismatchException e)
			{
				System.out.println("Fehlerhafte Eingabe...PLZ ist eine Zahl.");
				scan.next();
				continue;
			}

			System.out.flush(); 
		}while(!isStringOnlyAlphabet(stadt) || !isStringOnlyAlphabet(strasse) || !isStringOnlyAlphabet(hnr) || plz==0);
		
		try
		{
			DBManager db=new DBManager();
			db.createAdresse(stadt, strasse, hnr, plz);
			db.close();
			
		} catch (ClassNotFoundException | SQLException e)
		{
			System.out.println("Fehler beim Erstellen aufgetreten. Eine Adresse mit diesen Eigenschaften könnte schon existieren! ");
		}
	}
	
	
	public static void artikelErstellen()
	{
		String name=null;
		double preis=0;
		
		Scanner scan = new Scanner(System.in);
		
		do
		{
			System.out.println("--------------------------------------");
			System.out.println("Artikel Erstellen");
			System.out.println("--------------------------------------");

			System.out.print("Name: "); name = scan.next();
			System.out.print("Preis: "); preis = scan.nextDouble();			
			
			System.out.flush(); 
		}while(!isStringOnlyAlphabet(name));
		
		try
		{
			DBManager db=new DBManager();
			db.createArtikel(name, preis);
			db.close();
			
		} catch (ClassNotFoundException | SQLException e)
		{
			System.out.println("Fehler beim Erstellen aufgetreten. Ein Artikel mit diesen Eigenschaften könnte schon existieren! ");
		}
	}
	
	
	public static void anzeigen(String type)
	{
		try
		{
			DBManager db=new DBManager();
			if(type.equals("Kunden"))
			{
				db.getKunden();
			}
			else if(type.equals("Adressen"))
			{
				db.getAdressen();
			}
			else if(type.equals("Artikel"))
			{
				db.getArtikel();
			}
			else if(type.equals("Bestellungen"))
			{
				db.getBestellung();
			}
			else if(type.equals("Bestellung_Artikel"))
			{
				db.getArtikelBestellung();
			}
			db.close();
			
		} catch (ClassNotFoundException | SQLException e)
		{
			System.out.println("Fehler beim Anzeigen aufgetreten.");
			e.printStackTrace();
		}
	}
	
	
	public static void löschen(String type)
	{

		String selector;
		Scanner scan = new Scanner(System.in);
		
		do
		{
			System.out.println("--------------------------------------");
			System.out.println(type+" Löschen");
			System.out.println("--------------------------------------");
			
			System.out.print("ID des zu löschenden "+type+" angeben (mit Befehl show können alle "+type+" angezeigt werden): ");
			selector = scan.next();
			
			if(selector.equals("show"))
			{
				anzeigen(type);
			}
			
			System.out.flush(); 
		}while(!selector.matches("[0-9]+"));
		
		try
		{
			DBManager db=new DBManager();
			if(type.equals("Kunden"))
			{
				db.deleteKundebyID(Integer.valueOf(selector));
			}
			else if(type.equals("Adressen"))
			{
				db.deleteAdressebyID(Integer.valueOf(selector));
			}
			else if(type.equals("Artikel"))
			{
				db.deleteArtikelbyID(Integer.valueOf(selector));
			}
			else if(type.equals("Bestellungen"))
			{
				db.deleteBestellung(Integer.valueOf(selector));
			}
			
			db.close();
			
		} catch (ClassNotFoundException | SQLException e)
		{
			System.out.println("Fehler beim Löschen aufgetreten.");
			e.printStackTrace();
		}
	}
	
	public static void kundeBearbeiten()
	{
		String selector;
		String value=null;
		DBManager.kunde_ kundeEnum = null;
		
		Scanner scan = new Scanner(System.in);
		
		do
		{
			System.out.println("--------------------------------------");
			System.out.println("Kunde Bearbeiten");
			System.out.println("--------------------------------------");
			
			System.out.print("ID angeben (Befehl \"show\" für alle Kunden): ");
			selector = scan.next();
			
			if(selector.equals("show"))
			{
				anzeigen("Kunden");
				continue;
			}
			
			
			try
			{

				System.out.print("Attribut angeben (nachname, vorname, titelv, titeln): ");
				kundeEnum = DBManager.kunde_.valueOf(scan.next().toUpperCase());
				System.out.print("Neuer Wert: ");
				value = scan.next();
				
			}catch(IllegalArgumentException e)
			{
				System.out.println("Attribut existiert nicht!");
				continue;
			}
			
			System.out.flush(); 
		}while(!selector.matches("[0-9]+") || kundeEnum==null || !isStringOnlyAlphabet(value));
		
		try
		{
			DBManager db=new DBManager();
			db.updateKunde(kundeEnum, value, Integer.valueOf(selector));
			db.close();
			
		} catch (ClassNotFoundException | SQLException e)
		{
			System.out.println("Fehler beim bearbeiten aufgetreten.");
		}
	}
	
	
	public static void adresseBearbeiten()
	{
		String selector;
		String value=null;
		double value2=0.0;
		boolean check=true;
		DBManager.adresse_ adresseEnum = null;
		
		Scanner scan = new Scanner(System.in);
		
		do
		{
			System.out.println("--------------------------------------");
			System.out.println("Adresse Bearbeiten");
			System.out.println("--------------------------------------");
			
			System.out.print("ID angeben (Befehl \"show\" für alle Adressen): ");
			selector = scan.next();
			
			if(selector.equals("show"))
			{
				anzeigen("Adressen");
				continue;
			}
			
			try
			{
				System.out.print("Attribut angeben (stadt, strasse, plz, hnr): ");
				adresseEnum = DBManager.adresse_.valueOf(scan.next().toUpperCase());
				System.out.print("Neuer Wert: "); value = scan.next();
				
				check = !selector.matches("[0-9]+") || adresseEnum==null;
				if(!(adresseEnum == DBManager.adresse_.PLZ || adresseEnum == DBManager.adresse_.HNR))
				{
					check = check || !isStringOnlyAlphabet(value);
				}
				
			}catch(IllegalArgumentException e)
			{
				System.out.println("Attribut existiert nicht!");
				continue;
			}
			
			System.out.flush(); 
		}while(check);
		
		try
		{
			DBManager db=new DBManager();
			db.updateAdressen(adresseEnum, value, Integer.valueOf(selector));
			db.close();
			
		} catch (ClassNotFoundException | SQLException e)
		{
			System.out.println("Fehler beim bearbeiten aufgetreten.");
		}
	}
	
	
	public static void artikelBearbeiten()
	{
		String selector;
		String value=null;
		double value2=0.0;
		
		DBManager.artikel_ artikelEnum = null;
		
		boolean check=true;
		Scanner scan = new Scanner(System.in);
		
		do
		{
			System.out.println("--------------------------------------");
			System.out.println("Artikel Bearbeiten");
			System.out.println("--------------------------------------");
			
			System.out.print("ID angeben (Befehl \"show\" für alle Artikel: ");
			selector = scan.next();
			
			if(selector.equals("show"))
			{
				anzeigen("Artikel");
				continue;
			}
			
			
			try
			{
				System.out.print("Attribut angeben (name, preis): ");
				artikelEnum = DBManager.artikel_.valueOf(scan.next().toUpperCase());
				if(artikelEnum == DBManager.artikel_.NAME) {System.out.print("Neuer Wert: "); value = scan.next();}
				if(artikelEnum == DBManager.artikel_.PREIS) {System.out.print("Neuer Wert: "); value2 = scan.nextDouble();}
				
				check = !selector.matches("[0-9]+") || artikelEnum==null;
				if(artikelEnum == DBManager.artikel_.NAME)
				{
					check = check || !isStringOnlyAlphabet(value);
				}
				
			}
			catch(IllegalArgumentException e)
			{
				System.out.println("Attribut existiert nicht!");
				continue;
			}
			catch(InputMismatchException a)
			{
				System.out.println("Fehlerhafte Eingabe...Preis ist eine Zahl.");
				scan.next();
				continue;
			}
			
			System.out.flush(); 
		}while(check);
		
		try
		{
			DBManager db=new DBManager();
			if(artikelEnum == DBManager.artikel_.NAME) db.updateArtikelName(value, Integer.valueOf(selector));
			if(artikelEnum == DBManager.artikel_.PREIS) db.updateArtikelPreis(value2, Integer.valueOf(selector));
			db.close();
			
		} catch (ClassNotFoundException | SQLException e)
		{
			System.out.println("Fehler beim bearbeiten aufgetreten.");
		}
	}
	
	public static void bestellungMenu()
	{
		while(true)
		{
			int selection;
			Scanner scan = new Scanner(System.in);
			
			do
			{
				System.out.println("--------------------------------------");
				System.out.println("BESTELLUNGS-ANSICHT");
				System.out.println("--------------------------------------");
				System.out.println("1....Bestellung erstellen");
				System.out.println("2....Bestellungen anzeigen");
				System.out.println("3....Bestellung löschen");
				System.out.println("4....Bestellung bearbeiten ");
				System.out.println("5....Artikel zu Bestellung hinzufügen ");
				System.out.println("6....Artikel einer Bestellung anzeigen ");
				System.out.println("7....Artikel von Bestellung löschen ");
				System.out.println("8....Artikel von Bestellung bearbeiten(Menge) ");
				System.out.println("9....Zurück zur Auswahl");
				System.out.println("--------------------------------------");
				
				System.out.print("Auswahl: ");
				selection = scan.nextInt();
				System.out.flush(); 
			}while(selection > 10 || selection < 1);
	
			
			if(selection == 1) { bestellungErstellen();}
			else if(selection == 2) {anzeigen("Bestellungen");}
			else if(selection == 3) {löschen("Bestellungen");}
			else if(selection == 4) {bestellungBearbeiten();}
			else if(selection == 5) {artikeltoBestellung();}
			else if(selection == 6) {anzeigen("Bestellung_Artikel");}
			else if(selection == 7) {bestellungArtikelLöschen();}
			else if(selection == 8) {bestellungArtikelBearbeiten();}
			else {return;}
		}
	}
	
	
	public static void bestellungErstellen()
	{
		String selector;
		int kunde_id=0;
		int adresse_rechnung_id=0;
		int adresse_liefer_id;
		
		Scanner scan = new Scanner(System.in);
		
		do
		{
			System.out.println("--------------------------------------");
			System.out.println("Bestellung Erstellen");
			System.out.println("--------------------------------------");
			
			System.out.print("Infos zu Kunden/Adressen angeben mit Befehl \"show\" | \"w\" um Fortzufahren: ");
			selector = scan.next();
			
			if(selector.equals("show"))
			{
				System.out.println("Adressen: ");
				anzeigen("Adressen");
				System.out.println("\nKunden: ");
				anzeigen("Kunden");
				continue;
			}
			
			try
			{
				System.out.print("Kunden ID: "); kunde_id = scan.nextInt();
				System.out.print("Liefer-Adresse ID: "); adresse_rechnung_id = scan.nextInt();
				System.out.print("Liefer-Rechnung ID: "); adresse_liefer_id = scan.nextInt();
			}catch(InputMismatchException e)
			{
				System.out.println("Fehlerhafte Eingabe. Es dürfen nur Zahlen eingegeben werden");
				scan.next();
				continue;
			}
			System.out.flush(); 
			break;
		}while(true);
		
		try
		{
			DBManager db=new DBManager();
			db.createBestellung(kunde_id, adresse_rechnung_id, adresse_liefer_id);
			db.close();
			
		} catch (ClassNotFoundException | SQLException e)
		{
			System.out.println("Fehler beim Erstellen aufgetreten.");
		}
	}
	
	public static void bestellungBearbeiten()
	{
		String selector;
		int value=0;
		DBManager.bestellung_ bestellungEnum = null;
		
		Scanner scan = new Scanner(System.in);
		
		do
		{
			System.out.println("--------------------------------------");
			System.out.println("Bestellung Bearbeiten");
			System.out.println("--------------------------------------");
			
			System.out.print("ID angeben (Befehl \"show\" für alle Bestellungen/Kunden/Adressen): ");
			selector = scan.next();
			
			if(selector.equals("show"))
			{
				anzeigen("Bestellungen");
				System.out.println("\n\nKunden:");
				anzeigen("Kunden");
				System.out.println("\n\nAdressen:");
				anzeigen("Adressen");
				continue;
			}
			
			
			try
			{

				System.out.print("Attribut angeben (kunde_id, adresse_rechnung_id, adresse_liefer_id): ");
				bestellungEnum = DBManager.bestellung_.valueOf(scan.next().toUpperCase());
				System.out.print("Neuer Wert: ");
				value = scan.nextInt();
				
			}
			catch(IllegalArgumentException e)
			{
				System.out.println("Attribut existiert nicht!");
				continue;
			}
			catch(InputMismatchException a)
			{
				System.out.println("Fehlerhafte Eingabe. Eingabe ist eine Zahl.");
				scan.next();
				continue;
			}
			
			System.out.flush(); 
		}while(!selector.matches("[0-9]+") || bestellungEnum==null);
		
		try
		{
			DBManager db=new DBManager();
			db.updateBestellung(bestellungEnum, value, Integer.valueOf(selector));
			db.close();
			
		} catch (ClassNotFoundException | SQLException e)
		{
			System.out.println("Fehler beim Bearbeiten aufgetreten.");
		}
	}
	
	public static void artikeltoBestellung()
	{
		String selector;
		int bestell_id=0;
		int artikel_id=0;
		int menge=0;
		
		Scanner scan = new Scanner(System.in);
		
		do
		{
			System.out.println("--------------------------------------");
			System.out.println("Artikel zu Bestellung hinzufügen");
			System.out.println("--------------------------------------");
			
			System.out.print("Infos zu Kunden/Adressen/Artikel/Bestellung mit Befehl \"show\" | \"w\" um Fortzufahren: ");
			selector = scan.next();
			
			if(selector.equals("show"))
			{
				System.out.println("Bestellungen: ");
				anzeigen("Bestellungen");
				System.out.println("\n\nAdressen: ");
				anzeigen("Adressen");
				System.out.println("\n\nKunden: ");
				anzeigen("Kunden");
				System.out.println("\n\nArtikel: ");
				anzeigen("Artikel");
				continue;
			}
			
			try
			{
				System.out.print("Bestell ID: "); bestell_id = scan.nextInt();
				System.out.print("Artikel ID: "); artikel_id = scan.nextInt();
				System.out.print("Menge: "); menge = scan.nextInt();
			}catch(InputMismatchException e)
			{
				System.out.println("Fehlerhafte Eingabe. Es dürfen nur Zahlen eingegeben werden");
				scan.next();
				continue;
			}
			System.out.flush(); 
			break;
		}while(true);
		
		try
		{
			DBManager db=new DBManager();
			db.addArtikeltoBestellung(bestell_id, artikel_id, menge);
			db.close();
			
		} catch (ClassNotFoundException | SQLException e)
		{
			System.out.println("Fehler beim Erstellen aufgetreten.");
			e.printStackTrace();
		}
	}
	
	
	public static void bestellungArtikelLöschen()
	{

		String selector;
		int bestell_id=0;
		int artikel_id=0;
		Scanner scan = new Scanner(System.in);
		
		do
		{
			System.out.println("--------------------------------------");
			System.out.println("Artikel von Bestellung löschen");
			System.out.println("--------------------------------------");
			
			System.out.print("Infos zu Bestellungen/Bestellten Artikeln mit Befehl \"show\" | \"w\" um Fortzufahren: ");
			selector = scan.next();
			
			if(selector.equals("show"))
			{
				System.out.println("Bestellte Artikel: ");
				anzeigen("Bestellung_Artikel");
				System.out.println("\n\nBestellungen: ");
				anzeigen("Bestellungen");
				System.out.println("\n\nArtikel: ");
				anzeigen("Artikel");
				continue;
			}
			
			try
			{
				System.out.print("Bestell ID: "); bestell_id = scan.nextInt();
				System.out.print("Artikel ID: "); artikel_id = scan.nextInt();
			}catch(InputMismatchException e)
			{
				System.out.println("Fehlerhafte Eingabe. Es dürfen nur Zahlen eingegeben werden");
				scan.next();
				continue;
			}
			System.out.flush(); 
			break;
		}while(!selector.matches("[0-9]+"));
		
		try
		{
			DBManager db=new DBManager();
			db.deleteArtikelfromBestellung(bestell_id, artikel_id);
			db.close();
			
		} catch (ClassNotFoundException | SQLException e)
		{
			System.out.println("Fehler beim Löschen aufgetreten.");
			e.printStackTrace();
		}
	}
	
	
	public static void bestellungArtikelBearbeiten()
	{
		String selector;
		int bestell_id=0;
		int artikel_id=0;
		int value=0;
		
		Scanner scan = new Scanner(System.in);
		
		do
		{
			System.out.println("--------------------------------------");
			System.out.println("Artikel von Bestellung bearbeiten");
			System.out.println("--------------------------------------");
			
			System.out.print("Infos zu Bestellungen/Bestellten Artikeln mit Befehl \"show\" | \"w\" um Fortzufahren: ");
			selector = scan.next();
			
			if(selector.equals("show"))
			{
				System.out.println("Bestellte Artikel: ");
				anzeigen("Bestellung_Artikel");
				System.out.println("\n\nBestellungen: ");
				anzeigen("Bestellungen");
				System.out.println("\n\nArtikel: ");
				anzeigen("Artikel");
				continue;
			}
			
			try
			{
				System.out.print("Bestell ID: "); bestell_id = scan.nextInt();
				System.out.print("Artikel ID: "); artikel_id = scan.nextInt();
				System.out.print("Neue Menge: "); value = scan.nextInt();
			}catch(InputMismatchException e)
			{
				System.out.println("Fehlerhafte Eingabe. Es dürfen nur Zahlen eingegeben werden");
				scan.next();
				continue;
			}
			System.out.flush(); 
			break;
		}while(!selector.matches("[0-9]+"));
		
		try
		{
			DBManager db=new DBManager();
			db.updateBestellungArtikelMenge(value, bestell_id, artikel_id);
			db.close();
			
		} catch (ClassNotFoundException | SQLException e)
		{
			System.out.println("Fehler beim bearbeiten aufgetreten.");
			e.printStackTrace();
		}
	}
	

	public static boolean isStringOnlyAlphabet(String str) 
	{ 
	    return ((!str.equals("")) && (str != null) && (str.matches("^[a-zA-Z]*$"))); 
	} 

	
	public static void main(String[] args)
	{
		mainMenu();
	}
}
