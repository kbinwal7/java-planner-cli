import java.util.ArrayList;
import java.util.List;

public class UserManager {

    private List<User> listedUsers;

    public UserManager() {
        this.listedUsers = new ArrayList<>();
    }

    public void registerUser(String u, String p) {
        User user1 = new User(u, p);
        listedUsers.add(user1);
        System.out.println("User registered successfully!");
    }

    public Planner login(String u, String p) {

        for (User user : listedUsers) {
            if (user.getUserName().equals(u) && user.getPassword().equals(p)) {
                System.out.println("Login successful!");
                return user.getPlanner();
            }
        }

        System.out.println("Invalid username or password!");
        return null;
    }

    public void logout() {
        System.out.println("Logout Successful!");
    }
}