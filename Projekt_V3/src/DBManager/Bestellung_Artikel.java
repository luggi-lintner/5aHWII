package DBManager;

public class Bestellung_Artikel
{
	private int bestell_id;
	private int bestellung;
	private int menge;
	
	public Bestellung_Artikel(int bestell_id, int bestellung, int menge)
	{
		this.bestell_id = bestell_id;
		this.bestellung = bestellung;
		this.menge = menge;
	}

	public int getBestell_id()
	{
		return bestell_id;
	}

	public void setBestell_id(int bestell_id)
	{
		this.bestell_id = bestell_id;
	}

	public int getBestellung()
	{
		return bestellung;
	}

	public void setBestellung(int bestellung)
	{
		this.bestellung = bestellung;
	}

	public int getMenge()
	{
		return menge;
	}

	public void setMenge(int menge)
	{
		this.menge = menge;
	}
}