import java.util.Scanner;

public class Start{
	public static void main(String []args){
		Scanner into=new Scanner(System.in);

		System.out.println("Ingrese los siguientes datos de la persona:");
		System.out.print(" > Nombre: "); String nombre=into.nextLine();
		System.out.print(" > Apellido: "); String apellido=into.nextLine();
		System.out.print(" > Edad: "); int edad=into.nextInt(); into.nextLine();
		System.out.print(" > DNI (sin puntos): "); String dni=into.nextLine();
		System.out.print(" > Sexo (H/M): "); char sexo=into.nextLine().toUpperCase().charAt(0);
		System.out.print(" > Peso (en Kilos): "); double peso=into.nextDouble();
		System.out.print(" > Altura (en Metros): "); double altura=into.nextDouble();

		Persona persona1=new Persona(nombre, apellido, edad, dni, sexo, peso, altura);
		Persona persona2=new Persona(nombre, apellido, dni, edad, sexo);
		Persona persona3=new Persona(nombre, dni);

		System.out.println("\nIMC de persona1: "+ persona1.calcularIMC());
		System.out.println("IMC de persona2: "+ persona2.calcularIMC());
		System.out.println("IMC de persona3: "+ persona3.calcularIMC());

		System.out.println("\npersona1 es mayor? "+ persona1.esMayorDeEdad());
		System.out.println("persona2 es mayor? "+ persona2.esMayorDeEdad());
		System.out.println("persona3 es mayor? "+ persona3.esMayorDeEdad());

		System.out.println("\nInformación de persona1: "+ persona1.toString());
		System.out.println("Información de persona2: "+ persona2.toString());
		System.out.println("Información de persona3: "+ persona3.toString());
	}
}
