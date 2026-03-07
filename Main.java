import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        UserManager manager = new UserManager();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy HH mm");

        while (true) {

            System.out.println("\n==== Planner Application ====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int option = Integer.parseInt(sc.nextLine());

            if (option == 1) {

                System.out.print("Enter username: ");
                String username = sc.nextLine();

                System.out.print("Enter password: ");
                String password = sc.nextLine();

                manager.registerUser(username, password);
            }

            else if (option == 2) {

                System.out.print("Enter username: ");
                String username = sc.nextLine();

                System.out.print("Enter password: ");
                String password = sc.nextLine();

                Planner planner = manager.login(username, password);

                if (planner == null) continue;

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

                    if (action == 1) {
                        planner.viewTasks();
                    }

                    else if (action == 2) {

                        System.out.print("Task Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter deadline (dd MM yyyy HH mm): ");
                        String dateInput = sc.nextLine();

                        LocalDateTime deadline = LocalDateTime.parse(dateInput, formatter);

                        System.out.print("Description: ");
                        String desc = sc.nextLine();

                        planner.addNewtask(name, deadline, desc);
                    }

                    else if (action == 3) {

                        System.out.print("Enter task index: ");
                        int idx = Integer.parseInt(sc.nextLine());

                        planner.findTask(idx);
                    }

                    else if (action == 4) {

                        System.out.print("Enter task index: ");
                        int idx = Integer.parseInt(sc.nextLine());

                        planner.completeTask(idx);
                    }

                    else if (action == 5) {

                        System.out.print("Enter task index: ");
                        int idx = Integer.parseInt(sc.nextLine());

                        planner.removeTask(idx);
                    }

                    else if (action == 6) {
                        manager.logout();
                        break;
                    }

                    else {
                        System.out.println("Invalid choice.");
                    }
                }
            }

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