import Task2.User;
import Task1.Number;
import Task3.Words;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File fileNumbers = new File("test.txt");
        if (!fileNumbers.exists()) {
            fileNumbers.createNewFile();
            System.out.println("file create");
        }
        Number.writeNumber();
        Number.printNumber(fileNumbers);
        System.out.println("//////////////////////////");

        File file2 = new File("file.txt");
        if (!fileNumbers.exists()) {
            fileNumbers.createNewFile();
            System.out.println("file create");
        }

        User<String, Integer> user = new User<>();
        user.put("anna", 23);
        user.put("ryan ", 30);
        user.put("anna ", 30);
        user.put("ryan ", 30);
        user.put("ryan ", 30);

        user.writeContactUsers();
        user.printUsers(file2);

        File json = new File("user.json");
        if (!fileNumbers.exists()) {
            fileNumbers.createNewFile();
            System.out.println("file create");
        }

        user.writeContactUsersInJson(json);

        System.out.println("//////////////////////////");
        File word = new File("words.txt");
        if (!fileNumbers.exists()) {
            fileNumbers.createNewFile();
            System.out.println("file create");
        }

        Words.putWords("the day is 34 sunny the the");
        Words.putWords("the day sunny the the");
        Words.putWords("the sunny is is");
        Words.putWordsInFile(word);
        Words.numberOfRepeatedWords(word);
    }
}
