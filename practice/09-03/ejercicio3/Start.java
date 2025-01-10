import java.util.Scanner;
import java.util.ArrayList;

public class Start{
	public static void main(String []args){
		Scanner into=new Scanner(System.in);
		ArrayList<Electrodomestico> lista=new ArrayList<>();
		
		//Lavarropas, Televisor
		lista.add(new Television(500, 7));	//1
		lista.add(new Lavarropas());		//2
		lista.add(new Lavarropas(450, 3));	//3
		lista.add(new Television());		//4
		lista.add(new Television(24, true));	//5
		lista.add(new Television(130, 10));	//6
		lista.add(new Lavarropas(35));		//7
		lista.add(new Lavarropas(145, 21));	//8
		lista.add(new Television(455, 18));	//9
		lista.add(new Lavarropas(13));		//10
		
		for(Electrodomestico maquina: lista){
			maquina.precioFinal();

			System.out.println("-------------------------------------------------------------------");
			System.out.println(maquina.toString());
			System.out.println("Precio del equipo: $"+ maquina.getPrecioBase());
		}

		System.out.println();
		
		int totalLavarropas=0, totalTelevisores=0;
		for(Electrodomestico maquina: lista){
			
			if(maquina instanceof 
		}
	}
}
