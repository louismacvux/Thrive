package com.comp3350.Database.BloodMarks;

public class Iron implements IBlood{
    float iron;

    public Iron(float iron){
        this.iron = iron;
    }

    public Iron() {}

    @Override
    public String getGeneralInfo() {
        String result = "ℹ️ Iron is an essential element for blood production. It is also essential for oxygen distribution in the body.";
        return result;
    }

//    @Override
    public String getLowSymptoms() {
        return "Experiencing symptoms including getting pale, " +
                "lack of energy, shortness of breath, rapid heartbeat and extreme fatigue? " +
                "Check out Thrives low Iron recommendations.";
    }

}
