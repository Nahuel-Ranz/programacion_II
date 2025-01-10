public class Nodo{
	
	private String valor;
	private Nodo izquierdo;
	private Nodo derecho;

	public Nodo(String valor){
		this.valor=valor;
		izquierdo=null;
		derecho=null;
	}

	public String getValor(){ return valor;}
	
	public Nodo getIzquierdo(){ return izquierdo;}
	public void setIzquierdo(Nodo izquierdo){ this.izquierdo=izquierdo;}

	public Nodo getDerecho(){ return derecho;}
	public void setDerecho(Nodo derecho){ this.derecho=derecho;}

	public boolean tieneIzquierdo(){ return izquierdo!=null;}
	public boolean tieneDerecho(){ return derecho!=null;}
	public boolean tieneHijos(){ return tieneDerecho() || tieneIzquierdo();}

	private boolean coincide(String string, int index){

		try{
			return valor.charAt(index) == string.charAt(index);
		}catch(StringIndexOutOfBoundsException e){}

		return false;
	}

	public boolean estaDespuesDe(String string) {
		
		try{
			
			for(int i=0; i<valor.length(); i++){
				if(!coincide(string, i)){
					return valor.charAt(i) > string.charAt(i);
				}
			}
		}catch(StringIndexOutOfBoundsException e){ return true;}

		return false;
	}

	public boolean estaAntesDe(String string) {
		return !(estaDespuesDe(string) || valor.equals(string));
	}

	public Nodo menorValor(){ return menorValor(this);}
	private Nodo menorValor(Nodo menor){ return menor.tieneIzquierdo() ? menorValor(menor.getIzquierdo()) : menor;}

	public Nodo mayorValor(){ return mayorValor(this);}
	private Nodo mayorValor(Nodo mayor){ return mayor.tieneDerecho() ? mayorValor(mayor.getDerecho()) : mayor;}
}
