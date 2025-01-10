public class NodoDoble {
	
	private int valor;
	private NodoDoble anterior;
	private NodoDoble posterior;

	public NodoDoble(int valor){
		this.valor=valor;
		anterior=null;
		posterior=null;
	}

	public int getValor(){ return valor;}
	
	public NodoDoble getAnterior(){ return anterior;}
	public void setAnterior(NodoDoble anterior){ this.anterior=anterior;}

	public NodoDoble getPosterior(){ return posterior;}
	public void setPosterior(NodoDoble posterior){ this.posterior=posterior;}

	public boolean tieneSiguiente(){ return posterior != null;}
	public boolean tienePrevio(){ return anterior != null;}
}
