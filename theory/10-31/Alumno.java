import java.util.Date;

public class Alumno implements Serializable {
	
	private int legajo;
	private String dni;
	private String nombre;
	private String apellido;
	private Date fechaNacimiento;
	private Date fechaExamen;

	public int getLegajo(){ return legajo;}
	public void setLegajo(int legajo){ this.legajo=legajo;}

	public String getDNI(){ return dni;}
	public void setDNI(String dni){ this.dni=dni;}

	public String getNombre(){ return nombre;}
	public void setNombre(String nombre){ this.nombre=nombre;}

	public String getApellido(){ return apellido;}
	public void setApellido(String apellido){ this.apellido=apellido;}

	public Date getFechaNacimiento(){ return fechaNacimiento;}
	public void setFechaNacimiento(Date fechaNacimiento){ this.fechaNacimiento=fechaNacimiento;}
	
	public Date getFechaExamen(){ return fechaExamen;}
	public void setFechaExamen(Date fechaExamen){ this.fechaExamen=fechaExamen;}

	public Alumno(){}
	public Alumno(String nombre, String apellido, String dni, Date fechaNacimiento){
		this.nombre=nombre;
		this.apellido=apellido;
		this.dni=dni;
		this.fechaNacimiento=fechaNacimiento;
	}

	public Alumno(String nombre, String apellido, String dni, int legajo, Date fechaNacimiento, Date fechaExamen){
		this.nombre=nombre;
		this.apellido=apellido;
		this.dni=dni;
		this.legajo=legajo;
		this.fechaNacimiento=fechaNacimiento;
		this.fechaExamen=fechaExamen;
	}

	@Override
	public boolean equals(Alumno alumno){
		return legajo.equals(alumno.getLegajo()) && dni.equals(alumno.getDNI());
	}

	@Override
	public String toString(){
		return "Nombre Completo: "+ nombre+ " "+ apellido+ "\nDNI: "+ dni+ "        Legajo: "+ legajo+
			"\nFecha de nacimiento: "+ fechaNacimiento.getDate()+ "/"+ (fechaNacimiento.getMounth()+1)+
			"/"+ (fechaNacimiento.getYear()+1900);
	}

	@Override
	public int hashCode(){
		return 0;
	}
}
