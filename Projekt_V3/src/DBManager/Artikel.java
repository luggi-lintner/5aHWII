
package DBManager;
public class Artikel
{
	private int artikel_id;
	private String name;
	private double preis;
	
	public Artikel(int artikel_id, String name, double preis)
	{
		this.artikel_id = artikel_id;
		this.name = name;
		this.preis = preis;
	}

	public int getArtikel_id()
	{
		return artikel_id;
	}

	public void setArtikel_id(int artikel_id)
	{
		this.artikel_id = artikel_id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public double getPreis()
	{
		return preis;
	}

	public void setPreis(double preis)
	{
		this.preis = preis;
	}
}