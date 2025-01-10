public class JuegoAdivinaPar extends JuegoAdivinaNumero {
	
	public JuegoAdivinaPar(){ super();}
	public JuegoAdivinaPar(int vidas, int adivinar){
		super(vidas, adivinar);
	}

	@Override
	public boolean validarNumero(int num){
		return num % 2 == 0;
	}
}
