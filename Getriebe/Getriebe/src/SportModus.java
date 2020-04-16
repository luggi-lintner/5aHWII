import java.math.*;
public class SportModus implements IModus{
	
	//Sportmodus schaltet Später als der Normale Modus
	
	private double gang;
	
	public SportModus() {
		// TODO Auto-generated constructor stub
	}
	
	public void anzeigen(double gang, double g, double l, boolean t)
	{
		System.out.println("Ausgewählter Modus: SPORT  Gang: "+gang +" Geschwindigkeit: "+g+" Leistung: "+l + " Turbo: "+t);
	}
	
@Override
	public void execute(Motor motor) {
		// TODO Auto-generated method stub
	
	if(motor.isTurbolader())
	{
		if(motor.getLeistung()>motor.getGeschwindigkeit()) 
		{
			gang = Math.round(motor.getGeschwindigkeit() / motor.getLeistung()*3);
			
		}
		else
		{
			gang = Math.round((motor.getGeschwindigkeit()*1.2)/motor.getLeistung()*3);
		}
	}
	else if(motor.getLeistung()>motor.getGeschwindigkeit()) 
	{
		gang = Math.round(motor.getGeschwindigkeit() / motor.getLeistung()*2.4);
		
	}
	else
	{
		gang = Math.round((motor.getGeschwindigkeit()*1.2)/motor.getLeistung()*2.4);
	}
	
	anzeigen(gang,motor.getGeschwindigkeit(), motor.getLeistung(),motor.isTurbolader());
		

	}

}
