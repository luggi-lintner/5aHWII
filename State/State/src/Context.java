
public class Context {

	private IState state;
	private boolean valid;
	
	
	public Context()
	{
		setState(new Einfahrt());
	}
	public void setState(IState state)
	{
		this.state=state;
	}


	public void goNext()
	{
		state.goNext(this);
	}
	
		
	
	
}
