package pl.coderslab.oop.methods;

public class Main01 {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("Alicja");
        person.setSurname("CodersLab_Revision");
        person.setAge(35);
        person.setGender('k');

        person.increaseAge();
        System.out.println("nowy wiek osoby: " + person.increaseAge());  //result = 37


        Car car = new Car();
        car.setBrand("BMW");
        car.setModel("Z3");
        System.out.println(car); //without setting default value = 0.0 NEW: automatycznie metodę toString wywołuje
        car.setPrice(1999.98);
        String carData = car.toString();
        System.out.println("result of toString: " + carData);


    }
}
