import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Planner {

    private List<Task> myList;

    public Planner() {
        this.myList = new ArrayList<>();
    }

    public void viewTasks() {
        for (int i = 0; i < myList.size(); i++) {
            Task t = myList.get(i);
            System.out.println(
                i + ". " + t.name +
                ", Deadline: " + t.deadline +
                ", Status: " + t.status
            );
        }
    }

    public void addNewtask(Task t) {
        t.addIndex(myList.size());
        myList.add(t);
        System.out.println("New Task is added with following details:");
        t.printDetails();
    }

    public void addNewtask(String name, LocalDateTime deadline, String des) {
        Task newTask = new Task(name, deadline, des);
        newTask.addIndex(myList.size());
        myList.add(newTask);
        System.out.println("New Task is added with following details:");
        newTask.printDetails();
    }

    public void findTask(int indx) {
        if (indx >= 0 && indx < myList.size()) {
            Task curr = myList.get(indx);
            curr.printDetails();
        } else {
            System.out.println("Invalid task index!");
        }
    }

    public void removeTask(int indx) {
        if (indx >= 0 && indx < myList.size()) {
            myList.remove(indx);

            for (int i = 0; i < myList.size(); i++) {
                myList.get(i).addIndex(i);
            }

            System.out.println("Given Task is deleted!");
        } else {
            System.out.println("Invalid task index!");
        }
    }

    public void completeTask(int indx) {
        if (indx >= 0 && indx < myList.size()) {
            Task curr = myList.get(indx);
            curr.markComplete();
        } else {
            System.out.println("Invalid task index!");
        }
    }
}