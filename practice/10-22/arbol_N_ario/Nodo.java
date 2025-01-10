import java.util.ArrayList;

public class Nodo{
	
	private int valor;
	private ArrayList<Nodo> nodos;

	public Nodo(int valor){
		this.valor=valor;
		nodos=new ArrayList<Nodo>();
	}

	public int getValor(){ return valor;}

	public void nuevoHijo(int valor){ nodos.add(new Nodo(valor));}

	public void quitarHijo(int indice){
		if(indiceCorrecto(indice)){
			nodos.remove(indice);
		}else {
			System.out.println("\nÍndice Incorrecto!");
		}
	}

	public Nodo getHijo(int numero){ return indiceCorrecto(numero) ? nodos.get(numero) : null;}
	
	public ArrayList<Nodo> getHijos(){ return nodos;}

	public int cantidadDeHijos(){ return nodos.size();}

	private boolean indiceCorrecto(int indice){ return indice>-1 && indice<nodos.size();}
}
