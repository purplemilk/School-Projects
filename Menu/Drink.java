public class Drink extends MenuItem{

	private char size;

	public Drink(String name, double price, int orderCode){

		super(name, price, orderCode);
		//maybe add something hereb
	}

	public char getSize(){
		return size;
	}
	public void setSize(char size){
		this.size = size;
	}
}