package fr.ynov.java.medium;

public class Person {

    public enum nationalityEnum {
        FRENCH,
        AMERICAN,
        GERMAN
    }

    String name;
    int age;
    String gender;
    float height;
    float weight;
    nationalityEnum nationality;

    public Person(String name, int age, String gender, float height, float weight, nationalityEnum nationality) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.nationality = nationality;
    }

    public void printAttributes() {
        System.out.println(name + " is a " + nationality + " " + gender + " of " + age + " years old, " + height + "m tall and weighs " + weight + "kg.");
    }

    public static void main(String[] args) {
        Person person1 = new Person("John", 25, "helicopter", 1.80f, 80.0f, nationalityEnum.FRENCH);
        person1.printAttributes();
    }
}
