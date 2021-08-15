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
            "1.Add new Product definition | 2.Add default Products | 3.Display all Products you can buy | \n" +
            "4.Open new shopping cart | 5.Add product to your cart | 6.Remove product from your cart | \n" +
            "7.Update quantity of products in your cart (for decrease quantity give minus '-' before number) | \n" +
            "8.Display total number of products in your cart | 9.Display total value of your cart | 10.Print Receipt | 11.Exit";

    public void commandOperations() {
        Scanner scan = new Scanner(System.in);
        ShoppingCart shoppingCart = null;        //NEW stwarzam obiekt null, by potem w razie czego stwarzać nowy i przypisac do zmiennej
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
                case 9:

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
            System.out.println(GREEN + "New Product was created" + RESET);
        } catch (FalsePriceNewException e) {
            System.out.println(RED + e.getMessage() + " Product was not created" + RESET);
        }
    }

    public void addDefaultProduct() {


    }

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
