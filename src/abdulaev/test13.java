package abdulaev;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ua.khpi.oop.abdulaev07.Challanger;
import ua.khpi.oop.abdulaev07.DemandsToWork;
import ua.khpi.oop.abdulaev07.WorkExperience;
import ua.khpi.oop.abdulaev10.MyContainer;
import ua.khpi.oop.abdulaev13.MyThread;

class test13 {

    MyContainer<Challanger> container = new MyContainer<Challanger>();

    @Test
    void testCount() {
        int num = 0;
        addToContainer(num);
        int expected = num;
        MyThread Thread = new MyThread(container, "Thread: 0");
        int actual = Thread.count();
        Assertions.assertEquals(expected,actual);
    }

    void addToContainer(int num) {
        File file = new File("recruitingAgency11.txt");
        String education1 = null;
        int day1 = 0;
        int month1 = 0;
        int year1 = 0;
        String specializationPrevious1 = null;
        int experience1 = 0;
        String specializationNext1 = null;
        int minSalary1 = 0;
        String conditions1 = null;
        int id1 = 0;
        String education2 = null;
        int day2 = 0;
        int month2 = 0;
        int year2 = 0;
        String specializationPrevious2 = null;
        int experience2 = 0;
        String specializationNext2 = null;
        int minSalary2 = 0;
        String conditions2 = null;
        int id2 =0;
        try {
            Scanner reader = new Scanner(file);
            while(reader.hasNextLine()) {
                String data = reader.nextLine();
                String data1 = reader.nextLine();
                Pattern pattern = Pattern.compile("((\\w+(|\\s))*,\\s([1-9]|[12]\\d|3[01])\\.([1-9]|1[012])\\.((19|20)\\d{2}),\\s" +
                        "(\\w+.)+,\\s([0-9]|[1-6][0-9]),\\s(\\w+.)+,\\s([1-9]\\d{3,}),\\s(\\w+(\\.|\\s)(\\s|))+)");
                Matcher matcher = pattern.matcher(data);
                if(matcher.matches()) {
                    String[] information = data.split(",\\s");
                    education1 = information[0];
                    specializationPrevious1 = information[2];
                    experience1 = Integer.parseInt(information[3]);
                    specializationNext1 = information[4];
                    minSalary1 = Integer.parseInt(information[5]);
                    conditions1 = information[6];
                    String[] date1 = information[1].split("\\.");
                    day1 = Integer.parseInt(date1[0]);
                    month1 = Integer.parseInt(date1[1]);
                    year1 = Integer.parseInt(date1[2]);
                }
                Matcher matcher1 = pattern.matcher(data1);
                if(matcher1.matches()) {
                    String[] information1 = data1.split(",\\s");
                    education2 = information1[0];
                    specializationPrevious2 = information1[2];
                    experience2 = Integer.parseInt(information1[3]);
                    specializationNext2 = information1[4];
                    minSalary2 = Integer.parseInt(information1[5]);
                    conditions2 = information1[6];
                    String[] date2 = information1[1].split("\\.");
                    day2 = Integer.parseInt(date2[0]);
                    month2 = Integer.parseInt(date2[1]);
                    year2 = Integer.parseInt(date2[2]);
                }
            }
            reader.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        for(int i = 0; num > i; i++) {
            id1 = container.getSize();
            WorkExperience workExperienceAdd1 = new WorkExperience(specializationPrevious1, experience1);
            DemandsToWork demandsToWorkAdd1 = new DemandsToWork(specializationNext1,minSalary1,conditions1);
            Challanger challangerAdd1 = new Challanger(id1++,education1,day1,month1,year1,workExperienceAdd1,demandsToWorkAdd1);
            container.add(challangerAdd1);
            id2 = container.getSize();
            WorkExperience workExperienceAdd2 = new WorkExperience(specializationPrevious2, experience2);
            DemandsToWork demandsToWorkAdd2 = new DemandsToWork(specializationNext2,minSalary2,conditions2);
            Challanger challangerAdd2 = new Challanger(id2++,education2,day2,month2,year2,workExperienceAdd2,demandsToWorkAdd2);
            container.add(challangerAdd2);
        }
    }
}
