package DBManager;

public class Bestellung
{
	private int id;
	private int kunde_id;
	private int adresse_rechnung_id;
	private int adresse_liefer_id;
	
	public Bestellung(int id, int kunde_id, int adresse_rechnung_id, int adresse_liefer_id)
	{
		this.id = id;
		this.kunde_id = kunde_id;
		this.adresse_rechnung_id = adresse_rechnung_id;
		this.adresse_liefer_id = adresse_liefer_id;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getKunde_id()
	{
		return kunde_id;
	}

	public void setKunde_id(int kunde_id)
	{
		this.kunde_id = kunde_id;
	}

	public int getAdresse_rechnung_id()
	{
		return adresse_rechnung_id;
	}

	public void setAdresse_rechnung_id(int adresse_rechnung_id)
	{
		this.adresse_rechnung_id = adresse_rechnung_id;
	}

	public int getAdresse_liefer_id()
	{
		return adresse_liefer_id;
	}

	public void setAdresse_liefer_id(int adresse_liefer_id)
	{
		this.adresse_liefer_id = adresse_liefer_id;
	}
}