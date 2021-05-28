package ua.khpi.oop.abdulaev07;

import java.io.Serializable;

public class WorkExperience implements Serializable {
    private static final long serialVersionUID = -4440232772223195381L;

    public String getSpecialization() {
        return specialization;
    }
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    public int getExperience() {
        return experience;
    }
    public void setExperience(int experience) {
        this.experience = experience;
    }
    public WorkExperience(String specialization, int experience) {
        super();
        this.specialization = specialization;
        this.experience = experience;
    }
    public WorkExperience() {
        super();
        // TODO Auto-generated constructor stub
    }
    private String specialization;
    private int experience;
}
