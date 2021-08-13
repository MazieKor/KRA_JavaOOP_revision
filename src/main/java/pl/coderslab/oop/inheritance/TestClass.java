package pl.coderslab.oop.inheritance;

public class TestClass {

    public static void main(String[] args) {
        Shape shapeFirst = new Shape(4, 2, "red");
        Shape shapeSecond = new Shape(-12, 5.0, "blue");

        System.out.println(shapeFirst.getDescription());
        System.out.println("Distance from the center of the second shape: " + shapeSecond.getDistance(shapeFirst));
        System.out.println("Distance from the center of the second shape (2nd test): " + shapeFirst.getDistance(shapeSecond));

//2nd task:
        System.out.println("\nSecond Task:");
        Circle cr = new Circle(3,8,"yellow",13);
        System.out.println(cr.getDescription());
        Circle cr2 = new Circle(12.4, -7, "indygo", 9.7);
        System.out.println("Distance from the center of the second circle: " + cr.getDistance(cr2));
        System.out.println(String.format("Area and circit of the circle are: %.4f sq units, %.3f units.", cr2.getArea(), cr2.getCircuit()));

        Shape shapeCircle = new Circle(2,12,"pink",8);
        System.out.println("shapeCircle (overriden) description: " + shapeCircle.getDescription());

    }
}
