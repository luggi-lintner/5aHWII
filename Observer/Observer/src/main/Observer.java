package main;

public interface Observer{
	
	public static void update(int temp)
	{
		System.out.println("Aktuelle Temperatur: "+temp);
	}
	
	

}
