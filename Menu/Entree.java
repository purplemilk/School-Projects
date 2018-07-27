public class Entree extends MenuItem{

	private boolean vegetarian;

	public Entree(String name, double price, int orderCode){

		super(name, price, orderCode);
		//maybe add something here
	}

	public boolean isVegetarian(){
		return vegetarian;
	}
	public void setVegetarian(boolean vegetarian){
		this.vegetarian = vegetarian;
	}
}