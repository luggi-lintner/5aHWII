package DBManager;

public class Kunde 
{
	private int kunde_id;
	private String titelv;
	private String titeln;
	private String vorname;
	private String nachname;
	
	
	
	public Kunde(int kunde_id, String titelv, String titeln, String vorname, String nachname) 
	{
		super();
		this.kunde_id = kunde_id;
		this.titelv = titelv;
		this.titeln = titeln;
		this.vorname = vorname;
		this.nachname = nachname;
	}
	public int getKunde_id() 
	{
		return kunde_id;
	}
	public void setKunde_id(int kunde_id) 
	{
		this.kunde_id = kunde_id;
	}
	public String getTitelv() 
	{
		return titelv;
	}
	public void setTitelv(String titelv) 
	{
		this.titelv = titelv;
	}
	public String getTiteln() 
	{
		return titeln;
	}
	public void setTiteln(String titeln) 
	{
		this.titeln = titeln;
	}
	public String getVorname() 
	{
		return vorname;
	}
	public void setVorname(String vorname) 
	{
		this.vorname = vorname;
	}
	public String getNachname() 
	{
		return nachname;
	}
	public void setNachname(String nachname) 
	{
		this.nachname = nachname;
	}
}