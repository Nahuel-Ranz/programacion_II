public class Electrodomestico{
	
	protected int precioBase=100;
	protected String color="blanco";
	protected char consumo='F';
	protected double peso=5;

	public Electrodomestico(){}
	public Electrodomestico(int precioBase, double peso){
		this.precioBase=precioBase;
		this.peso=peso;
	}

	public Electrodomestico(int precioBase, double peso, String color, char consumo){
		this.precioBase=precioBase;
		this.peso=peso;
		this.color=color;
		this.consumo=consumo;
	}

	public int getPrecioBase(){ return precioBase;}
	public String getColor(){ return color;}
	public char getConsumo(){ return consumo;}
	public double getPeso(){ return peso;}

	public void comprobarConsumoEnergetico(char letra){
		consumo= letra>'F' || letra<'A' ? 'F' : letra;
	}

	public void comprobarColor(String color){
		int cont=0;
		color.toUpperCase();

		for(Colores colour: Colores.values()){
			if(!colour.toString().equals(color)){
				cont++;
			}
		}

		this.color=Colores.values().length==cont ? "blanco" : color.toLowerCase();
	}

	/**
	 * Consumo	Aumento	| Peso		Aumento
	 *    A		  100	| 00-19		  10
	 *    B		  80	| 20-49		  50
	 *    C		  60	| 50-79		  80
	 *    D		  50	| 80		  100
	 *    E		  30	| 
	 *    F		  10	| 
	 **/
	public void precioFinal(){
		switch(consumo){
			case 'A': precioBase+=100; break;
			case 'B': precioBase+=80; break;
			case 'C': precioBase+=60; break;
			case 'D': precioBase+=50; break;
			case 'E': precioBase+=30; break;
			case 'F': precioBase+=10; break;
		}

		if(peso < 20){
			precioBase+=10;
		}else if(peso < 50){
			precioBase+=50;
		}else if(peso < 80){
			precioBase+=80;
		} else {
			precioBase+=100;
		}
	}

	@Override
	public String toString(){
		return " > Precio: $"+ precioBase+ " | Color: "+ color+ " | Consumo: "+ consumo+ " | Peso: "+ peso;
	}
}
