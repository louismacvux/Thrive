public class WorkoutSuggest implements Features {
    private int gender; //"0" for male and "1" for female
    private int goal; //"0" for tone up, "1" for build muscle and "2" for loose fat

    //Constructor
    public WorkoutSuggest(int gender, int goal) {
        this.gender = gender;
        this.goal = goal;
    }

    @Override
    public void getInput() {
        // TODO Auto-generated method stub

    }

    @Override
    public void getOutput() {
        // TODO Auto-generated method stub

    }
    
}