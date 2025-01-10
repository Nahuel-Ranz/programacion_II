public class Lavarropas extends Electrodomestico {
	
	private double carga=5;

	public Lavarropas(){ super();}
	public Lavarropas(int precio, double peso){
		super(precio, peso);
	}

	public Lavarropas(double carga){
		super();
		this.carga=carga;
	}

	public double getCarga(){ return carga;}

	@Override
	public void precioFinal(){
		if(carga > 30){
			super.precioBase+=50;
		}

		super.precioFinal();
	}

	@Override
	public String toString(){
		return " > Lavarropa: carga: "+ carga+ "\n"+ super.toString();
	}
}
