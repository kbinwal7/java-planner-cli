import java.util.*;
import java.io.*;
import java.time.LocalDateTime;

public class Planner implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Task> myList;
    private final String FILE_NAME = "tasks.dat";
    private int len;

    public Planner() {
        myList = loadTasks();
        len = myList.size();
    }


    public void viewTasks() {
        for (Task t : myList) {
            System.out.println(t);
        }
    }

    public void addNewTask(Task task) {
        task.addIndex(len);
        ++len;
        myList.add(task);
        saveTasks();
        System.out.println(new java.io.File("tasks.dat").getAbsolutePath());
    }

    public void addNewTask(String name, LocalDateTime deadline, String des) {
        Task curr=new Task(name,deadline,des);
        curr.addIndex(len);
        ++len;
        myList.add(curr);
        saveTasks();
    }

    public Task findTask(int index) {
        for (Task t : myList) {
            if (t.getIndex() == index)
                return t;
        }
        return null;
    }

    public void removeTask(int index) {
        myList.removeIf(t -> t.getIndex() == index);
        saveTasks();
    }

    public void completeTask(int index) {
        Task t = findTask(index);
        if (t != null) {
            t.markComplete();
            saveTasks();
        }
    }

    private void saveTasks() {
        try {
            ObjectOutputStream out =
                new ObjectOutputStream(new FileOutputStream(FILE_NAME));

            out.writeObject(myList);
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Task> loadTasks() {

    try {
        ObjectInputStream in =
            new ObjectInputStream(new FileInputStream(FILE_NAME));

        List<Task> tasks = (List<Task>) in.readObject();

        in.close();

        return tasks;

    } catch (Exception e) {
        return new ArrayList<>();
    }
}
}