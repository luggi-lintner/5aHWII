import java.util.ArrayList;


public class Drehzahl implements IObserver {
	
	private ArrayList<Anzeige> subscriber = new ArrayList<Anzeige>();
	private int drehzahl;

	@Override
	public void aktualisiern(int drehzahl) {
		// TODO Auto-generated method stub
		
		this.drehzahl = drehzahl;
		sendData();
		
	}
	
	public Drehzahl() {
		// TODO Auto-generated constructor stub
	}
	
	public void subscribe(Anzeige anzeige)
	{
		subscriber.add(anzeige);
	}
	
	public void sendData()
	{
		for(Anzeige k : subscriber)
			k.aktualisiern(drehzahl);
	}
	
	
	
	

}
