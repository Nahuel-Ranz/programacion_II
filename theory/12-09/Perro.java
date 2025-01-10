public class Perro extends Animal {
	
	private String colorPelo="";
	private boolean castrado=false;

	public Perro(){ super();}
	
	public Perro(String raza, String nombre, int edad){
		super(raza, nombre, edad);
	}

	public Perro(String raza, String nombre, int edad, String colorPelo, boolean castrado){
		super(raza, nombre, edad);
		this.colorPelo=colorPelo;
		this.castrado=castrado	super(raza, nombre, edad);
		this.colorPelo=colorPelo;
		this.castrado=castrado;
	}

	public Perro(String colorPelo){
		this.colorPelo=colorPelo;
	}

	public Perro(String colorPelo, boolean castrado){
		this.colorPelo=colorPelo;
		this.castrado=castrado;
	}
	
	public String getColorPelo(){ return colorPelo;}
	public void setColorPelo(String colorPelo){ this.colorPelo=colorPelo;}

	public boolean isCastrado(){ return castrado;}
	public void setCastrado(boolean castrado){ this.castrado=castrado;}
}
