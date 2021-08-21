package pl.coderslab.oop.inheritance;

import org.apache.commons.lang3.ArrayUtils;
import pl.coderslab.oop.constructor.Calculator;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AdvancedCalculator extends Calculator {            //I want to keep AdvancedCalculator in different package than Calcuator to exercise some stuff (inter alia access modifiers and relations child-parent when in different packages)
    static final double PI = 3.14159265;
    protected static String[] tabStatic = new String[0];

    public static String[] getTabStatic() {
        return tabStatic;
    }

//    static {                                                    //static block to test in which moment class is initialized (it can be initialized through using a method from Calculator class, which method, in turn, uses static method getTabStatic from AdvCalc. class)
//        System.out.println("start Advanced CLASS");
//    }

    public static void setTabStatic(String[] tab) {
        tabStatic = tab;
    }

    public double pow(double num1, double num2) {
        double result = Math.pow(num1, num2);
        String[] tab = getTab();         //I use created protected getter, because tab is private
        tab = Arrays.copyOf(tab, tab.length + 1);
        tab[tab.length - 1] = num1 + " ^ " + num2 + " got " + result;
        setTab(tab);                      //I use setter to provide newly created object (Array)

//adding new static tab
        tabStatic = ArrayUtils.add(tabStatic, "Result pow method: " + result);

        return result;
    }

    public double root(double num1, double num2) {
        double result = Math.pow(num1, 1 / num2);
        String[] tab = getTab();
        tab = ArrayUtils.add(tab, num2 + " root of " + num1 + " equals " + result);
        setTab(tab);                    //Without setting, in the line above I create new object which is never assigned to field 'tab' in class Calculator

//adding new static tab
        tabStatic = ArrayUtils.add(tabStatic, "Result root method: " + result);

        return result;
    }

    public static double computeCircleArea(double r) {        //Method doesn't add new entry to tab Array (field from Calculator class), since tab is instance field, so assigned to individual instance, and this method is a class (static) one
//adding new static tab
        tabStatic = ArrayUtils.add(tabStatic, "Result circle area method: " + (PI * Math.pow(r, 2)));

        return PI * Math.pow(r, 2);
    }

    public static void printGlobalOperations() {
        System.out.println("All operations from static Array:");
        for (String row : tabStatic) {
            System.out.println(row);
        }
    }

    public static void printGlobalOperations(int length) {
        if (tabStatic.length < length) {
            System.out.println("There are no so much (" + length + ") operations in Array memory. Give another number");
            return;
        }
        System.out.println("Last " + length + " operations from static Array:");
        for (int i = tabStatic.length - length; i < tabStatic.length; i++) {
            System.out.println(tabStatic[i]);
        }
    }

    public static void printGlobalOperations(String length) {           //new method with String parameter - according to task content
        int lengthInt;
        try {
            lengthInt = new Scanner(length.trim()).nextInt();       //using different way of parsing
        } catch (InputMismatchException e){
            System.out.println("False argument. Give an integer number in form of String");
            return;
        }
        printGlobalOperations(lengthInt);
    }
}
