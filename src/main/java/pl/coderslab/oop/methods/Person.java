package pl.coderslab.oop.methods;

public class Person {
    private String name = "Maciek";
    private String surname = "Coders";
    private int age = 32;
    private char gender ='m';

    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setGender(char gender){
        this.gender = gender;
    }

    public int increaseAge(){
        this.age++;
        return this.age;
    }
}
