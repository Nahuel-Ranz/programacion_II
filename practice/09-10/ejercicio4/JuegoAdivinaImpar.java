public class JuegoAdivinaImpar extends JuegoAdivinaNumero {
	
	public JuegoAdivinaImpar(){ super();}
	public JuegoAdivinaImpar(int vidas, int adivinar){
		super(vidas, adivinar);
	}

	@Override
	public boolean validarNumero(int num){
		return num % 2 != 0;
	}
}
