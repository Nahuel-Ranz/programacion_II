public class Empleado{
	
	private String nombre;
	private String id;
	private String departamento;

	public Empleado(){}
	public Empleado(String nombre, String id, String departamento){
		this.nombre=nombre;
		this.id=id;
		this.departamento=departamento;
	}

	public String getNombre(){ return nombre;}
	public void setNombre(String nombre){ this.nombre=nombre;}

	public String getId(){ return id;}

	public String getDepartamento(){ return departamento;}
	public void setDepartamento(String departamento){ this.departamento=departamento;}

	@Override
	public String toString(){
		return "Empleado{nombre= -"+ nombre+ "-, id= -"+ id+ "-, departamento= -"+ departamento+ "-}";
	}
}
