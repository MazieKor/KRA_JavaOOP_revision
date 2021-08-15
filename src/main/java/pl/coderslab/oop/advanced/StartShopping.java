package pl.coderslab.oop.advanced;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.Scanner;

public class StartShopping {
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String BLUE_BOLD = "\033[1;34m";   // BLUE BOLD
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String RESET = "\033[0m";  // Text Reset

    public static final String message = BLUE + "Choose one of the option (type the number):\n" + RESET +
            "1.Add new Product definition | 2.Load definitions of default Products | 3.Display all Products you can buy | \n" +
            "4.Open new shopping cart | 5.Add product to your cart | 6.Remove product from your cart | \n" +
            "7.Update quantity of products in your cart (for decrease quantity give minus '-' before number) | \n" +
            "8.Display total number of products in your cart | 9.Display total value of your cart | 10.Print Receipt | 11.Exit";

    public void commandOperations() {
        Scanner scan = new Scanner(System.in);
        ShoppingCart shoppingCart = null;        //NEW stwarzam obiekt null, by potem w razie czego stwarzać nowy i przypisac do zmiennej
        boolean loadingDefaultProductsCheck = false;
        operationsLoop:
        while (true) {
            System.out.println(message);
            while (!scan.hasNextInt()) {
                System.out.println(RED + "False argument. Please type a number" + RESET);
                scan.next();
            }
            int chosenOption = scan.nextInt();
            switch (chosenOption) {
                case 1:
                    addProduct();
                    continue;
                case 2:
                    addDefaultProducts(loadingDefaultProductsCheck);
                    loadingDefaultProductsCheck = true;
                    continue;
                case 3:
                    Product.displayAvailableProducts();
                    continue;
                case 4:
                    shoppingCart = new ShoppingCart();       //Stwarzam jedną ShoppingCart i mogę używać tej klasy z jej metodami w pętli, więc ciągle tego samego obiektu
                    continue;
                case 5:
                    if (shoppingCart == null)
                        shoppingCart = new ShoppingCart();
                    chooseProductToAdd(shoppingCart);
                    continue;
                case 7:


                case 8:
                    if (shoppingCart == null)
                        shoppingCart = new ShoppingCart();
                    System.out.println(GREEN + "Total quantity of all your products in your cart is: " + shoppingCart.getTotalQuantity() + RESET);
                case 9:
                    if (shoppingCart == null)
                        shoppingCart = new ShoppingCart();
                    System.out.println(GREEN + "Total sum you must pay at the moment for all your products is: " + shoppingCart.getTotalSum() + RESET);
                case 10:
                    if (shoppingCart == null)
                        shoppingCart = new ShoppingCart();
                    shoppingCart.printReceipt();
                    continue;               //NEW nie potrzebuję tu odniesc się do nazwy loopa
                case 11:
                    System.out.println(BLUE_BOLD+"You are exiting application. Bye, Bye");
                    break operationsLoop;   //NEW potrzebuję tu odniesc się do nazwy loopa
                default:
                    System.out.println(RED+"You've chosen number which is not on the list. Try once again." + RESET);
            }
        }
    }

//1.
    public void addProduct() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Type name of the product");
        String productName = scan.nextLine().trim();
        System.out.println("Type price of the product (more than 0,01)");
        while (!scan.hasNextDouble()) {
            System.out.println(RED + "False argument. Please type a number" + RESET);
            scan.next();
        }
        double productPrice = scan.nextDouble();
        try {
            Product product = new Product(productName, productPrice);
            System.out.println(GREEN + "New product was created\n" + RESET);
        } catch (FalsePriceNewException e) {
            System.out.println(RED + e.getMessage() + " Product was not created" + RESET);
        }
    }

//2.
    public void addDefaultProducts(boolean loadingDefaultProductsCheck) {
        if (checkIfAlreadyLoaded(loadingDefaultProductsCheck)) return;
        Product product1 = new Product("desk lamp", 12.29);
        Product product2 = new Product("granite table", 199.99);
        Product product3 = new Product("set of knives", 75.5);
        Product product4 = new Product("new catalogue", 7);
        System.out.println(GREEN+"Four products were added\n");
    }

    private boolean checkIfAlreadyLoaded(boolean loadingDefaultProductsCheck) {
        if(loadingDefaultProductsCheck) {
            System.out.println(RED + "Default products have been already loaded. Do you want to load the same default products once again (Y/N)?" + RESET);
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String answer = scanner.nextLine().trim();
                if (answer.equalsIgnoreCase("N"))
                    return true;
                if (!answer.equalsIgnoreCase("Y")) {
                    System.out.println(RED + "You didn't choose 'Y' nor 'N'. Please type once again. Do you want to load the same default products once again (Y/N)?"+RESET);
                    continue;
                }
                break;
            }
        }
        return false;
    }

//5.
    public void chooseProductToAdd(ShoppingCart shCart){
        Scanner scanner = new Scanner(System.in);
        Product.displayAvailableProducts();
        while(true) {
            System.out.println("Choose which product you want to add to your cart. Type number of the product. If you want to quit this option type 'quit'. If you want to see available Products again type 'list'");
            String chosenProductNumber = scanner.nextLine().trim();
            if (chosenProductNumber.equalsIgnoreCase("quit")) {
                System.out.println(GREEN + "You decided to quit this option" + RESET);
                return;
            }
            if (chosenProductNumber.equalsIgnoreCase("list")) {
                Product.displayAvailableProducts();
                continue;
            }
            if (!NumberUtils.isDigits(chosenProductNumber)) {
                System.out.println(RED + "You didn't enter a number. Try once again" + RESET);
                continue;
            }
            Product productToAdd;
            try {
                productToAdd = Product.getProduct(Integer.parseInt(chosenProductNumber));
            } catch (IndexOutOfBoundsException e) {
                System.out.println(RED + e.getMessage() + " Try again" + RESET);
                continue;
            }
            System.out.println(GREEN + "Type the quantity you want to buy" + RESET);
            while (!scanner.hasNextInt()) {
                System.out.println(RED + "You didn't enter a number. Try once again" + RESET);
                scanner.next();
            }
            shCart.addProduct(productToAdd,scanner.nextInt());
            break;
        }
    }


}
