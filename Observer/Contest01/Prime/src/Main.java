
public class Main {
	
	public static boolean isPrime(int n) {
	    //check if n is a multiple of 2
	   if (n==1)
	   {
		   return false;
	   }
		if (n%2==0) return false;
	    //if not, then just check the odds
	    for(int i=3;i*i<=n;i+=2) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		System.out.println(isPrime(4567));
		System.out.println(isPrime(3));
		System.out.println(isPrime(1));
		
	}

}
