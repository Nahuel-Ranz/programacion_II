public class SumaDigitos{
	
	public static void main(String []args){
		System.out.println("Suma de dígitos del número 3425: "+ suma(7748615));
	}

	public static int suma(int num){
		if(num/10 < 1){ return num;}

		return num % 10 + suma(num/10);
	}
}
