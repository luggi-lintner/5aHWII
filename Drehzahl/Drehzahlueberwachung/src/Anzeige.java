
public class Anzeige implements IObserver {

	@Override
	public void aktualisiern(int drehzahl) {
		// TODO Auto-generated method stub
		if(drehzahl >6321)
		{
			System.out.println("Drehzahl zu groﬂ!! Drehzahl:"+drehzahl);
		}
		
		else
		{
			System.out.println("Drehzahl im richtigen Bereich. Drehzahl:"+drehzahl);
		}
		
	}
	
	

}
