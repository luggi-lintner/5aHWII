
public class Context {

	private IState state;
	private boolean valid;
	
	
	public void setValid(boolean v)
	{
		valid=v;
	}
	
	public boolean getValid()
	{
		return valid;
	}
	
	public Context()
	{
		setState(new Einfahrt());
		setValid(true);
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
