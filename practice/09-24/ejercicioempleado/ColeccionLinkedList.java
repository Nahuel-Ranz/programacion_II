import java.util.Scanner;
import java.util.LinkedList;

public class ColeccionLinkedList{
	
	Scanner into=new Scanner(System.in);
	private LinkedList<Empleado> empleados;

	public ColeccionLinkedList(){
		empleados=new LinkedList<Empleado>();
	}

	public void agregar(){
		
		System.out.print("\n > Ingrese el nombre del empleado: ");
		String nombre=into.nextLine();
		System.out.print(" > Ingrese el DNI: ");
		String dni=into.nextLine();
		System.out.print(" > Ingrese el departamento del empleado: ");
		String dep=into.nextLine();

		empleados.add(new Empleado(nombre, dni, dep));
	}

	public void buscarId(String id){
		
		int count=0;
		for(Empleado empleado: empleados){
			if(empleado.getId().equals(id)){
				System.out.println(empleado.toString());
			}else {
				count++;
			}
		}

		if(empleados.size() == count){ System.out.println("Empleado no hallado.");}
	}

	public void eliminar(String id){

		int ind=0;
		for(Empleado empleado: empleados){
			if(empleado.getId().equals(id)){
				empleados.remove(ind);
			} ind++;
		}
	}

	public void listar(){
		
		for(Empleado emp: empleados){
			System.out.println(emp.toString());
		}
	}

	public void editar(String id){

		int ind=0;
		for(Empleado emp: empleados){
			if(emp.getId().equals(id)){
				
				System.out.print("\n - Ingrese nuevo nombre: ");
				empleados.get(ind).setNombre(into.nextLine());

				System.out.print(" - Ingrese nuevo departamento: ");
				empleados.get(ind).setDepartamento(into.nextLine());
			} ind++;
		}
	}

	public void menu(){
		
		int op=0;
		do{
			System.out.println("\n 1 - Agregar un empleado");
			System.out.println(" 2 - Buscar un empleado por ID");
			System.out.println(" 3 - Eliminar un empleado por ID");
			System.out.println(" 4 - Listar empleados");
			System.out.println(" 5 - Editar empleados por ID");
			System.out.println(" 6 - Salir");
			op= into.nextInt(); into.nextLine();

			switch(op){
				case 1: agregar(); break;
				case 2:
					System.out.print(" . Ingrese el ID del empleado: ");
					buscarId(into.nextLine());
					break;
				case 3:
					System.out.print(" . Ingrese el ID del empleado a eliminar: ");
					eliminar(into.nextLine());
					break;
				case 4: System.out.println(); listar(); break;
				case 5:
					System.out.print(" . Ingrese el ID del empleado a editar: ");
					editar(into.nextLine());
					break;
				case 6: System.out.println("Adiós!!!"); break;
				default: System.out.println(" Opción errónea.");
			}
		}while(op!=6);
	}
}
