package pl.coderslab.oop.advanced;

public class CartItem {
    private Product product;
    private int quantity;

    CartItem(Product product, int quantity){
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    void setProduct(Product product) {             //I make it not public
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("  #"+product.getId()).append(": ").append(String.format("%-35s ",product.getName())).
                append(String.format("%3d x ", quantity)).append(String.format("%7.2f = ", product.getPrice())).
                append(String.format("%7.2f",quantity * product.getPrice())).append("\n");
        return stringBuilder.toString();
    }
}