package ua.khpi.oop.abdulaev07;

public class RecruitingAgency {
    Challanger[] mas = new Challanger[3];

    /**
     * Метод вывода массива данных
     */

    public void printAll() {
        for(int i = 0 ; i < mas.length; i++) {
            System.out.println("ID: " + mas[i].getRegistrationNum());
            System.out.println("Образование: " + mas[i].getEducation());
            System.out.println("Дата увольнения: " + mas[i].getDismissalDay()+"/"+mas[i].getDismissalMonth()+"/"+mas[i].getDismissalYear());
            System.out.println("---Опыт работы---");
            System.out.println("Место предыдущей работы: " + mas[i].getWorkExperience().getSpecialization());
            if(mas[i].getWorkExperience().getExperience() <= 4)
                System.out.println("Стаж: " + mas[i].getWorkExperience().getExperience() + " ãîä(à)");
            else
                System.out.println("Стаж: " + mas[i].getWorkExperience().getExperience() + " ëåò");
            System.out.println("---Желания по будующей работе---" );
            if(mas[i].getDemandsToWork().getMinSalary() == 0 && mas[i].getDemandsToWork().getSpecialization() == null && mas[i].getDemandsToWork().getConditions() == null)
                System.out.println("Предендет не имеет никаких желаний по будующей работе");
            else {
                if( mas[i].getDemandsToWork().getMinSalary() != 0)
                    System.out.println("Желаемая минимальная зарплата: " +  mas[i].getDemandsToWork().getMinSalary());
                else
                    System.out.println("Желаемая минимальная зарплата: Претендент не имеет пожеланий к этому пунку " );
                if(mas[i].getDemandsToWork().getSpecialization() != null)
                    System.out.println("Желаемая будующая работа: " + mas[i].getDemandsToWork().getSpecialization());
                else
                    System.out.println("Желаемая будующая работа: Претендент не имеет пожеланий к этому пунку");
                if(mas[i].getDemandsToWork().getConditions() != null)
                    System.out.println("Желаемые условия будующей работы: " + mas[i].getDemandsToWork().getConditions());
                else
                    System.out.println("Желаемые условия будующей работы: Претендент не имеет пожеланий к этому пунку");
            }
            System.out.println("---------------------");
        }
    }
}