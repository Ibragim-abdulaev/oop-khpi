package abdulaev;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ua.khpi.oop.abdulaev07.Challanger;
import ua.khpi.oop.abdulaev07.DemandsToWork;
import ua.khpi.oop.abdulaev07.WorkExperience;
import ua.khpi.oop.abdulaev10.MyContainer;
import ua.khpi.oop.abdulaev12.Main;

class test12 {

    MyContainer<Challanger> container = new MyContainer<Challanger>();

    @Test
    void testTask() {
        container = generate("actual");
        MyContainer<Challanger> actual = Main.task(container);
        container.delete(4);
        container.delete(3);
        MyContainer<Challanger> expected = container;
        boolean cmp = compare(expected, actual);
        if(cmp) {
            assertEquals(1,1);
        }else {
            assertEquals(0, 1, "Have to be the same.");
        }
    }

    boolean compare(MyContainer<Challanger> expected, MyContainer<Challanger> actual) {
        String education = null;
        int day = 0;
        int month = 0;
        int year = 0;
        String specializationPrevious = null;
        int experience = 0;
        String specializationNext = null;
        int minSalary = 0;
        String conditions = null;
        boolean check = true;
        boolean temp = false;
        if(expected.getSize() != actual.getSize()) {
            return !check;
        }
        for(int i = 0; expected.getSize() > i; i++) {
            Challanger element = expected.getElement(i);
            education = element.getEducation();
            day = element.getDismissalDay();
            month = element.getDismissalMonth();
            year = element.getDismissalYear();
            specializationPrevious = element.getWorkExperience().getSpecialization();
            experience = element.getWorkExperience().getExperience();
            specializationNext = element.getDemandsToWork().getSpecialization();
            minSalary = element.getDemandsToWork().getMinSalary();
            conditions = element.getDemandsToWork().getConditions();
            Challanger e = actual.getElement(i);
            if(education.equals(e.getEducation())){
                if(day == e.getDismissalDay()) {
                    if(month == e.getDismissalMonth()){
                        if(year == e.getDismissalYear()) {
                            if(specializationPrevious.equals(e.getWorkExperience().getSpecialization())) {
                                if(experience == e.getWorkExperience().getExperience()) {
                                    if(specializationNext.equals(e.getDemandsToWork().getSpecialization())) {
                                        if(minSalary == e.getDemandsToWork().getMinSalary()) {
                                            if(conditions.equals(e.getDemandsToWork().getConditions())) {
                                                temp = true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            check = temp & check;
            temp = false;
        }
        return check;
    }

    MyContainer<Challanger> generate(String str){
        WorkExperience workExperienceAdd1 = new WorkExperience("Manager", 5);
        DemandsToWork demandsToWorkAdd1 = new DemandsToWork("Manager",12600,"Possisbility to dose not have buisness trip.");
        Challanger challangerAdd1 = new Challanger(container.getSize(),"High education",31,7,2020,workExperienceAdd1,demandsToWorkAdd1);
        container.add(challangerAdd1);
        WorkExperience workExperienceAdd2 = new WorkExperience("HR-manager", 15);
        DemandsToWork demandsToWorkAdd2 = new DemandsToWork("HR-manager",26000,"Free coffie. Possisbility to dose not have buisness trip.");
        Challanger challangerAdd2 = new Challanger(container.getSize(),"High education",12,12,2012,workExperienceAdd2,demandsToWorkAdd2);
        container.add(challangerAdd2);
        if(str.equals("expected")) {
            return container;
        }
        WorkExperience workExperienceAdd3 = new WorkExperience("Teacher", 47);
        DemandsToWork demandsToWorkAdd3 = new DemandsToWork("Teacher",26000,"Free coffie. Possisbility to have a nap.");
        Challanger challangerAdd3 = new Challanger(container.getSize(),"High education",6,4,2021,workExperienceAdd3,demandsToWorkAdd3);
        container.add(challangerAdd3);
        WorkExperience workExperienceAdd4 = new WorkExperience("HR-manager", 2);
        DemandsToWork demandsToWorkAdd4 = new DemandsToWork("HR-manager",126000,"Free coffie. Possisbility to dose have buisness trip.");
        Challanger challangerAdd4 = new Challanger(container.getSize(),"School education",7,8,2018,workExperienceAdd4,demandsToWorkAdd4);
        container.add(challangerAdd4);
        return container;
    }

}
