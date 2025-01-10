public abstract class Animal{
	
	protected String raza="";
	protected String nombre="";
	protected int edad=0;

	public Animal(){}
	
	public Animal(String raza){
		this.raza=raza;
	}

	public Animal(String raza, String nombre){
		this.raza=raza;
		this.nombre=nombre;
	}

	public Animal(String raza, String nombre, int edad){
		this.raza=raza;
		this.nombre=nombre;
		this.edad=edad;
	}

	public String getRaza(){ return raza;}
	public void setRaza(String raza){ this.raza=raza;}

	public String getNombre(){ return nombre;}
	public void setNombre(String nombre){ this.nombre=nombre;}

	public int getEdad(){ return edad;}
	public void setEdad(int edad){ this.edad=edad;}
}
