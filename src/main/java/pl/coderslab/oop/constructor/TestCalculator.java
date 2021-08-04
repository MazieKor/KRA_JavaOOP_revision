package pl.coderslab.oop.constructor;

public class TestCalculator {

    public static void main(String[] args) {
        Calculator calc1 = new Calculator();
        int sum1 = calc1.add(234,45);
        int multiply1 = calc1.multiply(34,2);
        System.out.print("Test po 2 operacjach: ");
        calc1.printOperations();

        calc1.subtract(34,973);
        System.out.print("Test po 3 operacjach: ");
        calc1.printOperations();

        calc1.divided(4,5);
        calc1.divided(32,2.54);
        calc1.divided(0,2);
        System.out.print("Test po 6 operacjach: ");
        calc1.printOperations();

        double divideResult = calc1.divided(4,0);
        System.out.print("Test po dzieleniu przez 0: ");
        calc1.printOperations();

        calc1.clearOperations();
        System.out.print("Test po clearOperations: ");
        calc1.printOperations();
        System.out.println();

        calc1.multiply(32,11);
        calc1.add(32,11);
        System.out.print("Test po clearOperations i ponownym dodaniu operacji: ");
        calc1.printOperations();

        Calculator calc2 = new Calculator();
        System.out.print("Test nowego obiektu, bez operacji: ");
        calc2.printOperations();
        System.out.println();

        calc2.divided(34,3);
        calc2.add(345,999);
        System.out.print("Test nowego obiektu, po 2 operacjach: ");
        calc2.printOperations();

        calc1.add(0,12);
        System.out.print("Test pierwszego obiektu obiektu, 3. operacja: ");
        calc1.printOperations();

        System.out.println("Test zapisane zmienne z początku zadania: " + (sum1 + multiply1));
        System.out.println("Test dzielenia przez 0 w double: " + divideResult);
    }
}
