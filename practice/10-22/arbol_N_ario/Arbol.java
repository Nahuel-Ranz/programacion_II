import java.util.ArrayList;

public class Arbol{
	
	private Nodo raiz;
	private int tamanio;

	public Arbol(){
		raiz=null;
		tamanio=0;
	}

	public boolean estaVacio(){ return tamanio==0;}

	public Nodo getRaiz(){ return raiz;}
	public void setRaiz(Nodo raiz){ this.raiz=raiz;}

	public void preOrden(){	preOrden(raiz);}
	private void preOrden(Nodo nodo){
		if(nodo != null){
			System.out.print(nodo.getValor()+ " | ");
			for(Nodo hijo: nodo.getHijos()){
				preOrden(hijo);
			}
		}
	}
	
	public void postOrden(){ postOrden(raiz);}
	private void postOrden(Nodo nodo){
		if(nodo != null){
			for(Nodo hijo: nodo.getHijos()){
				postOrden(hijo);
			}
			System.out.print(nodo.getValor()+ " | ");
		}
	}
	
	public int altura(){
		int alturas[]={0, 0};
		return altura(raiz, alturas);
	}

	private int altura(Nodo nodo, int[] alturas){
		
		if(estaVacio()){
			return 0;
		}else {
			if(nodo.cantidadDeHijos() > 0){
				
			}
		}
	}

	/*public void agregar(int valor, int hijoNumero, int nivel){ agregar(valor, hijoNumero, nivel, raiz);}
	private void agregar(int valor, int hijoNumero, int nivel, Nodo nodo){
		
		if(nivel==0){
			if(nodo == null){
				raiz=new Nodo(valor);
			}else {
				System.out.println("\nNo corresponde agregar nodo alguno en este nivel!");
			}
		}else {
			if(nivel-- > 0){
				if(nodo.cantidadDeHijos() > 0){
					
				}
			}
		}
		
		++tamanio;
	}*/
}
