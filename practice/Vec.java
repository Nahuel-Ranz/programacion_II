public class Vec{
	
	public static void main(String []args){
		
		int coord[]={4,6,3};
		int otro[]={6, 4, 7};
		Vector v1=new Vector(coord);
		Vector v2=new Vector(otro);

		System.out.println(v1.multiplicar(5).toString());
		System.out.println(v1.sumar(v2));
		System.out.println("v1: "+ v1.toString());
		System.out.println("v2: "+ v2.toString());
	}
}

class Vector{
	
	private int []coordenadas;

	public Vector(int []coordenadas){
		this.coordenadas=coordenadas;
	}
	
	public int[] getCoordenadas(){
		return coordenadas;
	}

	public Vector multiplicar(int num){
		
		int []nuevo=new int[3];
		for(int i=0; i<coordenadas.length; i++){

			nuevo[i]=coordenadas[i]*num;
		}
		
		return new Vector(nuevo);
	}

	public Vector sumar(Vector vector){
		
		if(vector.getCoordenadas().length != coordenadas.length){
			
			return vector;
		}else {
			
			int nuevo[]=new int[3];
			for(int i=0; i<nuevo.length; i++){
				nuevo[i]=vector.getCoordenadas()[i]+coordenadas[i];
			}

			return new Vector(nuevo);
		}
	}

	@Override
	public String toString(){
		return "Coordenadas ["+ coordenadas[0]+ ", "+ coordenadas[1]+ ", "+ coordenadas[2]+ "]";
	}
}
