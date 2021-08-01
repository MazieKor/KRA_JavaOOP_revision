package pl.coderslab.oop.attributes;

public class Main01 {

    public static void main(String[] args) {
        AccessModifier testAttribute = new AccessModifier();
        System.out.println(testAttribute.protectedAttribute);  //null automatically assigned
        System.out.println(testAttribute.publicAttribute);  //null automatically assigned

//        TEST:
//        String localVariable;
//        System.out.println(localVariable);  //not possible, must be initialized

    }
}
