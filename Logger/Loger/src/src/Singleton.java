package src;
import java.io.*;

public class Singleton {
	
	private static Singleton instance;
	public String logname = "logname";
	private static File logFile;
	private PrintWriter writer;
	
	

	public static Singleton getInstance(){
		if(instance == null)
		{
			instance = new Singleton();
		}
		return instance;
	}

	private void Singleton(){
		try 
		{
			writer= new PrintWriter(new FileWriter("log.txt",true));
			writer.println("Erste Zeile:");
			writer.println("Zweite Zeile");
			writer.flush();
			writer.close();
		}
		catch (FileNotFoundException | UnsupportedEncodingException e)
		{
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void log(String message){
		try{
			FileWriter out = new FileWriter(Singleton.logFile, true);
			out.write(message.toCharArray());
			out.close();
		}catch(IOException e){
			System.err.println("ERROR: Could not write to log file");
		}
	}
	
	

}
