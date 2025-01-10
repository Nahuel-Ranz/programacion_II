/*
 * (+) estaVacia(): boolean;
 * (+) agregarPrimero(int): void;
 * (+) agregarUltimo(int): void;
 * (+) agregarEn(int, int): void;
 * (-) correcto(int): boolean;
 * (+) eliminarPrimero(): void;
 * (+) eliminarUltimo(): void;
 * (+) eliminarEn(int): void;
 * (+) eliminarElemento(int): void;
 *
 *
 * */

public class ListaDoble {
	
	private NodoDoble primero;
	private NodoDoble ultimo;
	private int tamanio;

	public ListaDoble(){
		primero=null;
		ultimo=null;
		tamanio=0;
	}

	public boolean estaVacia(){ return tamanio == 0;}
	
	public void agregarPrimero(int valor){
		
		if(estaVacia()){
			primero=new NodoDoble(valor);
			ultimo=primero;
		}else {
			primero.setAnterior(new NodoDoble(valor));
			primero.getAnterior().setPosterior(primero);
			primero=primero.getAnterior();
		}
		tamanio++;
	}

	public void agregarUltimo(int valor){
		
		if(estaVacia()){
			agregarPrimero(valor);
		}else{
			
			ultimo.setPosterior(new NodoDoble(valor));
			ultimo.getPosterior().setAnterior(ultimo);
			ultimo=ultimo.getPosterior();
		}
		++tamanio;
	}

	public void agregarEn(int valor, int indice){
		
		if(estaVacia() || indice == 0){
			agregarPrimero(valor);
		}else{
			if(correcto(indice)){
				
				if(indice == tamanio-1){
					agregarUltimo(valor);
				}else{

					NodoDoble aux=primero, respaldo=null;
					while(indice-- > 0){
						aux=aux.getPosterior();
					}

					respaldo=aux;
					aux=aux.getAnterior();
					aux.setPosterior(new NodoDoble(valor));
					aux.getPosterior().setAnterior(aux);
					aux=aux.getPosterior();
					aux.setPosterior(respaldo);
					respaldo.setAnterior(aux);
					tamanio++;
				}
			}else {
				System.out.println("\nÍndice fuera de rango!");
			}
		}
	}

	private boolean correcto(int indice){ return indice >= 0 && indice < tamanio;}

	public void eliminarPrimero(){
		
		if(!estaVacia()){
			
			if(tamanio == 1){
				primero=primero.getAnterior();
				ultimo=ultimo.getPosterior();
			}else{
				primero=primero.getPosterior();
				primero.setAnterior(null);
				if(tamanio == 2){
					ultimo.setAnterior(null);
				}
			}
			tamanio--;
		}else {
			System.out.println("\nLista vacía!");
		}
	}

	public void eliminarUltimo(){
		
		if(!estaVacia()){
			
			if(tamanio ==1){
				ultimo=ultimo.getPosterior();
				primero=primero.getAnterior();
			}else {
				ultimo=ultimo.getAnterior();
				ultimo.setPosterior(null);
				if(tamanio == 2){
					primero.setPosterior(null);
				}
			}
			tamanio--;
		}else {
			System.out.println("\nLista vacía!");
		}
	}

	public void eliminarEn(int indice){
		
		if(correcto(indice)){
			if(indice == 0){
				eliminarPrimero();
			}else if(indice == tamanio-1){
				eliminarUltimo();
			}else {
				NodoDoble aux=primero;
				while(indice-- > 0){
					aux=aux.getPosterior();
				}

				aux.getAnterior().setPosterior(aux.getPosterior());
				aux.getPosterior().setAnterior(aux.getAnterior());
				tamanio--;
			}
		}else {
			System.out.println("\nÍndice fuera de rango!");
		}
	}

	public void eliminarElemento(int valor){
		if(!estaVacia()){
			
			NodoDoble aux=primero;
			while(aux.getValor()!=valor && aux.tieneSiguiente()){
				aux=aux.getPosterior();
			}

			if(aux == primero){
				eliminarPrimero();
			}else if(aux == ultimo){
				eliminarUltimo();
			}else {
				aux.getAnterior().setPosterior(aux.getPosterior());
				aux.getPosterior().setAnterior(aux.getAnterior());
				tamanio--;
			}
		}else {
			System.out.println("\nLista vacía!");
		}
	}

	public int getTamanio(){ return tamanio;}

	@Override
	public String toString(){
		if(estaVacia()){
			return "{}";
		}else {
			NodoDoble aux=primero;
			String retorno="{"+ primero.getValor();
			
			if(tamanio > 1){
				while(aux.tieneSiguiente()){

					aux=aux.getPosterior();
					retorno+=", "+ aux.getValor();
				}
			}

			return retorno+ "}";
		}
	}

	public NodoDoble obtenerPrimero(){ return primero;}
	public NodoDoble obtenerUltimo(){ return ultimo;}

	public NodoDoble obtenerDePosicion(int indice){
		if(estaVacia()){
			return null;
		}else {
			if(indice == 0){
				return obtenerPrimero();
			}else if(indice == tamanio-1){
				return obtenerUltimo();
			}else {
				NodoDoble aux=primero;
				while(indice-- > 0){
					aux=aux.getPosterior();
				}

				return aux;
			}
		}
	}

	public boolean contiene(int valor){
		if(estaVacia()){
			return false;
		}else {
			NodoDoble aux=primero;
			while(aux.getValor()!=valor && aux.tieneSiguiente()){
				aux=aux.getPosterior();
			}
			return aux.getValor() == valor;
		}
	}
}
