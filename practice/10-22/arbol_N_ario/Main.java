import java.util.ArrayList;

public class Main{
	public static void main(String []args){
		
		Arbol arbol=new Arbol();
		
		arbol.setRaiz(new Nodo(1));

		arbol.getRaiz().nuevoHijo(2);
		arbol.getRaiz().nuevoHijo(3);
		arbol.getRaiz().nuevoHijo(4);

		arbol.getRaiz().getHijos().get(0).nuevoHijo(5);
		arbol.getRaiz().getHijos().get(0).nuevoHijo(6);

		arbol.getRaiz().getHijos().get(1).nuevoHijo(7);

		arbol.getRaiz().getHijos().get(2).nuevoHijo(8);
		arbol.getRaiz().getHijos().get(2).nuevoHijo(9);
		arbol.getRaiz().getHijos().get(2).nuevoHijo(10);
		
		System.out.print(" > preOrden: | ");
		arbol.preOrden();
		System.out.print("\n > postOrden: | ");
		arbol.postOrden();
		System.out.println();
	}
}
