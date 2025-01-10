public class EnteroMayor{
	
	public static void main(String []args){
		
		int array[]= {3, 15, 1, 2, 11, 4, 9, 6};
		System.out.println("Mayor valor: "+ mayor(array, 1, array[0]));
	}

	public static int mayor(int[] array, int index, int mayor){
		
		if(index == array.length-1){
			return mayor > array[index] ? mayor : array[index];
		}
		
		return array[index] >= mayor ? mayor(array, index+1, array[index]) : mayor(array, index+1, mayor);
	}
}
