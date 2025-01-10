import java.util.Scanner;

public class JuegoAdivinaNumero extends Juego{
	
	protected int adivinar=0;

	public JuegoAdivinaNumero(){ super();}
	public JuegoAdivinaNumero(int vidas, int adivinar){
		super(vidas);

		if(adivinar > 10 || adivinar < 0){
			this.adivinar=(int)(Math.random()*10);
		}else{
			this.adivinar=adivinar;
		}
	}

	@Override
	public void juega(){
		reiniciarPartida();
	}

	@Override
	public void reiniciarPartida(){
		
		do{
			
			System.out.print("Adivine el número [0; 10]: ");
                	int num=super.into.nextInt(); super.into.nextLine();

			if(validarNumero(num) && num>=0 && num<=10){
			
				if(adivinar==num){
                        		System.out.println("ACERTASTE !!!");
					super.actualizarRecord(true);
					break;
                		}else if(adivinar > num) {
					System.out.print(" > El número es más grande. ");
				}else{
					System.out.print(" > El número es más chico. ");
				}
			}else {
				System.out.println(" El número ingresado no se correponde con el juego. 1 vida menos!!");
			}
		}while(super.quitarVida());

		if(super.vidas == 0){
			System.out.println("JUEGO PERDIDO !!!");
			super.actualizarRecord(false);
		}
		
		super.vidas = 3;
	}

	public boolean validarNumero(int numero){
		return true;
	}
}
