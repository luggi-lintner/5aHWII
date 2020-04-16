
public class Getriebe {
	
	private IModus modus;
	private Motor motor;
	
	public void setGeschwindigkeit (double geschwindigkeit)
	{
		motor.setGeschwindigkeit(geschwindigkeit);
		
		execute();
		
		
	}
	public Getriebe (Motor motor)
	{
		this.motor=motor;
	}

	public void execute()
	{
		modus.execute(motor);
	}
	
	public void modusWechseln(MODUS m)
	{
		if(m == MODUS.NORMAL)
		{
			this.modus = new NormalModus();
		}
		/*if(m == MODUS.SPORT)
		{
			this.modus = new SportModus();
		}*/
		
		
	}
	
	
	
}
