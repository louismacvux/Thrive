public class User {
    private String user_id;
    private int gender; //'0' for male and '1' for female

    //Constructor
    public User(String id, int gender) {
        user_id = id;
        this.gender = gender;
    }

    public String getUser_id() {
        return user_id;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

}