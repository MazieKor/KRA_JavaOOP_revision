package pl.coderslab.oop.methods;

public class Car {
    private String brand;
    private String model;
    private double price;

    public void setBrand(String brand){
        this.brand = brand;
    }
    public void setModel(String model){
        this.model = model;
    }
    public void setPrice(double price){
        this.price = price;
    }

    public String getBrand(){
        return brand;
    }
    public String getModel(Car this){
        return model;
    }
    public double getPrice(){
        return price;
    }

    public String toString(){
        return brand + ": " + price;
    }
}