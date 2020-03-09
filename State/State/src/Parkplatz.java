
public class Parkplatz implements IState{

	@Override
	public void goNext(Context c) {
		// TODO Auto-generated method stub
		
		if(c.getValid()==true)
		{	
			System.out.println("Parkplatz gefunden");
			c.setState(new Entwerten());
		}
		else
		{
			System.out.println("Keinen Parkplatz gefunden");
			c.setState(new Einfahrt());
		}
		
		
	}

}
