
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Drehzahl fahrzeug1 = new Drehzahl();
		
		Anzeige displayFahrzeug1 = new Anzeige();
		
		fahrzeug1.subscribe(displayFahrzeug1);
		
		for(int i=6250; i<=6400; i++)
		{
			fahrzeug1.aktualisiern(i);
		}
		
		for(int i=6400; i>=6250; i--)
		{
			fahrzeug1.aktualisiern(i);
		}
		

	}

}
