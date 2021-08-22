package pl.coderslab.oop.advanced;

import org.apache.commons.lang3.ArrayUtils;

import java.text.DecimalFormat;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static pl.coderslab.oop.advanced.StartShopping.*;

public class ShoppingCart {
    CartItem[] cartItems = new CartItem[0];                                          //I don't use static, I want to allow more separate Shopping carts (eg for more buyers)

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (CartItem cItem : cartItems) {
            stringBuilder.append(cItem.toString());
        }
        DecimalFormat form = new DecimalFormat("#,##0.00 PLN");
        String totalSumFormatted = form.format(getTotalSum());
        stringBuilder.append("  ---\n").append("  Total: ").append(totalSumFormatted);
        return stringBuilder.toString();
    }


    public void addProduct(Product product, int quantity){
        if(quantity<0) {
            System.out.println(RED + "You can't add negative number of pieces. Try once again" + RESET);
            return;
        }
        if(updateProduct(product, quantity))
            return;
        System.out.println(" New entry was added to your cart");
        CartItem cartItem = new CartItem(product, quantity);
        this.cartItems = ArrayUtils.add(this.cartItems, cartItem);
        System.out.println(StartShopping.GREEN + quantity + " piece(s) of product " + product.getName() + " was added."+StartShopping.RESET);
    }


    public void removeProduct(Product product) {
        if(cartItems.length == 0){
            System.out.println(RED+"There are no item in your cart. You can't remove anything. Try firstly add some products"+RESET);
            return;
        }
        for (int i = 0; i < cartItems.length; i++) {
            if (cartItems[i].getProduct().getId() == product.getId()) {
                cartItems[i].setQuantity(0);                                                 //I set quantity of product to '0' (not removing product) - in accordance with the literal content of the task
                System.out.println(String.format(GREEN + "There are no more pieces of %s in the cart", product.getName()) + RESET);
                return;
            }
        }
        System.out.println("Product you choose to remove doesn't exist in the cart");          //just in case, additional validation and message
    }

//2nd option of remove method   - I create 2nd option of remove method, which remove an item from cart, not only set quantity to 0 (as it was in the content of the task)
    public void removeProduct2(Product product) {
        if(cartItems.length == 0){
            System.out.println(RED+"There are no items in your cart. You can't remove anything. Try firstly add some products"+RESET);
            return;
        }
        for (int i = 0; i < cartItems.length; i++) {
            if (cartItems[i].getProduct().getId() == product.getId()) {
                cartItems = ArrayUtils.remove(cartItems, i);
                System.out.println(String.format(GREEN + "Product %s was deleted from your cart", product.getName()) + RESET);
                return;
            }
        }
        System.out.println("Product you choose to remove doesn't exist in the cart");
    }


//updateProduct method - I could also simplify that by treating 'quantity' parameter just as new quantity to set (not quantity to add/decrease from old quantity) - but here I want to exercise some coding and that's why I decided to adding/subtracting instead of setting
    public boolean updateProduct(Product product, int quantity){
        for (int i = 0; i < cartItems.length; i++) {
            if (cartItems[i].getProduct().equals(product)) {                                 //instead of "if (cartItems[i].getProduct().getId() == product.getId())" as in removeProduct method I use here newly overridden 'equals' method from class Product
                int quantityBeforeChange = cartItems[i].getQuantity();
                cartItems[i].setQuantity(Math.max(quantityBeforeChange + quantity, 0));       //I use max because in this method I allow also to decrease quantity of product.
                if(quantity >= 0)
                    System.out.println(GREEN + quantity + " piece(s) of product " + product.getName() + " was added." + RESET);
                else
                    System.out.println(GREEN + Math.min(quantityBeforeChange, -quantity) + " piece(s) of product " + product.getName() + " was deleted." + RESET);
                return true;
            }
        }
        System.out.print("Product you choose doesn't exist in the cart.");
        return false;
    }


    public int getTotalQuantity(){
        int totalQuantity = 0;
        for(CartItem cartItem : cartItems){
            totalQuantity += cartItem.getQuantity();
        }

//test version - using of Stream
//        int totalQuantityStream = Stream.of(cartItems).mapToInt(CartItem::getQuantity).sum();

    return totalQuantity;
    }


    public double getTotalSum(){
        double totalSum = 0;
        for (CartItem cartItem : cartItems) {
            totalSum += cartItem.getQuantity() * cartItem.getProduct().getPrice();
        }
        return totalSum;
    }


    public boolean printReceipt(){
        if(cartItems.length == 0) {
            System.out.println(RED + "There are no items in your cart. Please firstly add some products to display the receipt or do any operation" + RESET);
            return false;
        }
        System.out.println(this);                                                 //System.out.println automatically uses toString method of the object, the same would be if I write sout(toString()) (but not only sout() )
        return true;
    }


//additional method
    public Product getProductFromCartItems(int id){                             //I create additional method to use it within the framework of 'updateProduct' functionality in form as it was defined in text of the task ( 'updateProduct(Product product, int quantity)' )
        for (int i = 0; i < this.cartItems.length; i++) {
            if(this.cartItems[i].getProduct().getId() == id){
                return Product.getProduct(id);                                  //Instead of that I could use also simple "return cartItems[i].getProduct();". I wanted to exercise static methods and I use static 'getProduct' method from Product class (which was created for another functionality - adding chosen products to a Shopping Cart)
            }
        }
        throw new NoSuchElementException("There is no such element on your cart.");
    }
}
