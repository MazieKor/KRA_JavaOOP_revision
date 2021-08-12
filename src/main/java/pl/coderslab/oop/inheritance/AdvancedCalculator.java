package pl.coderslab.oop.inheritance;

import org.apache.commons.lang3.ArrayUtils;
import pl.coderslab.oop.constructor.Calculator;     //New

import java.util.Arrays;

public class AdvancedCalculator extends Calculator {


    public double pow (double num1, double num2) {
        double result = Math.pow(num1, num2);
        String [] tab = getTab();         //I use created protected getter, because tab is private
        tab = Arrays.copyOf(tab, tab.length+1);
        tab[tab.length - 1] = num1 + " ^ " + num2 + " got " + result;
        setTab(tab);                      //I use setter to provide newly created object (Array)
        return result;
    }

    public double root(double num1, double num2){
        double result = Math.pow(num1, 1/num2);
        String[] tab = getTab();
        tab = ArrayUtils.add(tab, num2 + " root of " + num1 + " equals " + result);
        setTab(tab);                    //NEW: Without setting, in the line above I create new object which is never assigned to field 'tab' in class Calculator Bez setowania tablicy w linii wyżej robie nowy obiket, który nigdy nie jt przypisany polu w klasie Calculator
        return result;
    }

}
