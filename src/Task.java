import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.Serializable;
public class Task implements Serializable{

    public String name;
    public int index;
    public LocalDateTime deadline;
    protected boolean isComplete;
    protected String description;
    public String status;

    private static final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    public Task(String name, LocalDateTime deadline, String des) {
        this.name = name;
        this.deadline = deadline;
        this.description = des;
        this.isComplete = false;
        this.status = "Pending";
    }
    


    public void addIndex(int indx) {
        this.index = indx;
    }

    public void markComplete() {
        this.isComplete = true;
        this.status = "Completed";
        System.out.println("The task with index " + this.index + " is completed!");
    }

    public void updateDescription(String des) {
        this.description = des;
        System.out.println("Description is updated!");
    }

    public void updateDeadline(LocalDateTime newDeadline) {
        this.deadline = newDeadline;
        System.out.println("Deadline is updated!");
    }

    public int getIndex(){
        return this.index;
    }

    public void printDetails() {
        System.out.println("=========== Task Details ===========");
        System.out.println("Task Name: " + this.name);
        System.out.println("Deadline: " + this.deadline.format(formatter));
        System.out.println("Status: " + this.status);
        System.out.println("Description: " + this.description);
        System.out.println("====================================");
    }

    public String toString() {
        return index + ". " + name + " | " + deadline + " | Completed: " + isComplete;
    }
}