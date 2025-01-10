public class Television extends Electrodomestico{
	
	private double resolucion=20;
	private boolean tdt=false;

	public Television(){ super();}
	public Television(int precio, double peso){
		super(precio, peso);
	}

	public Television(double resolucion, boolean tdt){
		super();
		this.resolucion=resolucion;
		this.tdt=tdt;
	}

	public double getResolucion(){ return resolucion;}
	public boolean isTDT(){ return tdt;}

	@Override
	public void precioFinal(){
		if(resolucion > 40){
			super.precioBase+=precioBase*0.5;
		}

		if(tdt){ super.precioBase+=50;}
		super.precioFinal();
	}

	@Override
	public String toString(){
		return " > Television: resolucion: "+ resolucion+ " | sintonizador TDT: "+ tdt+ "\n"+ super.toString();
	}
}
