package ua.khpi.oop.abdulaev08;

import ua.khpi.oop.abdulaev07.Challanger;
public class RecruitingAgency {
    private int size = 0;
    Challanger[] mas = new Challanger[size];

    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }

    public void add(Challanger challanger) {
        Challanger[] newmas = new Challanger[size+1];
        for(int i = 0; i < size; i++)
            newmas[i] = mas[i];
        size++;
        newmas[size-1] = challanger;
        mas = newmas;
    }

    public boolean remove(int num) {
        if(num > 0 || num < size) {
            Challanger[] newmas = new Challanger[size-1];
            for (int i = 0; i < num; i++)
                newmas[i] = mas[i];
            for (int i = num, j = num + 1; j < size; i++, j++)
                newmas[i] = mas[j];
            size--;
            mas = newmas;
            return true;
        }
        return false;
    }
    public boolean removeID(int ID) {
        int num = -1;
        for(int i = 0; i < size; i++ ) {
            if(mas[i].getRegistrationNum() == ID) {
                num = i;
                break;
            }
        }
        if(num != -1)
            return remove(num);
        else
            return false;
    }

    public void clear() {
        size = 0;
        Challanger[] newmas = new Challanger[size];
        mas = newmas;
    }

    public void printID(int ID) {
        int num = -1;
        for(int i = 0; i < size; i++ ) {
            if(mas[i].getRegistrationNum() == ID) {
                num = i;
                break;
            }
        }
        if(num != -1)
            print(num+1);
        else
            System.out.println("Указан неверный ID.");
    }
    public void print(int num) {
        if(num > 0 || num < size) {
            System.out.println("ID: " + mas[num-1].getRegistrationNum());
            System.out.println("Образование: " + mas[num-1].getEducation());
            System.out.println("Дата увольнения: " + mas[num-1].getDismissalDay()+"/"+mas[num-1].getDismissalMonth()+"/"+mas[num-1].getDismissalYear());
            System.out.println("---Опыт работы---");
            System.out.println("Место предыдущей работы: " + mas[num-1].getWorkExperience().getSpecialization());
            if(mas[num-1].getWorkExperience().getExperience() <= 4)
                System.out.println("Стаж: " + mas[num-1].getWorkExperience().getExperience() + " год(а)");
            else
                System.out.println("Стаж: " + mas[num-1].getWorkExperience().getExperience() + " лет");
            System.out.println("---Желания по будующей работе---" );
            if(mas[num-1].getDemandsToWork().getMinSalary() == 0 && mas[num-1].getDemandsToWork().getSpecialization() == null && mas[num-1].getDemandsToWork().getConditions() == null)
                System.out.println("Предендет не имеет никаких желаний по будующей работе");
            else {
                if( mas[num-1].getDemandsToWork().getMinSalary() != 0)
                    System.out.println("Желаемая минимальная зарплата: " +  mas[num-1].getDemandsToWork().getMinSalary());
                else
                    System.out.println("Желаемая минимальная зарплата: Претендент не имеет пожеланий к этому пунку " );
                if(mas[num-1].getDemandsToWork().getSpecialization() != null)
                    System.out.println("Желаемая будующая работа: " + mas[num-1].getDemandsToWork().getSpecialization());
                else
                    System.out.println("Желаемая будующая работа: Претендент не имеет пожеланий к этому пунку");
                if(mas[num-1].getDemandsToWork().getConditions() != null)
                    System.out.println("Желаемые условия будующей работы: " + mas[num-1].getDemandsToWork().getConditions());
                else
                    System.out.println("Желаемые условия будующей работы: Претендент не имеет пожеланий к этому пунку");
            }
            System.out.println("------------------------------------------");
        }
        else
            System.out.println("Указан невеный елемент.");
    }
    /**
     * Метод вывода массива данных
     */
    public void printAll() {
        if(size > 0) {
            for(int i = 0 ; i < size; i++) {
                System.out.println("ID: " + mas[i].getRegistrationNum());
                System.out.println("Образование: " + mas[i].getEducation());
                System.out.println("Дата увольнения: " + mas[i].getDismissalDay()+"/"+mas[i].getDismissalMonth()+"/"+mas[i].getDismissalYear());
                System.out.println("---Опыт работы---");
                System.out.println("Место предыдущей работы: " + mas[i].getWorkExperience().getSpecialization());
                if(mas[i].getWorkExperience().getExperience() <= 4)
                    System.out.println("Стаж: " + mas[i].getWorkExperience().getExperience() + " год(а)");
                else
                    System.out.println("Стаж: " + mas[i].getWorkExperience().getExperience() + " лет");
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
                System.out.println("------------------------------------------");
            }
        }
        else
            System.out.println("Претендентов на роботу нету.");
    }
}

