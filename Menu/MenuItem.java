public abstract class MenuItem{

	private String name;
	private double price;
	private int orderCode;

	public MenuItem(){};

	public MenuItem(String name, double price, int orderCode){

		this.name = name;
		this.price = price;
		this.orderCode = orderCode;
	}

	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public double getPrice(){
		return price;
	}
	public void setPrice(double price){
		this.price = price;
	}
	public int getOrderCode(){
		return orderCode;
	}
	public void setOrderCode(int orderCode){
		this.orderCode = orderCode;
	}

@Override

	public String toString(){
		return "MenuItems: [Item: " + name + " Price: " + price + " OrderCode: " + orderCode + "]";
	}
	
}

//JESUS CHRIST VEVO