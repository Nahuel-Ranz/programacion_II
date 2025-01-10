public class delUnoAlDiez {
	
	public static void main(String []args){
		
		imprimir(10);
	}

	public static void imprimir(int num){
		
		if(num <= 1){

			System.out.print(num);
		}else {

			System.out.print(num+ ", ");
			imprimir(num-1);
		}
	}
}
