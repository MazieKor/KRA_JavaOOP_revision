package pl.coderslab.oop.firstclass;

public class Main01 {

    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        if (cat.equals(dog))
            System.out.println("object are even");
        else
            System.out.println("objects are not even");

//        if (cat == dog) //error: java incomparable types (nie kompiluje się)
//            System.out.println("object are even");
//        else
//            System.out.println("objects are not even");

    }

}
