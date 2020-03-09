import java.awt.TextComponent;

public class TestClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Context testcontext = new Context();
		
		//System.out.println("Fehlerfreier durchlauf/Valid = true");
		//testcontext.setValid(true);
		testcontext.goNext();
		testcontext.goNext();
		testcontext.goNext();
		testcontext.goNext();
		
		//System.out.println("Valid bereits am Anfang False");
		testcontext.setValid(false);
		testcontext.goNext();
		System.out.println(" ");
		
		
		testcontext.goNext();
		testcontext.setValid(false);
		testcontext.goNext();
		testcontext.goNext();
		
		testcontext.setValid(true);
		testcontext.goNext();
		testcontext.goNext();
		testcontext.goNext();
		testcontext.goNext();
		
		
		
		
		
	}

}
