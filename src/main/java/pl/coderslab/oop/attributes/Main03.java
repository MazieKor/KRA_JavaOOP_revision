package pl.coderslab.oop.attributes;

public class Main03 {

    public static void main(String[] args) {
        Person person = new Person();
        System.out.println("person's name: " + person.name);
        System.out.println("person's surname: " + person.surname);
        int age = person.age;
        System.out.println("person's age: " + age);
        System.out.println("person's gender: " + person.gender);
    }
}
