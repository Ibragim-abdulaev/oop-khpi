package ua.khpi.oop.abdulaev07;

import java.io.Serializable;

public class Challanger implements Serializable {
    private static final long serialVersionUID = -8290634946232397672L;

    private int registrationNum;
    private String education;
    private int dismissalDay;
    private int dismissalMonth;
    private int dismissalYear;
    private DemandsToWork demandsToWork;
    private WorkExperience workExperience;

    /**
     * Конструктор
     * @param registrationNum ID претндента
     * @param education образование претендента
     * @param dismissalDay день увольнения претендента
     * @param dismissalMonth месяц увольнения претендента
     * @param dismissalYear год увольнения претендента
     * @param workExperience опыт работы претендента
     * @param demandsToWork пожелания к будующей работе
     */

    public Challanger(int registrationNum, String education, int dismissalDay, int dismissalMonth, int dismissalYear, WorkExperience workExperience, DemandsToWork demandsToWork ) {
        this.registrationNum = registrationNum;
        this.education = education;
        this.dismissalDay = dismissalDay;
        this.dismissalMonth = dismissalMonth;
        this.dismissalYear = dismissalYear;
        this.workExperience = workExperience;
        this.demandsToWork = demandsToWork;
    }
    public Challanger()
    {
        super();
    }
    /**
     * Геттер ID претендента
     * @return ID претендента
     */

    public int getRegistrationNum() {
        return registrationNum;
    }
    /**
     * Сеттер ID претендента
     * @param registrationNum ID претендента
     */

    public void setRegistrationNum(int registrationNum) {
        this.registrationNum = registrationNum;
    }
    /**
     * Геттер образования претендента
     * @return образование претендента
     */

    public String getEducation() {
        return education;
    }
    /**
     * Сеттер образования претендента
     * @param education Образование претендента
     */

    public void setEducation(String education) {
        this.education = education;
    }
    /**
     * Геттер дня увольнения
     * @return день увольнения
     */

    public int getDismissalDay() {
        return dismissalDay;
    }
    /**
     * Сеттер дня увольнеия
     * @param dismissalDay день увольнения
     */

    public void setDismissalDay(int dismissalDay) {
        this.dismissalDay = dismissalDay;
    }
    /**
     * Геттер месяца увольнения
     * @return месяц увольнения
     */

    public int getDismissalMonth() {
        return dismissalMonth;
    }
    /**
     * Сеттер месяца увольнения
     * @param dismissalMonth месяц увольнения
     */

    public void setDismissalMonth(int dismissalMonth) {
        this.dismissalMonth = dismissalMonth;
    }
    /**
     * Геттер года увольнения претендента
     * @return год увольнения
     */

    public int getDismissalYear() {
        return dismissalYear;
    }
    /**
     * Сеттер года увольнения претендента
     * @param dismissalYear год увольнения
     */

    public void setDismissalYear(int dismissalYear) {
        this.dismissalYear = dismissalYear;
    }
    /**
     * Геттер опыта работы претендента
     * @return
     */
    public WorkExperience getWorkExperience() {
        return workExperience;
    }
    /**
    * Сеттер опыта работы претендента
    * @param workExperience
    */
    public void setWorkExperience(WorkExperience workExperience) {
        this.workExperience = workExperience;
    }
    /**
     * Геттер требований к будующей работе
     * @return
     */

    public DemandsToWork getDemandsToWork() {
        return demandsToWork;
    }

    /**
     * Сеттер требований к будующей работе
     * @param demandsToWork
     */

    public void setDemandsToWork(DemandsToWork demandsToWork) {
        this.demandsToWork = demandsToWork;
    }

    public void print() {
        System.out.println("ID: " + getRegistrationNum());
        System.out.println("Образование: " + getEducation());
        System.out.println("Дата увольнения: " + getDismissalDay()+"/" + getDismissalMonth()+"/"+getDismissalYear());
        System.out.println("---Опыт работы---");
        System.out.println("Место предыдущей работы: " + getWorkExperience().getSpecialization());
        if(getWorkExperience().getExperience() <= 4)
            System.out.println("Стаж: " + getWorkExperience().getExperience() + " год(а)");
        else
            System.out.println("Стаж: " + getWorkExperience().getExperience() + " лет");
        System.out.println("---Желания по будующей работе---" );
        if(getDemandsToWork().getMinSalary() == 0 && getDemandsToWork().getSpecialization() == null && getDemandsToWork().getConditions() == null)
            System.out.println("Предендет не имеет никаких желаний по будующей работе");
        else {
            if(getDemandsToWork().getMinSalary() != 0)
                System.out.println("Желаемая минимальная зарплата: " + getDemandsToWork().getMinSalary());
            else
                System.out.println("Желаемая минимальная зарплата: Претендент не имеет пожеланий к этому пунку " );
            if(getDemandsToWork().getSpecialization() != null)
                System.out.println("Желаемая будующая работа: " + getDemandsToWork().getSpecialization());
            else
                System.out.println("Желаемая будующая работа: Претендент не имеет пожеланий к этому пунку");
            if(getDemandsToWork().getConditions() != null)
                System.out.println("Желаемые условия будующей работы: " + getDemandsToWork().getConditions());
            else
                System.out.println("Желаемые условия будующей работы: Претендент не имеет пожеланий к этому пунку");
        }
        System.out.println("------------------------------------------");
    }
}

