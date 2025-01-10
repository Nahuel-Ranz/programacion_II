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

			fibo=fibonacci(i);
		}
	}

	private static int fibonacci(int num){
		
		if(num == 0 || num == 1){ return num==1 ? 1 : 0;}

		return num > 0 ? fibonacci(num-1) + fibonacci(num-2) : -1;
	}
}
