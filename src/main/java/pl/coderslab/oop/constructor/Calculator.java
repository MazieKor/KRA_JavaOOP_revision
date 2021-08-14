package pl.coderslab.oop.constructor;

import org.apache.commons.lang3.ArrayUtils;
import pl.coderslab.oop.inheritance.AdvancedCalculator;

import java.util.Arrays;

public class Calculator {
    private String[] tab;

    public Calculator(){
        tab = new String[0];
    }

    protected String[] getTab(){
        return tab;
    }
    protected void setTab(String[] tab){
        this.tab = tab;
    }

    public int add(int num1, int num2){
        int result = num1 + num2;
        this.tab = Arrays.copyOf(this.tab, this.tab.length+1);  // I don't create and use a seperate method for adding a new element to Array, because I want to exercise different solutions for that (eg. Arrays.copyOf() or ArrayUtils.add())
        tab[tab.length-1] = "added " + num1 + " to " + num2 + " got " + result;

        toStaticTab("add", result);

        return result;
    }

    public int multiply(int num1, int num2){
        int result = num1 * num2;
        String newElementOfTab = "multiplied: " + num1 + " with " + num2 + " got " + result;
        tab = ArrayUtils.add(tab, newElementOfTab);

        toStaticTab("multiply", result);

        return result;
    }

    public int subtract(int num1, int num2){
        int result = num1 - num2;
        tab = ArrayUtils.add(tab, "subtracted " + num1 + " from " + num2 + " got " +result);

        toStaticTab("subtratct", result);

        return result;
    }

    public double divided(double num1, double num2){
        if(num2 == 0){
            System.out.println("You can't divid by zero. Choose another number");
            return num1 / num2;                    //return 'Infinity'
        }
        double result = num1 / num2;
        double resultRounded = Math.round(result*100.0)/100.0;
        String newElementOfTab = "divided " + num1 + " by " + num2 + " got " + resultRounded;
        tab = ArrayUtils.add(tab, newElementOfTab);

        toStaticTab("divided", result);

        return resultRounded;
    }

    public void printOperations() {
        if(tab.length == 0){
            System.out.println("There are no operations saved in the Array");
        }
        for (String element : tab) {
            System.out.println(element);
        }
    }

    public void clearOperations(){
        tab = new String[0];
//        Arrays.fill(tab,"");  //another solution - according to literal expression of the task ("method should erase all saved operations", but there were no information about deleting all elements. Solution with new String[0] seems however better)
    }

    private void toStaticTab(String methodName, double result){     //adding new static tab and entries to it. According to task tabStatic should be in class AdvancedCalculator
        String[] tabStatic = AdvancedCalculator.getTabStatic();
        tabStatic = ArrayUtils.add(tabStatic, String.format("Result %s method: %.4f", methodName, result));
        AdvancedCalculator.setTabStatic(tabStatic);
    }

}