import java.util.ArrayList;

public class Menu{

private String restaurantName;
private ArrayList<MenuItem> menuItemsList = new ArrayList< >(); 
//fixed formatting(?)

	public String getRestaurantName(){
    	return restaurantName;
    }
	public void setRestaurantName(String restaurantName){
    	this.restaurantName = restaurantName;
    }
	public void addMenuItem(MenuItem menuItems){
    	menuItemsList.add(menuItems);
    }
    public ArrayList<MenuItem> getMenuItemList(){
    	return menuItemsList;
    }
	
	public String toString(){

		String str;
		str = "Restaurant Name: " + restaurantName;

			for(MenuItem m : menuItemsList){
				str += "\n" + m;
			}
				return str;
			}

	    }

	