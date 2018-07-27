import java.util.ArrayList;

public class Ticket {

	private int tableNumber;
	private ArrayList<MenuItem> menuItemList;
	//fixed formatting
	
	public Ticket(){
		menuItemList = new ArrayList<>();
	}
	public ArrayList<MenuItem> getMenuItemList(){
		return menuItemList;
	}
	public void setMenuItemList(ArrayList<MenuItem> menuItemList){
		this.menuItemList = menuItemList;
	}
	public int getTableNumber(){
		return tableNumber;
	}
	public void setTableNumber(int tableNumber){
		this.tableNumber = tableNumber;
	}
	public double getTotal(){
		double totalPrice = 0;

		for(MenuItem m : menuItemList){
			totalPrice += m.getPrice();
		}
		return totalPrice;
	}
	
	public String toString(){
		
		String str;
		str = "Table Number: " + tableNumber;

		for(MenuItem m : menuItemList){
			str += "\n" + m;
		}
		return str;
	}
}




