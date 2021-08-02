package pl.coderslab.oop.constructor;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

public class Calculator {
    private String[] tab;

    public Calculator(){
        tab = new String[0];  //NEW jeśli zadeklarowałbym zmienną w konstruktorze (String[] tab = ) to nie byłaby ona widoczna gdzie indzie (w innych metodach tej klasy)
    }

    public int add(int num1, int num2){
        int result = num1 + num2;
        this.tab = Arrays.copyOf(this.tab, this.tab.length+1);
        tab[tab.length-1] = "added " + num1 + " to " + num2 + " got " + result;
        return result;
    }

    public int multiply(int num1, int num2){
        int result = num1 * num2;
        String newElementOfTab = "multiplied: " + num1 + " with " + num2 + " got " + result;
        tab = ArrayUtils.add(tab, newElementOfTab);
        return result;
    }

    public int subtract(int num1, int num2){
        int result = num1 - num2;
        tab = ArrayUtils.add(tab, "subtracted " + num1 + " from " + num2 + " got " +result);
        return result;
    }

    public double divided(double num1, double num2){
        if(num2 == 0){
            System.out.println("You can't divid by zero. Choose another number");
            return num1 / num2;
        }

        double result = num1 / num2;
        double resultRounded = Math.round(result*100.0)/100.0;
        String newElementOfTab = "divided " + num1 + " by " + num2 + " got " + resultRounded;
        tab = ArrayUtils.add(tab, newElementOfTab);
        return resultRounded;
    }

    public void printOperations() {
        for (String element : tab) {
            System.out.println(element);
        }
    }

    public void clearOperations(){
        tab = new String[0];
//        Arrays.fill(tab,"");  //another solution - according to literal expression of the task
    }

}
