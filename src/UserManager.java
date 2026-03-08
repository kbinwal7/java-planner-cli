import java.util.*;
import java.io.*;

public class UserManager {

    private List<User> users;
    private final String FILE_NAME = "users.dat";

    public UserManager() {
        users = loadUsers();
    }

    public void registerUser(String username, String password) {

        for (User u : users) {
            if (u.getUserName().equals(username)) {
                System.out.println("User already exists.");
                return;
            }
        }

        User newUser = new User(username, password);
        users.add(newUser);

        saveUsers();

        System.out.println("Registration successful.");
    }

    public User login(String username, String password) {

        for (User u : users) {

            if (u.getUserName().equals(username)
                    && u.getPassword().equals(password)) {

                System.out.println("Login successful.");
                return u;
            }
        }

        System.out.println("Invalid username or password.");
        return null;
    }

    public void logout() {
        System.out.println("Logged out.");
    }

    private void saveUsers() {

        try {
            ObjectOutputStream out =
                    new ObjectOutputStream(new FileOutputStream(FILE_NAME));

            out.writeObject(users);
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private List<User> loadUsers() {

        try {

            ObjectInputStream in =
                    new ObjectInputStream(new FileInputStream(FILE_NAME));

            List<User> list = (List<User>) in.readObject();
            in.close();

            return list;

        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}