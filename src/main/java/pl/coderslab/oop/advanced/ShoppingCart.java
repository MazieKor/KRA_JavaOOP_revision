package pl.coderslab.oop.advanced;

import org.apache.commons.lang3.ArrayUtils;

public class ShoppingCart {
    private CartItem[] cartItems = new CartItem[0];             //NEW w ShoppingCart lepiej operować na pojedyncz. CartItemach niż na parze osobnych product, qunatity (teoretycznie mógłbym jeszcze zrobić tablicę 2-wymiarową, zamiast klasy CartItem). Altrnatywa - tablica x-wym - nowa klasa. W zasadzie CartItem jt używane tylko do wrzucenia do tablicy CartItem (nie tworzę osobnych CartItemów)
                                                                //NEW Nie tworzę pojedynczych CartItem (żeby potem wrzucić do tablicy), ale tworzę tablicę i w jej metodach zapełniam Cartitemami
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (CartItem cItem : cartItems) {
            stringBuilder.append(cItem.toString());
        }
        stringBuilder.append("---\n").append("Total: ").append(getTotalSum());
        return stringBuilder.toString();
    }

    public void addProduct(Product product, int quantity){
        if(quantity<0) {
            System.out.println("You can't add negative number of pieces. Try once again");
            return;
        }
        if(updateProduct(product, quantity))                     //NEW nie muszę przyrównywac do true
            return;
        CartItem cartItem = new CartItem(product, quantity);
        this.cartItems = ArrayUtils.add(this.cartItems, cartItem);
        System.out.println(quantity + " piece(s) of product " + product.getName() + " was added.");
    }

    public void removeProduct(Product product) {
        for (int i = 0; i < cartItems.length; i++) {
            if (cartItems[i].getProduct().getId() == product.getId()) {
                cartItems[i].setQuantity(0);                              //I set quantity of product to '0' (not removing product) - according to literal content of the task
                System.out.println(String.format("There are no more pieces of %s in the cart", product.getName()));
                return;
            }
        }
        System.out.println("Product you choose to remove doesn't exist in the cart");
    }

    public boolean updateProduct(Product product, int quantity){
        for (int i = 0; i < cartItems.length; i++) {
            if (cartItems[i].getProduct().getId() == product.getId()) {        //NEW dostanie się do pola pola
                int quantityBeforeChange = cartItems[i].getQuantity();
                cartItems[i].setQuantity(Math.max(quantityBeforeChange + quantity, 0));           //I use max because in this method I allow also to decrease quantity of product
                if(quantity >= 0)
                    System.out.println(quantity + " piece(s) of product " + product.getName() + " was added.");
                else
                    System.out.println(Math.min(quantityBeforeChange, -quantity) + " piece(s) of product " + product.getName() + " was deleted.");
                return true;
            }
        }
        System.out.println("Product you choose to update quantity doesn't exist in the cart");
        return false;
    }
    public int getTotalQuantity(){
        int totalQuantity = 0;
        for(CartItem cartItem : cartItems){
            totalQuantity += cartItem.getQuantity();
        }
    return totalQuantity;
    }
    public double getTotalSum(){
        double totalSum = 0;
        for (CartItem cartItem : cartItems) {
            totalSum += cartItem.getQuantity() * cartItem.getProduct().getPrice();
        }
        return totalSum;
    }
    public void printReceipt(){
        System.out.println(this);          //NEW: System.out.println automatically uses toString method
    }

//additional methods
//    public void displayAvailableProducts(){
//        for (int i = 0; i < ; i++) {
//
//        }
//    }


}
