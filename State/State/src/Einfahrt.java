
public class Einfahrt implements IState {

	@Override
	public void goNext(Context c) {
		
		System.out.println("Willkommen im Parkhaus");
		c.setState(new Parkplatz());
		
	}
	
	

}
