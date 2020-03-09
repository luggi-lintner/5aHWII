
public class Entwerten implements IState{

	@Override
	public void goNext(Context c) {
		// TODO Auto-generated method stub
		
			System.out.println("Ticket Entwertet");
			c.setState(new Ausfahrt());
		
		
		
	}

}
