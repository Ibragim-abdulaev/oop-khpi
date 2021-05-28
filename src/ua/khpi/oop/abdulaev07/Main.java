package ua.khpi.oop.abdulaev07;

public class Main {

    public static void main(String[] args) {
        RecruitingAgency list = new RecruitingAgency();
        WorkExperience workExperience1 = new WorkExperience("Êàññèð",4);
        DemandsToWork demandsToWork1 = new DemandsToWork("Ìåíåäæåð ïî ïðîäàæàì",7800,"Íàëè÷èå êîôåâàðêè íà ðàáîòå.");
        list.mas[0] = new Challanger(39821,"Ñðåäíåå íå ïîëíîå",13,05,2020,workExperience1,demandsToWork1);
        workExperience1 = new WorkExperience("Ó÷èòåëü",14);
        demandsToWork1 = new DemandsToWork(null,0,null);
        list.mas[1] = new Challanger(15301,"Âûñøåå îáðàçîâàíèå",15,10,2014, workExperience1,demandsToWork1);
        workExperience1 = new WorkExperience("Áóõãàëòåð",38);
        demandsToWork1 = new DemandsToWork("Áóõãàëòåð",15000,"Îôôèñ â öåòðå.");
        list.mas[2] = new Challanger(3004,"Âûñøåå îáðàçîâàíèå",14,03,2020, workExperience1,demandsToWork1);
        list.printAll();
        list.mas[2].getDemandsToWork().setConditions("Ðÿäîì ñ ìåòðî.");
        list.mas[1].getDemandsToWork().setMinSalary(9300);
        list.printAll();
    }

}