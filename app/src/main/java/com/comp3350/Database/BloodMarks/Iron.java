package com.comp3350.Database.BloodMarks;

public class Iron implements IBlood{
    float iron;

    public Iron(float iron){
        this.iron = iron;
    }

    public Iron() {}

    @Override
    public String getGeneralInfo() {
        String result = "Iron is an essential element for blood production. It is also essential for oxygen distribution in the body.";
        return result;
    }

//    @Override
    public String getLowSymptoms() {
        return "If you are experiencing any of the following symptoms including getting pale, " +
                "lack of energy, shortness of breath, rapid heartbeat and extreme fatigue, check out Thrives low Iron recommendations.";
    }

}
