package pl.coderslab.oop.constructor;

import pl.coderslab.oop.inheritance.AdvancedCalculator;

public class TestCalculator {

    public static void main(String[] args) {
        Calculator calc1 = new Calculator();
        System.out.println("Test przed operacjami: ");
        calc1.printOperations();

        int sum1 = calc1.add(234,45);
        int multiply1 = calc1.multiply(34,2);
        System.out.println("Test po 2 operacjach: ");
        calc1.printOperations();

        calc1.subtract(34,973);
        System.out.println("Test po 3 operacjach: ");
        calc1.printOperations();

        calc1.divided(4,5);
        calc1.divided(32,2.54);
        calc1.divided(0,2);
        System.out.println("Test po 6 operacjach: ");
        calc1.printOperations();

        double divideResult = calc1.divided(4,0);
        System.out.println("Test po dzieleniu przez 0: ");
        calc1.printOperations();

        calc1.clearOperations();
        System.out.println("Test po clearOperations: ");
        calc1.printOperations();
        System.out.println();

        calc1.multiply(32,11);
        calc1.add(32,11);
        System.out.println("Test po clearOperations i ponownym dodaniu operacji: ");
        calc1.printOperations();

        Calculator calc2 = new Calculator();
        System.out.println("Test nowego obiektu, bez operacji: ");
        calc2.printOperations();
        System.out.println();

        calc2.divided(34,3);
        calc2.add(345,999);
        System.out.println("Test nowego obiektu, po 2 operacjach: ");
        calc2.printOperations();

        calc1.add(0,12);
        System.out.println("Test pierwszego obiektu obiektu, 3. operacja: ");
        calc1.printOperations();

        System.out.println("Test zapisane zmienne z początku zadania: " + (sum1 + multiply1));
        System.out.println("Test dzielenia przez 0 w double: " + divideResult);


//Advanced Calculator:
        System.out.println("\nTESTING ADVANCED CALCULATOR");
        AdvancedCalculator advCalc1 = new AdvancedCalculator();
        System.out.println("Test przed operacjami: ");
        advCalc1.printOperations();

        int sumAdv1 = advCalc1.add(24,50);
        int multiplyAdv1 = advCalc1.multiply(13,3);
        System.out.println("Test po 2 operacjach: ");
        advCalc1.printOperations();

        advCalc1.subtract(10,300);
        System.out.println("Test po 3 operacjach: ");
        advCalc1.printOperations();

        advCalc1.divided(4,5);
        System.out.println("Test po 4 operacjach: ");
        advCalc1.printOperations();

        double divideResultAdv = advCalc1.divided(4,0);
        System.out.println("Test po dzieleniu przez 0: ");
        advCalc1.printOperations();

        advCalc1.clearOperations();
        System.out.println("Test po clearOperations: ");
        advCalc1.printOperations();
        System.out.println();

        System.out.println("Test zapisane zmienne z początku zadania: " + (sumAdv1 + multiplyAdv1));
        System.out.println("Test dzielenia przez 0 w double: " + divideResultAdv);

        advCalc1.subtract(10,300);
        advCalc1.divided(4,5);
        System.out.println("Test po 2 nowych operacjach: ");
        advCalc1.printOperations();
        advCalc1.pow(3,3);
        System.out.println("Test po potęgowaniu: ");
        advCalc1.printOperations();
        advCalc1.root(16,2);
        double rootAdv = advCalc1.root(80,3);
        System.out.println("Test po pierwiadtkowaniu: ");
        advCalc1.printOperations();

        advCalc1.add(200,300);
        System.out.println("Test końcowy, po dodaniu jeszcze 1 liczby: ");
        advCalc1.printOperations();

        advCalc1.clearOperations();
        System.out.println("Test po clearOperations: ");
        advCalc1.printOperations();
        System.out.println("Zapamiętany root: " + rootAdv);

    }
}
