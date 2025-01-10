import java.util.Scanner;

public class Start {
	public static void main(String []args){
		Scanner into=new Scanner(System.in);
		
		ListaSimple lista=new ListaSimple();
		lista.agregar("Nahue");
		lista.agregar("Isaías");
		lista.agregar("Antonio");
		lista.agregar("Carla");
		
		lista.eliminarPrimero();
		System.out.println("Tamaño de la lista: "+ lista.getTamanio());
		System.out.println(lista.toString());
	}
}
