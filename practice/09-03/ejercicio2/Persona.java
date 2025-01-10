public class Persona {
	
	private String nombre;
	private String apellido="";
	private int edad=0;
	private String dni;
	private char sexo='H';
	private double peso=0;
	private double altura=0;

	public Persona(String nombre, String dni){
		this.nombre=nombre;
		this.dni=dni;
	}

	public Persona(String nombre, String apellido, String dni, int edad, char sexo){
		this.nombre=nombre;
		this.apellido=apellido;
		this.dni=dni;
		this.edad=edad;
		this.sexo=sexo;
	}

	public Persona(String nombre, String apellido, int edad, String dni, char sexo, double peso, double altura){
		this.nombre=nombre;
		this.apellido=apellido;
		this.edad=edad;
		this.dni=dni;
		this.sexo=sexo;
		this.peso=peso;
		this.altura=altura;
	}
	
	public String getNombre(){ return nombre;}
	public void setNombre(String nombre){ this.nombre=nombre;}
	
	public String getApellido(){ return apellido;}
	public void setApellido(String apellido){ this.apellido=apellido;}

	public int getEdad(){ return edad;}
	public void setEdad(int edad){ this.edad=edad;}

	public String getDNI(){ return dni;}
	public void setDNI(String dni){ this.dni=dni;}

	public char getSexo(){ return sexo;}
	public void setSexo(char sexo){ this.sexo=sexo;}

	public double getPeso(){ return peso;}
	public void setPeso(double peso){ this.peso=peso;}

	public double getAltura(){ return altura;}
	public void setAltura(double altura){ this.altura=altura;}

	public int calcularIMC(){
		double imc=peso/Math.pow(altura, 2);
		
		if(imc < 20){
			return -1;
		}else if(imc >= 20 && imc <=25){
			return 0;
		}else{
			return 1;
		}
	}

	public boolean esMayorDeEdad(){
		return edad > 17;
	}

	public void comprobarSexo(char sexo){
		this.sexo= sexo!='M' ? 'H' : sexo;
	}

	@Override
	public String toString(){
		return "Persona{nombre: "+ nombre+ ". apellido: "+ apellido+
			". edad: "+ "años. DNI: "+ dni+ ". sexo: "+ sexo+
			". peso: "+ peso+ "kg. altura: "+ altura+ "mts.}";
	}
}
