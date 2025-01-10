import java.util.Scanner;

public class Fibonacci{
	
	public static void main(String []args){
		Scanner into=new Scanner(System.in);
		
		System.out.print("Enter a number: ");
		int num=into.nextInt(), fibo=0;

		for(int i=0; fibo<101; i++){
			
			if(fibo >= num){
				
				System.out.print(fibo+ " ");
			}

		//	fibo=fibonacci(i);
		}
	}

	private static int fibonacci(int num) throws RuntimeException {

		if(num<0){ throw new RuntimeException("Negative numbers don't have a Fibonacci value.");}
		else if(num>-1 && num<3){ return num==0 ? 0 : 1;}

		return fibonacci(num-1) + fibonacci(num-2);
	}
}
