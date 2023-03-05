package deptStore;

import java.util.Scanner;

import deptStore.service.ItemService;
import deptStore.service.ProductService;
import deptStore.service.UserService;

/*
 * Princy is a young girl with the passion to open her own department store. She has bought all the 
products required to the store. She has to go digital and store all her products 
in her website. 
Categorizing the product are done.
 Now help her go ahead for the next step, by creating the user 
accessing her products.
#Check List:
● As an store owner, Princy needs to login in her 
website using username and password
● Validate the credentials and allow to access the options.
● Every item is a product.
 Use ((buyingprice*0.5)+buyingprice)to calculate the sellingPrice.
● Options are (for admin) 
1. List the products in the store (productid, product Name, category, Quantity, 
price )
2. Search the product by using productid
3. List the products by category (Grocery, Stationary, Toiletry, Vegetables)
4. Search the product by using the name and view the details of the product.
5. To check the total amount, spend on her products.
6. Display the Profit amount that she gets on category wise. 
● Options for Customer
1. Existing customer can login and view the products from the store.
2. Allow new customer to register and login to view the products 
3. Provide 100 super coins for the new user as a welcome bonus.
4. Provide filter options based on category and price for the customer
▪ If customer use filter for price, display products with price low to high
▪ If customer use filter for category, allow user to select the category and 
display the product from the specific category.
#Instructions:
o Product Should be class with attributes
1. productid
2. productName
3. sellingPrice
4. availableQuantity
o Create a class for User with attributes
1. username
2. emailId
3. password
4. superCoins
o Create a class for Item with attributes
1. Itemname
2. Category
3. buyingPrice
oCreate product, user, item as a pojo.
 */

public class AppMain {
	private ItemService iserv;
	private ProductService pserv;
	private UserService userv;
	private Scanner sc;	
	
	public AppMain() {
		
	}
	
	public static void main(String[] args) {
		AppMain am = new AppMain();
		am.userv.udao.insertDummyData();
		am.iserv.idao.insertDummyData();
		am.pserv.pdao.insertDummyData();
		am.mainMenu();
	}
	
	public void mainMenu() {
		int choice;
		do {
		sc=new Scanner(System.in);
		System.out.println("-=Main Menu=-");
		System.out.println("1. Log In");
		System.out.println("2. Sign Up");
		System.out.println("3. Exit app");
		choice = sc.nextInt();
		switch(choice) {
		case 1:
			login();
			break;
		case 2:
			signup();
			break;
		case 3:
			break;
		default:
			mainMenu();
		}
		}while(choice!=3);
	}
	
	public void login() {
		sc=new Scanner(System.in);
		System.out.println("-=Log In=-");
		System.out.println("Enter your user name");
		String uname = sc.nextLine();
		System.out.println("Enter your password");
		String pass = sc.nextLine();
		userv.login(uname, pass);
	}
	
	public void signup() {
		sc=new Scanner(System.in);
		System.out.println("-=Sign Up=-");
		userv.signup();
	}
}
