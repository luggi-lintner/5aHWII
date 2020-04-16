import java.math.*;
public class NormalModus implements IModus{

	private double gang;
	public NormalModus() {
		// TODO Auto-generated constructor stub
	}
	
	//Meine Überlegung zum Schaltvorgang (möglicherweise unrealistisch): Auto mit höherer Leistung schaltet später
	// Auto mit Turbo schaltet früher
	public void anzeigen(double gang, double g, double l, boolean t)
	{
		System.out.println("Ausgewählter Modus: NORMAL  Gang: "+gang +" Geschwindigkeit: "+g+" Leistung: "+l + " Turbo: "+t);
	}
	public void execute(Motor motor)
	{
		if(motor.isTurbolader())
		{
			if(motor.getLeistung()>motor.getGeschwindigkeit()) 
			{
				gang = Math.round(motor.getGeschwindigkeit() / motor.getLeistung()*4);
				
			}
			else
			{
				gang = Math.round((motor.getGeschwindigkeit()*1.2)/motor.getLeistung()*4);
			}
		}
		else if(motor.getLeistung()>motor.getGeschwindigkeit()) 
		{
			gang = Math.round(motor.getGeschwindigkeit() / motor.getLeistung()*3.2);
			
		}
		else
		{
			gang = Math.round((motor.getGeschwindigkeit()*1.2)/motor.getLeistung()*3.2);
		}
		
		anzeigen(gang,motor.getGeschwindigkeit(), motor.getLeistung(),motor.isTurbolader());
		
		
	}
}

