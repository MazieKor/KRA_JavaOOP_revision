package pl.coderslab.oop.advanced;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class StartShopping {
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String BLUE_BOLD = "\033[1;34m";   // BLUE BOLD
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String RESET = "\033[0m";  // Text Reset

    public static final String message = BLUE + "Choose one of the option (type the number):\n" + RESET +
            BLUE + "Products: " +RESET +"1.Add default Products to the pool |  2.Create and add new Product to the pool |  3.Show all Products from the pool you can buy |\n" +
            BLUE + "Your shopping cart: " + RESET + "4.Open new shopping cart |  5.Add product to your cart |  6.Remove product from your cart | \n" +
            "7.Update quantity of products in your cart (for decrease quantity give minus '-' before number) | \n" +
            "8.Display your cart/ receipt |  9.Display total value of your cart |  10.Display total number of products in your cart |  11.Exit";

    public void commandOperations() {
        Scanner scan = new Scanner(System.in);
        ShoppingCart shoppingCart = null;
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
                    addDefaultProducts(loadingDefaultProductsCheck);
                    loadingDefaultProductsCheck = true;
                    continue;
                case 2:
                    addProduct();
                    continue;
                case 3:
                    Product.displayAvailableProducts();
                    continue;
                case 4:
                    if(shoppingCart != null && shoppingCart.cartItems.length > 0){
                        if(!creatingNewShoppingCartValidation())
                            continue;
                    }
                    shoppingCart = new ShoppingCart();
                    System.out.println(GREEN + "New shopping cart was created");
                    continue;
                case 5:
                    if (shoppingCart == null)
                        shoppingCart = new ShoppingCart();
                    chooseProductToAdd(shoppingCart);
                    continue;
                case 6:
                    if (shoppingCart == null)
                        shoppingCart = new ShoppingCart();
                    chooseProductToRemoveOrUpdate(shoppingCart, 1);
                    continue;
                case 7:
                    if (shoppingCart == null)
                        shoppingCart = new ShoppingCart();
                    chooseProductToRemoveOrUpdate(shoppingCart, 2);
                    continue;
                case 8:
                    if (shoppingCart == null)
                        shoppingCart = new ShoppingCart();
                    System.out.println(GREEN + "All products in your current shopping cart:" + RESET);
                    shoppingCart.printReceipt();
                    System.out.println();
                    continue;
                case 9:
                    if (shoppingCart == null)
                        shoppingCart = new ShoppingCart();
                    System.out.println(GREEN + "Total sum you must pay at the moment for all your products is: " + shoppingCart.getTotalSum() + RESET);
                    continue;
                case 10:
                    if (shoppingCart == null)
                        shoppingCart = new ShoppingCart();
                    System.out.println(GREEN + "Total quantity of all your products in your cart is: " + shoppingCart.getTotalQuantity() + RESET);
                    continue;
                case 11:
                    System.out.println(BLUE_BOLD+"You are exiting application. Bye, Bye");
                    break operationsLoop;
                default:
                    System.out.println(RED+"You've chosen number which is not on the list. Try once again." + RESET);
            }
        }
    }


//1.
    public void addDefaultProducts(boolean loadingDefaultProductsCheck) {
        if (checkIfAlreadyLoaded(loadingDefaultProductsCheck)) return;
        new Product("Desk lamp", 12.29);
        new Product("Granite table", 199.99);
        new Product("Set of knives", 75.5);
        new Product("New catalogue", 7);
        System.out.println(GREEN+"Four default products were added to the pool");
    }

    private boolean checkIfAlreadyLoaded(boolean loadingDefaultProductsCheck) {
        if(loadingDefaultProductsCheck) {
            System.out.println(RED + "Default products have been already loaded. Do you want to load the same products once again and create duplicates on the product list (Y/N)?" + RESET);
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


//2.
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
            new Product(productName, productPrice);
            System.out.println(GREEN + "New product was created" + RESET);
        } catch (FalsePriceNewException e) {
            System.out.println(RED + e.getMessage() + " Product was not created" + RESET);
        }
    }


