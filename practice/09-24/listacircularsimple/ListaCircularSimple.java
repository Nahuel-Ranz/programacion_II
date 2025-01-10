public class ListaCircularSimple{
	
	private NodoSimple acceso;
	private int tamanio;

	public ListaCircularSimple(){
		this.acceso=null;
		this.tamanio=0;
	}

	public boolean estaVacia(){ return tamanio == 0;}

	public void agregar(String valor){
		
		if(estaVacia()){
			acceso=new NodoSimple(valor);
			acceso.setNodoSiguiente(acceso);
		}else{
			NodoSimple aux=acceso.getNodoSiguiente();
			acceso.setNodoSiguiente(new NodoSimple(valor));
			acceso.getNodoSiguiente().setNodoSiguiente(aux);
		}

		++tamanio;
	}

	public void eliminar(String valor){
		if(!estaVacia()){
			if(tamanio==1){
				if(coincide(acceso, valor)){
					acceso.setNodoSiguiente(null);
					acceso=null;
					--tamanio;
				}else {
					System.out.println("\nValor no hallado!");
				}
			}else{
				NodoSimple aux=acceso, anterior=null;
				while(!vueltaCompleta(aux) && !coincide(aux, valor)){
					anterior=aux;
					aux=aux.getNodoSiguiente();
				}

				if(coincide(aux,valor)){
					if(aux==acceso){
						while(!vueltaCompleta(aux)){
							aux=aux.getNodoSiguiente();
						}
						aux.setNodoSiguiente(acceso.getNodoSiguiente());
						acceso=acceso.getNodoSiguiente();
					}else {
						anterior.setNodoSiguiente(aux.getNodoSiguiente());
					}

					--tamanio;
				}else {
					System.out.println("\nValor no hallado!");
				}	
			}
		}else {
			System.out.println("\nLista vacía.");
		}
	}
	
	public boolean contiene(String valor){
		NodoSimple aux=acceso;
		while(!coincide(aux, valor) && !vueltaCompleta(aux)){
			aux=aux.getNodoSiguiente();
		}

		return coincide(aux,valor);
	}
	
	public int getTamanio(){ return tamanio;}

	@Override
	public String toString(){
		
		if(tamanio == 0){
			return "{}";
		}else{
			
			NodoSimple aux=acceso;
			String retorno="{"+ acceso.getValor();

			while(!vueltaCompleta(aux)){
				aux=aux.getNodoSiguiente();
				retorno+=", "+ aux.getValor();
			}

			return retorno+ "}";
		}
	}
	
	private boolean vueltaCompleta(NodoSimple aux){ return aux.getNodoSiguiente() == acceso;}
	private boolean coincide(NodoSimple nodo, String valor){ return nodo.getValor().equals(valor);}
}
