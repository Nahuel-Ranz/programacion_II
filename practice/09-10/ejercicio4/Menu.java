import java.util.Scanner;

public abstract class Menu {
	
	private static Scanner into=new Scanner(System.in);
	private static JuegoAdivinaNumero numero=new JuegoAdivinaNumero(3, randomInt(0));
	private static JuegoAdivinaPar par=new JuegoAdivinaPar(3, randomInt(2));
	private static JuegoAdivinaImpar impar=new JuegoAdivinaImpar(3, randomInt(1));

	public static void menu(){
		int opcion=0;
		String salir="";
		


		do{
			
			System.out.println("*****************************");
			System.out.println("* 1) Adivinar número        *");
			System.out.println("* 2) Adivinar número par    *");
			System.out.println("* 3) Adivinar número impar  *");
			System.out.println("* 4) Salir                  *");
			System.out.print("********************* Opción: "); opcion=into.nextInt(); into.nextLine();
			
			switch(opcion){
				case 1: subMenu(0); break;
				case 2: subMenu(2); break;
				case 3: subMenu(1); break;
				case 4: 
					
					System.out.print(" > ¿desea salir? ");
					do{
						
						salir=into.nextLine().toUpperCase();
						
						if(!salir.equals("S") && !salir.equals("N")){
							System.out.print("Opción errónea, elija 'S' o 'N': ");
						}
					}while(!salir.equals("S") && !salir.equals("N"));
					break;
				default: System.out.println("Opción errónea!!");
			}
		}while(!salir.equals("S"));

		System.out.println("\nAdiós y gracias por jugar!");
	}

	private static void subMenu(int juego){

		System.out.println("*****************************************");
		System.out.println("* a) Jugar                              *");
		System.out.println("* b) Consultar registro (por defecto)   *");
		System.out.print("********************************* Opción: ");
		String choose=into.nextLine().toLowerCase();

		switch(juego){
			case 0:
				if(choose.equals("a")){ numero.juega();}
				else{ System.out.println("\n"+ numero.mostrarRecord());}
				break;
			case 1:
				if(choose.equals("a")){ impar.juega();}
				else{ System.out.println("\n"+ impar.mostrarRecord());}
				break;
			case 2:
				if(choose.equals("a")){ par.juega();}
				else{ System.out.println("\n"+ par.mostrarRecord());}
		}
	}

	private static int randomInt(int num){
		int valor=(int)(Math.random()*11);

		if(num==0){
			return valor;
		}else if(num==1){
			if(valor%2 != 0){
				return valor;
			}else{
				return valor<10 ? ++valor : --valor;
			}
		}else{
			return valor%2 == 0 ? valor : ++valor;
		}
	}
}
