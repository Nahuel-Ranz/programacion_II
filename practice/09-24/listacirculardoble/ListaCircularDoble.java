public class ListaCircularDoble{
	
	private NodoDoble acceso;
	private int tamanio;

	public ListaCircularDoble(){
		acceso=null;
		tamanio=0;
	}
	
	public boolean estaVacia(){ return tamanio == 0;}

	public void agregar(int valor){
		if(estaVacia()){
			acceso=new NodoDoble(valor);
			acceso.setAnterior(acceso);
			acceso.setPosterior(acceso);
		}else {
			NodoDoble aux=new NodoDoble(valor);
			aux.setPosterior(acceso.getPosterior());
			acceso.setPosterior(aux);
			aux.setAnterior(acceso);
			aux.getPosterior().setAnterior(aux);
		}

		++tamanio;
	}

	public void eliminar(int valor){
		if(!estaVacia()){
			if(tamanio == 1){
				if(acceso.getValor() == valor){
					acceso.setAnterior(null);
					acceso.setPosterior(null);
					acceso=null;
					--tamanio;
				}else {
					System.out.println("\nValor no hallado!");
				}
			}else {
				
				NodoDoble aux=acceso;
				while(!vueltaCompleta(aux) && !coincide(aux, valor)){
					aux=aux.getPosterior();
				}

				if(coincide(aux, valor)){
					aux.getPosterior().setAnterior(aux.getAnterior());
					aux.getAnterior().setPosterior(aux.getPosterior());
					--tamanio;
				}else {
					System.out.println("\nValor no hallado!");
				}
			}
		}else {
			System.out.println("\nLista vacía!");
		}
	}
	
	public NodoDoble obtener(int valor){
		NodoDoble aux=acceso;
		while(!vueltaCompleta(aux) && !coincide(aux, valor)){
			aux=aux.getPosterior();
		}

		return coincide(aux, valor) ? aux : null;
	}

	public boolean vueltaCompleta(NodoDoble aux){ return aux.getPosterior() == acceso;}
	public boolean vueltaCompletaInversa(NodoDoble aux){ return aux.getAnterior() == acceso;}
	public boolean coincide(NodoDoble aux, int valor){ return aux.getValor() == valor;}
}
