package main;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Observerable.setValue_new(2);
		for(int i=0; i<=5; i++)
		{
			if(Observerable.getValue_new() != Observerable.getValue_old())
		{
			Observer.update(Observerable.getValue_new());
			Observerable.setValue_old(Observerable.getValue_new());
			System.out.println("Alt: "+Observerable.getValue_old());
			System.out.println("Neu: "+Observerable.getValue_new());
		}
			

	}

}
}
