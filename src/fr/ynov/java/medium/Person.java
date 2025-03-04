package fr.ynov.java.medium;

import java.util.Date;

public class Person {

    public enum nationalityEnum {
        FRENCH,
        AMERICAN,
        GERMAN
    }

    String name;
    Date birthDate;
    String gender;
    float height;
    float weight;
    nationalityEnum nationality;

    public Person(String name, Date birthDate, String gender, float height, float weight, nationalityEnum nationality) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.nationality = nationality;
    }

    public int getAge() {
        Date currentDate = new Date();
        return currentDate.getYear() - birthDate.getYear();
    }

    public void printAttributes() {
        System.out.println(name + " is a " + nationality + " " + gender + " of " + getAge() + " years old, " + height + "m tall and weighs " + weight + "kg.");
    }

    public static void main(String[] args) {
        Person person1 = new Person("John", new Date(98, 1, 1), "helicopter", 1.80f, 80.0f, nationalityEnum.FRENCH);
        person1.printAttributes();
    }
}
