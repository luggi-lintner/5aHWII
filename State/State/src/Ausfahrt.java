
public class Ausfahrt implements IState {

	@Override
	public void goNext(Context c) {
		// TODO Auto-generated method stub
		
			System.out.println("Parkhaus verlassen. Auf Wiedersehn!");
			System.out.println(" ");
			c.setState(new Einfahrt());
		
	}

}
