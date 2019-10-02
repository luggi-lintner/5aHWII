package main;
import java.util.*;

public class Observerable {

	private ArrayList<Observer> observer;
	private  static int value_old;
	private static  int value_new;
	
	public Observerable() {
		observer = new ArrayList<Observer>();
		
		
		
	}
	
	public void notifyAllObservers()
	{
		
		Observer.update(value_new);
	}
	
	public static void setValue_new(int value_new) {
		Observerable.value_new = value_new;
	}
	
	public static void setValue_old(int value_old) {
		Observerable.value_old = value_old;
	}
	
	public static int getValue_old() {
		return value_old;
	}
	public static int getValue_new()
	{
		return value_new;
	}
	
	public void subscribe(Observer name) {
	observer.add(name);	
		
	}
	
	public void unsubscribe(Observer name) {
		observer.remove(name);
		
	}
	
	/*public static void main(String[] args) {
		
		
		setValue_new(2);
		for(int i=0; i<=5; i++)
		{
		if(value_old != value_new)
		{
			Observer.update(value_new);
			value_old = value_new;
		}
		System.out.println("Alt: "+value_old);
		System.out.println("Neu: "+value_new);
		}
		setValue_new(20);
		for(int i=0; i<=5; i++)
		{
		if(value_new != value_old)
		{
			Observer.update(value_new);
			value_old = value_new;
		}
		System.out.println("Alt: "+value_old);
		System.out.println("Neu: "+value_new);
		}
		setValue_new(15);
		for(int i=0; i<=5; i++)
		{
		if(value_new != value_old)
		{
			Observer.update(value_new);
			value_old = value_new;
		}
		System.out.println("Alt: "+value_old);
		System.out.println("Neu: "+value_new);
		}
		
	}*/
}






	
	