package ua.khpi.oop.abdulaev07;

import java.io.Serializable;

public class DemandsToWork implements Serializable  {
    private static final long serialVersionUID = 8676463924474477917L;

    private String specialization;
    private int minSalary;
    private String conditions;

    public DemandsToWork(String specialization, int minSalary, String conditions) {
        this.specialization =specialization;
        this.minSalary = minSalary;
        this.conditions = conditions;
    }
    public DemandsToWork()
    {
        super();
    }

    public String getSpecialization() {
        return specialization;
    }
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getMinSalary() {
        return minSalary;
    }
    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    public String getConditions() {
        return conditions;
    }
    public void setConditions(String conditions) {
        this.conditions = conditions;
    }
}
