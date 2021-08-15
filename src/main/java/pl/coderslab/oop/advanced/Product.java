package pl.coderslab.oop.advanced;

import org.apache.commons.lang3.ArrayUtils;

public class Product {
    private static int idStatic = 1;          //NEW: static inicjalizowane tylko raz (?)
    private final int id;                     //NEW: podpowiedź żeby zrobić final
    private String name;
    private double price;

    private static Product[] products = new Product[0];        //additional field to use additional methods (from beyond the scope of the task) //NEW sposób na dostanie się do obiektu/produktu który wcześniej stworzyłem - stworzenie tablicy statycznej w tej klasie gdzie są zapisywane stworzone rzeczy

    public Product(String name, double price){
        setPrice(price);                    //I use it as first in constructor so in case of Exception idStatic is not increased +NEW
        this.id = idStatic;
        idStatic++;                        //NEW sposób na zrobienie uniklanej wartości
        this.name = name;

        products = ArrayUtils.add(products, this);    //additional field   //NEW: dodawanie obiektu po inicjalizacji w konstr.
    }

    public static int getIdStatic() {       //NEW do statycznego pola getter też statyczny (tak pokazał IntelliJ i ja tez tak myślałem)
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
            throw new FalsePriceNewException("Price should be greater than 0.01.");     //I throw Exception - according to task content
        }
        this.price = price;
    }

//additional methods
    public static Product getProduct(int id) {
        if(id < 1 || id > products.length)
            throw new IndexOutOfBoundsException("There is no such element on the list of Products.");      //NEW: jak mi nic nie pasuje a musze zwrócić product - zwracam błąd lub moge też null
        return products[id-1];
    }

    public static void displayAvailableProducts(){
        if(products.length==0) {
            System.out.println(StartShopping.RED + "There are no available product you can choose to add to cart. Add products firstlty. " + StartShopping.RESET);
            return;
        }
        System.out.println(StartShopping.GREEN + "Products you can choose:" + StartShopping.RESET);
        for (Product pr : products) {
            System.out.println("   " + pr.id + ". " + String.format("%-35s",pr.name)+" "+ String.format("%6.2f",pr.price));    //NEW nowy sposób formatowania, ze Stringa wstawiam zaledwie "%"
        }
    }

}