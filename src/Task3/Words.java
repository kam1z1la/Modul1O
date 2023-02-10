package Task3;

import java.io.*;
import java.util.*;

public class Words {
    private static StringBuilder word = new StringBuilder();
    private static LinkedList<String> listWords = new LinkedList<>();
    private static HashMap<String,Integer> mapWords = new HashMap<>();
        
    public static void putWordsInFile(File file) {
        try(BufferedWriter words = new BufferedWriter(new FileWriter(file))){
            words.write(changeLinkedListToString(listWords));
            words.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String changeLinkedListToString(LinkedList<String> listWords){
        return word.append(" ")
                   .append(listWords.toString()
                                    .replaceAll("[\\[\\,\\]]", " ")
                                    .strip()).toString();
    }

    public static LinkedList<String> putWords(String word) {
        StringBuilder string = new StringBuilder();
        for (char c : word.toLowerCase().toCharArray()) {
            if (!Character.isDigit(c))
                string.append(c);
        }

        listWords.add(string.toString().replaceAll("[\\s]+"," ") + "\n");
        return listWords;
    }

    public static void numberOfRepeatedWords(File file) {
        try(BufferedReader read = new BufferedReader(new FileReader(file))){
            while(read.ready()) {
                String[] words  = read.readLine().strip().split(" ");
                Integer counter = 1;
                    for (int i = 0; i < words.length; i++) {
                            if (mapWords.containsKey(words[i])) {
                                counter = mapWords.get(words[i]);
                                counter++;
                                mapWords.put(words[i], counter);
                            } else
                                mapWords.put(words[i], counter);
                        }
            }
            comparator();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void comparator(){
        mapWords.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(System.out::println);
    }
}