import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        UserManager manager = new UserManager();
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd MM yyyy HH mm");

        while (true) {

            System.out.println("\n==== Planner Application ====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int option = Integer.parseInt(sc.nextLine());

            // REGISTER
            if (option == 1) {

                System.out.print("Enter username: ");
                String username = sc.nextLine();

                System.out.print("Enter password: ");
                String password = sc.nextLine();

                manager.registerUser(username, password);
            }

            // LOGIN
            else if (option == 2) {

                System.out.print("Enter username: ");
                String username = sc.nextLine();

                System.out.print("Enter password: ");
                String password = sc.nextLine();

                User user = manager.login(username, password);

                if (user == null) {
                    System.out.println("Login failed.");
                    continue;
                }

                Planner planner = user.getPlanner();

                while (true) {

                    System.out.println("\n===== Planner Menu =====");
                    System.out.println("1. View Tasks");
                    System.out.println("2. Add Task");
                    System.out.println("3. View Task Details");
                    System.out.println("4. Complete Task");
                    System.out.println("5. Remove Task");
                    System.out.println("6. Logout");

                    System.out.print("Enter choice: ");
                    int action = Integer.parseInt(sc.nextLine());

                    // VIEW TASKS
                    if (action == 1) {
                        planner.viewTasks();
                    }

                    // ADD TASK
                    else if (action == 2) {

                        System.out.print("Task Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter deadline (dd MM yyyy HH mm): ");
                        String dateInput = sc.nextLine();

                        LocalDateTime deadline =
                                LocalDateTime.parse(dateInput, formatter);

                        System.out.print("Description: ");
                        String desc = sc.nextLine();

                        planner.addNewTask(name, deadline, desc);
                    }

                    // FIND TASK
                    else if (action == 3) {

                        System.out.print("Enter task index: ");
                        int idx = Integer.parseInt(sc.nextLine());

                        Task t = planner.findTask(idx);

                        if (t != null)
                            System.out.println(t);
                        else
                            System.out.println("Task not found.");
                    }

                    // COMPLETE TASK
                    else if (action == 4) {

                        System.out.print("Enter task index: ");
                        int idx = Integer.parseInt(sc.nextLine());

                        planner.completeTask(idx);
                    }

                    // REMOVE TASK
                    else if (action == 5) {

                        System.out.print("Enter task index: ");
                        int idx = Integer.parseInt(sc.nextLine());

                        planner.removeTask(idx);
                    }

                    // LOGOUT
                    else if (action == 6) {
                        manager.logout();
                        break;
                    }

                    else {
                        System.out.println("Invalid choice.");
                    }
                }
            }

            // EXIT
            else if (option == 3) {
                System.out.println("Exiting application.");
                break;
            }

            else {
                System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}