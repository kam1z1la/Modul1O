package Task1;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Number {

    public static void writeNumber() {
        try (FileWriter writer = new FileWriter("test.txt")) {
            String[] string = {"(099)-362-8529 ", "(097)-283-5151 ", "066-621-0416", "252 525 4123", "575 565 2540", "(066)-337-2142"};
            System.out.println("All numbers:");
            for (int i = 0; i < string.length; i++) {
                writer.write(string[i] + "\n");
                System.out.println(string[i]);
            }
            writer.flush();
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printNumber(File file) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String number;
            Pattern pattern = Pattern.compile("^\\(\\d{3}\\)|\\d{3}\\-?\\d{3}\\-?\\d{4}$");
            Matcher matcher;

            System.out.println("All correct numbers:");
            while (bufferedReader.ready()) {
                number = bufferedReader.readLine();
                matcher = pattern.matcher(number);
                if (matcher.find()) {
                    System.out.println(number);
                }
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
