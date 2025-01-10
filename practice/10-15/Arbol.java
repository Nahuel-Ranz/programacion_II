public class Arbol{
	
	private Nodo raiz;
	private int tamanio;

	public Arbol(){
		raiz=null;
		tamanio=0;
	}

	public boolean estaVacio(){ return tamanio==0;}

	public void agregar(String valor){ agregar(raiz, valor);}
	private void agregar(Nodo nodo, String valor){
	
		if(nodo == null){
			nodo=new Nodo(valor); tamanio++;
		}else if(nodo.estaDespuesDe(valor)){
			agregar(nodo.getIzquierdo(), valor);
		}else if(nodo.estaAntesDe(valor)){
			agregar(nodo.getDerecho(), valor);
		}else{
			System.out.println("\nEl valor ya existe!");
		}
	}

	public void eliminar(String valor){ eliminar(raiz, null, valor);}
	private void eliminar(Nodo nodo, Nodo anterior, String valor){
		
		if(estaVacio()){
			System.out.println("\nÁrbol vacío!");
		}else {
			if(!nodo.getValor().equals(valor)){

				if(nodo.estaAntesDe(valor) && nodo.tieneDerecho()){ eliminar(nodo.getDerecho(), nodo, valor);}
				if(nodo.estaDespuesDe(valor) && nodo.tieneIzquierdo()){ eliminar(nodo.getIzquierdo(), nodo, valor);}
			}else{
				if(!nodo.tieneIzquierdo()){
					nodo= nodo.tieneDerecho() && nodo==raiz ? nodo.getDerecho() : revincularAnterior(nodo, anterior, true);
				}else {
					if(nodo.tieneDerecho()){
						Nodo inmediatoMenor=nodo.getIzquierdo().mayorValor();
						inmediatoMenor.setDerecho(nodo.getDerecho());
					}
					
					nodo= nodo==raiz ? nodo.getIzquierdo() : revincularAnterior(nodo, anterior, false);
				}

				--tamanio;
			}
		}
	}

	private Nodo revincularAnterior(Nodo nodo, Nodo anterior, boolean bool){
		if(anterior != null){
			Nodo destino= bool ? nodo.getDerecho() : nodo.getIzquierdo();
			if(anterior.getIzquierdo() == nodo){
				anterior.setIzquierdo(destino);
			}else {
				anterior.setDerecho(destino);
			}
		}

		return null;
	}

	public int altura(){ int[] niveles={0, 0}; return altura(raiz, niveles);}
	private int altura(Nodo nodo, int[] niveles){
		
		if(nodo == null){ return 0;
		}else{
			++niveles[0]; ++niveles[1];
			return niveles[0]>=niveles[1] ? niveles[0] : niveles[1];
		}

		
	}
}
