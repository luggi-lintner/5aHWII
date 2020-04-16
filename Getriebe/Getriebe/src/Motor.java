
public class Motor {
	
	private double geschwindigkeit;
	private double leistung;
	private boolean turbolader;
	
	public Motor(int geschwindigkeit, int leistung, boolean turbolader) {
		// TODO Auto-generated constructor stub
		this.geschwindigkeit = geschwindigkeit;
		this.leistung = leistung;
		this.turbolader = turbolader;
	}
	
	public double getGeschwindigkeit() {
		return geschwindigkeit;
	}
	
	public void setGeschwindigkeit(double geschwindigkeit) {
		this.geschwindigkeit = geschwindigkeit;
	}
	
	
	public double getLeistung() {
		return leistung;
	}
	
	public void setLeistung(double leistung) {
		this.leistung = leistung;
	}
	
	
	public boolean isTurbolader() {
		return turbolader;
	}
	
	public void setTurbolader(boolean turbolader) {
		this.turbolader = turbolader;
	}
	
	

}
