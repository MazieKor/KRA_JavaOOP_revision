package pl.coderslab.oop.advanced;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Objects;

public class Product {
    private static int idStatic = 1;
    private final int id;
    private String name;
    private double price;

    private static Product[] products = new Product[0];               //additional field to use additional methods (from beyond the scope of the task)

    public Product(String name, double price){
        setPrice(price);                                              //I use it as first in constructor so in case of Exception idStatic is not increased. In accordance with literal task content I do this validation in constructor
        this.id = idStatic;
        idStatic++;
        this.name = name;

        products = ArrayUtils.add(products, this);               //using additionally added field
    }

    public static int getIdStatic() {
        return idStatic;
    }

    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public final void setPrice(double price){
        if (price <= 0.01){
            throw new FalsePriceNewException("Price should be greater than 0.01.");     //I throw Exception - in accordance with task content. For that Exception I created new class of Exceptions
        }
        this.price = price;
    }

//additional methods
    public static Product getProduct(int id) {
        if(id < 1 || id > products.length)
            throw new IndexOutOfBoundsException("There is no such element on the list of Products.");
        return products[id-1];
    }

    public static boolean displayAvailableProducts(){
        if(products.length==0) {
            System.out.println(StartShopping.RED + "There are no available product you can choose to add to cart. Add products firstly. " + StartShopping.RESET);
            return false;
        }
        System.out.println(StartShopping.GREEN + "Products you can buy:" + StartShopping.RESET);
        for (Product pr : products) {
            System.out.println("   " + pr.id + ". " + String.format("%-35s",pr.name)+" "+ String.format("%6.2f",pr.price));
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && Double.compare(product.price, price) == 0 && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }
}