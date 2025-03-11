package fr.ynov.java.medium;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {

    public static void readFile(String filePath) {
        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
    }

    public static void createFolder(String folderPath) {
        File theDir = new File(folderPath);
        if (!theDir.exists()) {
            theDir.mkdirs();
        }
    }

    public static void createFile(String filePath) {
        try {
            File myObj = new File(filePath);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred.");
        }
    }

    public static void writeInFile(String filePath, String text) {
        try {
            java.io.FileWriter myWriter = new java.io.FileWriter(filePath);
            myWriter.write(text);
            myWriter.close();
            System.out.println("Successfully wrote into " + filePath);
        } catch (Exception e) {
            System.out.println("An error occurred.");
        }
    }

    public static void main(String[] args) {
        createFolder("src/fr/ynov/java/medium/awesome_folder");
        for (int i = 0; i < 10; i++) {
            createFile("src/fr/ynov/java/medium/awesome_folder/awesome_file" + i + ".txt");
            String helloWorldText = "Hello World number " + i + " !";
            writeInFile("src/fr/ynov/java/medium/awesome_folder/awesome_file" + i + ".txt", helloWorldText);
        }
        System.out.println("------------------------\nReading files...");
        for (int i = 0; i < 10; i++) {
            readFile("src/fr/ynov/java/medium/awesome_folder/awesome_file" + i + ".txt");
        }
    }
}
