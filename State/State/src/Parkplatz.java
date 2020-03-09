
public class Parkplatz implements IState{

	@Override
	public void goNext(Context c) {
		// TODO Auto-generated method stub
		
		System.out.println("Parkplatz gefunden");
		c.setState(new Entwerten());
		
	}

}
