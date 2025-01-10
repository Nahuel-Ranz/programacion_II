import java.util.Scanner;

public abstract class Juego{
	
	protected int vidas=0;
	protected Scanner into=new Scanner(System.in);
	private int record[]=new int[2]; //[ganadas, perdidas]

	public Juego(){}
	public Juego(int vidas){
		this.vidas=vidas;
	}

	public abstract void juega();
	public abstract void reiniciarPartida();

	public boolean quitarVida(){
		--vidas;
		return vidas > 0;
	}

	public void actualizarRecord(boolean bool){
		
		if(bool){
			++record[0];
		}else{
			++record[1];
		}
	}

	public String mostrarRecord(){
		return "{Partidas ganadas: "+ record[0]+ " | Partidas perdidas: "+ record[1]+ "}";
	}
}
