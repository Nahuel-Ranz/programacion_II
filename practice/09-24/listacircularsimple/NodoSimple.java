public class NodoSimple {
	
	private String valor;
	private NodoSimple nodoSiguiente;

	public NodoSimple(String valor){ this.valor=valor; nodoSiguiente=null;}

	public String getValor(){ return valor;}

	public NodoSimple getNodoSiguiente(){ return nodoSiguiente;}
	
	public void setNodoSiguiente(NodoSimple nodoSiguiente){ this.nodoSiguiente=nodoSiguiente;}
}
