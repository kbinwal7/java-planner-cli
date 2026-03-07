public class User{
    private String userName;
    private String password;
    private Planner myPlanner;

    public User(String username, String password){
        this.userName=username;
        this.password=password;
        this.myPlanner=new Planner();

    }
    public String getUserName(){
        return this.userName;
    }

    public String getPassword(){
        return this.password;
    }

    public Planner getPlanner(){
        return this.myPlanner;
    }
    

    

}