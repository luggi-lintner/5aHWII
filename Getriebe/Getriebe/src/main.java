
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 Motor motor = new Motor(0,96, false);
	        Getriebe g= new Getriebe(motor);
	        g.modusWechseln(MODUS.NORMAL);
	        g.setGeschwindigkeit(40);
	        g.setGeschwindigkeit(80);
	        g.setGeschwindigkeit(120);
	        System.out.println("");
	        
	        Motor motor2 = new Motor(0,96,true);
	        Getriebe g2= new Getriebe(motor2);
	        g2.modusWechseln(MODUS.NORMAL);
	        g2.setGeschwindigkeit(40);
	        g2.setGeschwindigkeit(80);
	        g2.setGeschwindigkeit(120);
	        System.out.println("");
	        
	        g.modusWechseln(MODUS.SPORT);
	        g.setGeschwindigkeit(40);
	        g.setGeschwindigkeit(80);
	        g.setGeschwindigkeit(120);
	        System.out.println("");
	        
	        g2.modusWechseln(MODUS.SPORT);
	        g2.setGeschwindigkeit(40);
	        g2.setGeschwindigkeit(80);
	        g2.setGeschwindigkeit(120);
	        
	}

}
