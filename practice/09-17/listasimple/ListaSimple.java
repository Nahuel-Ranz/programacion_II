public class ListaSimple {
	
	private NodoSimple primero;
	private int tamanio;

	public ListaSimple(){
		this.primero=null;
		this.tamanio=0;
	}

	public boolean estaVacia(){ return tamanio == 0;}

	public void agregar(String valor){
		
		if(estaVacia()){
			primero=new NodoSimple(valor);
		}else{
			NodoSimple aux=primero;
			while(aux.tieneSiguiente()){
				aux=aux.getNodoSiguiente();
			}

			aux.setNodoSiguiente(new NodoSimple(valor));
		}

		++tamanio;
	}
	
	public void agregarNuevoPrimero(String valor){
		if(estaVacia()){
			primero= new NodoSimple(valor);
		}else {
			NodoSimple aux=primero;
			primero=new NodoSimple(valor);
			primero.setNodoSiguiente(aux);
			++tamanio;
		}
	}

	public void agregarEn(String valor, int indice){
		if(correcto(indice)){
			
			if(indice == 0){
				agregarNuevoPrimero(valor);
			}else if(indice == tamanio-1){
				agregar(valor);
			}else{
				NodoSimple aux=primero, respaldo=null;
				while(indice-- > 0){
					aux=aux.getNodoSiguiente();
				}

				respaldo=aux;
				aux=new NodoSimple(valor);
				aux.setNodoSiguiente(respaldo);
			}
				tamanio++;
		}else {
			System.out.println("\nÍndice fuera de rango.");
		}
	}

	public void eliminarPrimero(){
		if(!estaVacia()){
			primero=primero.getNodoSiguiente();
			--tamanio;
		}else {
			System.out.println("\nLista vacía.");
		}
	}

	public void eliminarUltimo(){
		if(!estaVacia()){

			if(!primero.tieneSiguiente()){
				eliminarPrimero();
			}else {

				NodoSimple actual=primero, anterior=null;
				while(actual.tieneSiguiente()){
					anterior=actual;
					actual=actual.getNodoSiguiente();
				}
			
				anterior.setNodoSiguiente(null);
				--tamanio;
			}
		}else {
			System.out.println("\nLista vacía.");
		}
	}

	public void eliminar(String valor){
		if(!estaVacia()){
			NodoSimple actual=primero, anterior=null;
			while(!coincide(actual, valor) && actual.tieneSiguiente()){
				anterior=actual;
				actual=actual.getNodoSiguiente();
			}

			if(!coincide(actual, valor)){
				System.out.println("\nEl elemento no ha sido encontrado.");
			}else{

				if(primero == actual){
					eliminarPrimero();
				}else{
					anterior.setNodoSiguiente(actual.getNodoSiguiente());
					--tamanio;
				}
			}
		}else {
			System.out.println("\nLista vacía.");
		}
	}
	
	public void eliminarDePosicion(int indice){
		if(!correcto(indice)){
			System.out.println("\nÍndice fuera de rango.");
		}else if(indice == 0) {
			eliminarPrimero();
		}else if(indice == tamanio-1){
			eliminarUltimo();
		}else {
			
			NodoSimple actual=primero, anterior=null;
			while(indice-- > 0){
				anterior=actual;
				actual=actual.getNodoSiguiente();
			}

			anterior.setNodoSiguiente(actual.getNodoSiguiente());
			--tamanio;
		}
	}
	
	private boolean correcto(int valor){ return valor>=0 && valor<tamanio;}

	public int getTamanio(){ return tamanio;}

	@Override
	public String toString(){
		
		if(tamanio == 0){
			return "{}";
		}else{
			
			NodoSimple aux=primero;
			String retorno="{"+ primero.getValor();

			while(aux.tieneSiguiente()){
				aux=aux.getNodoSiguiente();
				retorno+=", "+ aux.getValor();
			}

			return retorno+ "}";
		}
	}

	public NodoSimple obtenerPrimero(){
		return tamanio==0 ? null : primero;
	}

	public NodoSimple obtenerUltimo(){
		if(!estaVacia()){
			
			NodoSimple aux=primero;
			while(aux.tieneSiguiente()){
				aux=aux.getNodoSiguiente();
			}

			return aux;
		}else{
			return null;
		}
	}

	public NodoSimple obtenerDePosicion(int indice){
		if(correcto(indice)){

			if(indice == 0){
				return obtenerPrimero();
			}else if(indice == tamanio-1){
				return obtenerUltimo();
			}else {
				
				NodoSimple aux=primero;
				while(indice-- > 0){
					aux=aux.getNodoSiguiente();
				}

				return aux;
			}
		}else {
			return null;
		}
	}

	public boolean contiene(String valor){
		if(!estaVacia()){
			
			NodoSimple aux=primero;
			while(!coincide(aux, valor) && aux.tieneSiguiente()){
				aux=aux.getNodoSiguiente();
			}

			return coincide(aux, valor);
		}else {
			return false;
		}
	}

	private boolean coincide(NodoSimple nodo, String valor){
		return nodo.getValor().equals(valor);
	}
}
