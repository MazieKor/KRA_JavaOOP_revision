package pl.coderslab.oop.inheritance;

public class Circle extends Shape {
    private double radius;

    public Circle(double x, double y, String color, double radius){
        super(x, y, color);
        this.radius = radius;
    }

    public String getDescription(){
        return String.format("Center of the Shape is: %s, %s, color is %s and radius: %s", x, y, color, radius) ;
    }

    public double getArea(){
        AdvancedCalculator advCalculator = new AdvancedCalculator();
        double radiusSquared = advCalculator.pow(radius, 2);
        return Math.PI * radiusSquared;
    }

    public double getCircuit(){
        return 2 * Math.PI * radius;
    }

}
