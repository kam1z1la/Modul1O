package Task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.StringJoiner;

public class User<K,V> implements Serializable {
    private ArrayList<String> list;
//    @SerializedName("name")
    private K userID;
//    @SerializedName("age")
    private V userData;
    private ArrayList<User<K, V>> userArray = new ArrayList<>();

    public User() {
        list = new ArrayList<>();
    }

    public User(K userID, V userData) {
        this.userID = userID;
        this.userData = userData;
    }

    public void writeContactUsers() {
        try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("file.txt", false))) {
            writer.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String show() {
        StringJoiner joiner = new StringJoiner(" ");
        String string = list.toString().replaceAll("[\\[\\,\\]]", "").strip();
        joiner.add(" Name").add("Age\n").add(string);
        return joiner.toString();
    }

    public void putObject(K userID, V userData) {
        setUserID(userID);
        setUserData(userData);
        User<K, V> user = new User<>(userID, userData);
        userArray.add(user);
    }

    public void put(K userID, V userData) {
        putObject(userID, userData);
        StringBuilder string = new StringBuilder();
        string.append(userID).append(" ").append(userData + "\n");
        list.add(string.toString());
    }

    public void printUsers(File file) {
        try (ObjectInputStream read = new ObjectInputStream(new FileInputStream(file))) {
            list = (ArrayList<String>) read.readObject();
            System.out.println(show());
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void setUserID(K userID) {
        this.userID = userID;
    }

    public void setUserData(V userData) {
        this.userData = userData;
    }

    public K getUserID() {
        return userID;
    }

    public V getUserData() {
        return userData;
    }

    public void writeContactUsersInJson(File file) {
        try (FileWriter writer = new FileWriter(file)) {
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(User.class, new UserSerializer())
                    .setPrettyPrinting()
                    .create();
            String data = gson.toJson(userArray);
            writer.write(data);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}