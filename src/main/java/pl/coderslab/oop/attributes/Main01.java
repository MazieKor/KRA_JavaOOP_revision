package pl.coderslab.oop.attributes;

import java.util.Arrays;

public class Main01 {

    public static void main(String[] args) {
        AccessModifier testAttribute = new AccessModifier();
        System.out.println(testAttribute.protectedAttribute);  //null automatically assigned
        System.out.println(testAttribute.publicAttribute);  //null automatically assigned

        System.out.println(Arrays.toString(testAttribute.tab));

//        TEST:
//        String localVariable;
//        System.out.println(localVariable);  //not possible, must be initialized
    }
}
