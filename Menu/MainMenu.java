import java.util.ArrayList;
import java.util.Scanner;

	public class MainMenu {

	public static void main(String[] args) {

		MenuItem menuItems1 = new Entree("Salmon TarTar", 22.00, 101);
		MenuItem menuItems2 = new Entree("Carbonara", 20.80, 201);
		MenuItem menuItems3 = new Drink("White Wine, glass", 8.50, 301);
		MenuItem menuItems4 = new Drink("Red Wine, glass", 8.50, 401);
		MenuItem menuItems5 = new Dessert("Mezcal Paloma Mousse", 12.50, 501);
		MenuItem menuItems6 = new Dessert("Bourbon Mussles", 15.50, 601);
		MenuItem menuItems7 = new Entree("Et Toi Chicken", 29.50, 701);
		MenuItem menuItems8 = new Entree("Baguette with butter", 6.00, 801);
		MenuItem menuItems9 = new Drink("Water", 0.50, 901);
		MenuItem menuItems10 = new Entree("Ratatouille", 38.50, 1001); 


		Menu menuObj = new Menu();

		menuObj.setRestaurantName("Le Bougie");
		menuObj.addMenuItem(menuItems1);
		menuObj.addMenuItem(menuItems2);
		menuObj.addMenuItem(menuItems4);
		menuObj.addMenuItem(menuItems5);
		menuObj.addMenuItem(menuItems6);
		menuObj.addMenuItem(menuItems7);
		menuObj.addMenuItem(menuItems8);
		menuObj.addMenuItem(menuItems9);
		menuObj.addMenuItem(menuItems10);


		Ticket ticketObj = new Ticket();
		
		ticketObj.setTableNumber(501);

		ArrayList<MenuItem> menuList = new ArrayList< >();

		ticketObj.setMenuItemList(menuList);

		Scanner sc = new Scanner(System.in);

		int choice = 0, orderCode = 0;

		while(choice != 4){

			System.out.println("What would you like to eat today?");
			System.out.println("Press 1 to display the menu ");
			System.out.println("Press 2 to add an item to your order");
			System.out.println("Press 3 to list the items you've ordered ");
			System.out.println("Press 4 to quit this program ");

			choice = sc.nextInt();

			if(choice == 1){
				
				System.out.println(menuObj);
			}
			
			else if(choice == 2){
				
				System.out.println("Please enter the order code ");
				orderCode = sc.nextInt();

				int found = 0;

				for(MenuItem item : menuObj.getMenuItemList()){

					if(item.getOrderCode() == orderCode){
						menuList.add(item);
						found = 1;
						System.out.println("Item added successfully!");

						break;
					}
				}

				if(found != 1){
					System.out.println("Sorry, that isn't an order code!");
				}
			}
			else if(choice == 3){

				if(menuList.size() == 0){
					System.out.println("You have yet to order anything!");
				}

				else{

					System.out.println("Here is what you have ordered: ");

					for(MenuItem item : menuList){
						System.out.println(item);
					}
				}
			}
		}

		sc.close();

		System.out.println("Here is your Le Bougie order: ");
		System.out.println(ticketObj);
		System.out.println("The cost of your meal is: " + ticketObj.getTotal());

		}

}