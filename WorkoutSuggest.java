public class WorkoutSuggest implements Features {
    private int gender; //"0" for male and "1" for female
    private int goal; //"0" for tone up, "1" for build muscle and "2" for loose fat

    //Constructor
    public WorkoutSuggest(User user) {
        gender = user.getGender();
        goal = -1;
    }

    @Override
    public void getInput() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void getOutput() {
        if(gender == 0) {
            if(goal == 0) {
                // Doc1.pdf
            }
            else if(goal == 1) {
                // Doc2.pdf
            }
            else if(goal == 2) {
                // Doc3.pdf
            }
            else {
                // goal input incorrect
            }
        }
        else if(gender == 1) {
            if(goal == 0) {
                // Doc4.pdf
            }
            else if(goal == 1) {
                // Doc5.pdf
            }
            else if(goal == 2) {
                // Doc6.pdf
            }
            else {
                // goal input incorrect
            }
        }
        else {
            // gender input incorrect 
        }
    }
    
}