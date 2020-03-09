
public class Einfahrt implements IState {

	@Override
	public void goNext(Context c) {
		
		if(c.getValid()==true)
		{
			System.out.println("Willkommen im Parkhaus");
			c.setState(new Parkplatz());
		}
		else
		{
			System.out.println("Schranke auﬂer Betrieb");
			c.setState(new Einfahrt());
		}
	}
	
	

}
