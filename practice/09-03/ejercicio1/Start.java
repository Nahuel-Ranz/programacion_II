import java.util.Scanner;

public class Start{
	public static void main(String []args){
		Scanner into=new Scanner(System.in);
		Cuenta cuenta=new Cuenta("Jose", 15000);

		cuenta.ingresar(5000);
		cuenta.ingresar(-4000);
		System.out.println("Titular: "+ cuenta.getTitular());
		System.out.println("Monto: $"+ cuenta.getCantidad());

		System.out.print("Ingrese el monto a retirar: $");
		double monto=into.nextDouble();
		
		System.out.println("\nMonto retirado: $"+ cuenta.retirar(monto));
		System.out.println("Monto restante: $"+ cuenta.getCantidad());
	}
}
