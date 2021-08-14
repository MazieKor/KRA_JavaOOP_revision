package pl.coderslab.oop.advanced;

public class Product {
    private static int idStatic = 1;          //NEW: static inicjalizowane tylko raz (?)
    private final int id;                     //NEW: podpowiedź żeby zrobić final
    private String name;
    private double price;

    public Product(String name, double price){
        this.id = idStatic;
        idStatic++;                        //NEW sposób na zrobienie uniklanej wartości
        this.name = name;
        setPrice(price);
    }

    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public final void setPrice(double price){
        if (price <= 0.01){
            throw new IllegalArgumentException("Price should be greater than 0.01");     //I throw Exception - according to task content
        }
        this.price = price;
    }
}