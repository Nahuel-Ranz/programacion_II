import java.io.*;
import javax.swing.*;
import java.util.Scanner;

public class Main{
	public static void main(String []args){
		
		String path="/media/nahue/1_TB/UTN/2do trimestre/Programación II/Práctica/10-29/archivo.txt";
		//crearArchivo(path);
		//escribirArchivo(path);
		//leerArchivo(path);

		/*if(verificarArchivo(path)){
			System.out.println("El archivo existe!");
		}*/

		crearDirectorio();
		System.out.println("\nAdiós!!!");
	}

	public static void crearArchivo(String path){
		File archivo=new File(path);

		try{
 	               if(archivo.createNewFile()){
     			       System.out.println("Archivo creado!");
		       }else {
			       System.out.println("Error al crear el archivo!");
		       }
		}catch(IOException e){
			System.out.println("Ocurrió un error al crear el archivo.");
			e.printStackTrace();
		}
	}

	public static void escribirArchivo(String path){
	
		try(FileWriter writer = new FileWriter(path, true)){
			writer.write("\nCuarta línea del archivo\n");
			writer.write("Quinta línea del archivo");
			System.out.println("Datos almacenados en el archivo");
		}catch(IOException e){
			System.out.println(" > Ocurrió un error al escribir en el archivo");
			e.printStackTrace();
		}
	}

	public static void leerArchivo(String path){
		
		BufferedReader buffer=null;
		try{
			FileReader lector=new FileReader(path);
			buffer=new BufferedReader(lector);

			String linea;
			while((linea = buffer.readLine()) != null){
				System.out.println(linea);
			}
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				if(buffer != null){
					buffer.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}

	public static void ingresoDeRuta(){
		JFileChooser fileChooser=new JFileChooser();
		int seleccion=fileChooser.showOpenDialog(null);
		BufferedReader buffer=null;

		if(seleccion == JFileChooser.APPROVE_OPTION){
			File archivo=fileChooser.getSelectedFile();
			try{
				
				FileReader lector=new FileReader(archivo);
				buffer=new BufferedReader(lector);

				String linea;
				while((linea=buffer.readLine()) != null){
					System.out.println(linea);
				}
			}catch(IOException e){
				System.out.println("Error!");
			}
		}
	}

	public static boolean verificarArchivo(String path){
		File archivo=new File(path);
		return archivo.exists();

		/*
		 * if(archivo.exists())
		 * 	archivo.getName(); -> fileName.
		 * 	archivo.getParent(); -> folderPath.
		 * 	archivo.length(); -> number of characters.
		 */
	}

	public static void crearDirectorio(){
		Scanner into=new Scanner(System.in);
		
		System.out.print("Ingrese el path donde creará el directorio: ");
		String path=into.nextLine();
		
		File directorio=new File(path);
		if(directorio.mkdir()){
			System.out.println("Directorio creado exitosamente!");
		}else {
			System.out.println("Error al crear el directorio!");
		}
	}

	/*
	 * try{
	 *	
	 *	lector=new FileReader(fileChooser.getSelectedFile());
	 *	int caracter;
	 *	while((catacter=lector.read()) != -1){
	 *		System.out.print((char) caracter + "-");
	 *	}
	 * }catch(IOException e){}
	 * */
}
