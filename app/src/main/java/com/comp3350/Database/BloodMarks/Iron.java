package com.comp3350.Database.BloodMarks;

public class Iron implements IBlood{
    double iron;

    public Iron(double iron){
        this.iron = iron;
    }

    public Iron() {}

    @Override
    public String getGeneralInfo() {
        return "ℹ️ Iron is an essential element for blood production. It is also essential for oxygen distribution in the body.";
    }

    public String getLowSymptoms() {
        return "Experiencing symptoms including getting pale, " +
                "lack of energy, shortness of breath, rapid heartbeat and extreme fatigue? " +
                "Check out Thrives low Iron recommendations.";
    }

    public double getIron() {
        return iron;
    }
}