//4.
    public boolean creatingNewShoppingCartValidation(){
        System.out.println(RED+"Creating new shopping cart means that all your purchases from current shopping cart will be deleted. Are you sure ypu want to create a new shopping cart (Y/N)?" + RESET);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String answer = scanner.nextLine().trim();
            if (answer.equalsIgnoreCase("N"))
                return false;
            if (!answer.equalsIgnoreCase("Y")) {
                System.out.println(RED + "You didn't choose 'Y' nor 'N'. Please type once again. Do you want to load the same default products once again (Y/N)?" + RESET);
                continue;
            }
            return true;
        }
    }


//5.
    public void chooseProductToAdd(ShoppingCart shCart){
        Scanner scanner = new Scanner(System.in);
        if(!Product.displayAvailableProducts())
            return;
        while(true) {
            System.out.println(GREEN+"Choose which product you want to add to your cart. Type number of the product.\n" + RESET + "If you want to quit this option type 'quit'. If you want to see available Products again type 'list'");
            String chosenProductNumber = scanner.nextLine().trim();
            int resultOfValidation = messageValidation(chosenProductNumber, 1, shCart);
            if(resultOfValidation == 0)
                return;
            if(resultOfValidation == 1)
                continue;
            Product productToAdd;
            try {
                productToAdd = Product.getProduct(Integer.parseInt(chosenProductNumber));
            } catch (IndexOutOfBoundsException e) {
                System.out.println(RED + e.getMessage() + " Try again" + RESET);
                continue;
            }
            System.out.println("Type the quantity you want to add");
            while (!scanner.hasNextInt()) {
                System.out.println(RED + "You didn't enter a number. Try once again" + RESET);
                scanner.next();
            }
            shCart.addProduct(productToAdd,scanner.nextInt());
            break;
        }
    }

    public int messageValidation(String scanToValidate, int labelOfMethod, ShoppingCart shCart){
        if (scanToValidate.equalsIgnoreCase("quit")) {
            System.out.println(GREEN + "You decided to quit this option" + RESET);
            return 0;
        }
        if (scanToValidate.equalsIgnoreCase("list")) {
            switch(labelOfMethod) {
                case 1: Product.displayAvailableProducts();
                    break;
                case 2: shCart.printReceipt();
                    break;
                default: System.out.println(RED + "There is an error. Check all methods" + RESET);
            }
            return 1;
        }
        if (!NumberUtils.isDigits(scanToValidate)) {
            System.out.println(RED + "You didn't enter a number. Try once again" + RESET);
            return 1;
        }
        return 2;
    }


// 6 + 7.
    public void chooseProductToRemoveOrUpdate(ShoppingCart shCart, int labelMethod) {
        String removeMessage = GREEN+"Which product you want to remove from cart? Type number of the product (without '#').\n" + RESET + "If you want to quit this option type 'quit'. If you want to see products in your cart again type 'list'"+RESET;
        String updateMessage = GREEN+"For which product you want to change quantity? Type number of the product (without '#').\n" + RESET + "If you want to quit this option type 'quit'. If you want to see products in your cart again type 'list'"+RESET;

        Scanner scanner = new Scanner(System.in);
        if(!shCart.printReceipt())
            return;
        while(true){
            if (labelMethod == 1)
                System.out.println(removeMessage);
            else
                System.out.println(updateMessage);
            String chosenProductNumber = scanner.nextLine().trim();
            int resultOfValidation = messageValidation(chosenProductNumber,2,shCart);
            if(resultOfValidation == 0)
                return;
            if (resultOfValidation == 1)
                continue;
            Product product;
            try{
                product = shCart.getProductFromCartItems(Integer.parseInt(chosenProductNumber));       //(validation of parsing of String is made in 'messageValidation' method)
            } catch (NoSuchElementException e){
                System.out.println(RED + e.getMessage() + " Try again" + RESET);
                continue;
            }
            if (labelMethod == 1) {
                shCart.removeProduct2(product);
                break;
            }
            System.out.println("Type the quantity you want to add or subtract (for decreasing quantity type minus '-' before number)");
            while (!scanner.hasNextInt()) {
                System.out.println(RED + "You didn't enter a number. Try once again" + RESET);
                scanner.next();
            }
            shCart.updateProduct(product,scanner.nextInt());
            break;
        }
    }
}