public class Cuenta{
	
	private String titular;
	private double cantidad;

	public Cuenta(String titular){
		this.titular=titular;
		cantidad=0;
	}

	public Cuenta(String titular, double cantidad){
		this.titular=titular;
		this.cantidad=cantidad;
	}

	public String getTitular(){
		return titular;
	}

	public void setTitular(String titular){
		this.titular=titular;
	}

	public double getCantidad(){
		return cantidad;
	}

	public void setCantidad(double cantidad){
		this.cantidad=cantidad;
	}

	public void ingresar(double cantidad){
		if(cantidad > 0){
			this.cantidad+=cantidad;
		}
	}

	public double retirar(double cantidad){
		if(cantidad > this.cantidad){
			cantidad=this.cantidad;
			this.cantidad=0;
			return cantidad;
		}else {
			this.cantidad-=cantidad;
			return cantidad;
		}
	}
}
