package pl.coderslab.oop.inheritance;

public class Shape {
    protected double x;
    double y;
    protected String color;

    public Shape(double x, double y, String color){
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public String getDescription(){
        return "Center of the Shape is " + x + ", " + y + " and color is: " + color;
    }

    public double getDistance(Shape shape){
        AdvancedCalculator advCalc = new AdvancedCalculator();
        double length = Math.abs(this.x - shape.x);
        double height = Math.abs(this.y - shape.y);
        double lengthSquared = advCalc.pow(length, 2);
        double heightSquared = advCalc.pow(height, 2);

        double distance = advCalc.root((lengthSquared + heightSquared), 2);

        return distance;
    }

}
