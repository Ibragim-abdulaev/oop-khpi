package ua.khpi.oop.abdulaev08;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

import ua.khpi.oop.abdulaev07.Challanger;
import ua.khpi.oop.abdulaev07.DemandsToWork;
import ua.khpi.oop.abdulaev07.WorkExperience;


public class Main {

    public static void main(String[] args) {
        RecruitingAgency list = new RecruitingAgency();
        int id = 1;
        WorkExperience workExperience = new WorkExperience("Кассир",4);
        DemandsToWork demandsToWork = new DemandsToWork("Менеджер по продажам",7800,"Наличие кофеварки на работе.");
        Challanger challanger = new Challanger(id++,"Среднее не полное",13,05,2020,workExperience,demandsToWork);
        list.add(challanger);

        workExperience = new WorkExperience("Учитель",14);
        demandsToWork = new DemandsToWork(null,0,null);
        challanger = new Challanger(id++,"Высшее образование",15,10,2014, workExperience,demandsToWork);

        list.add(challanger);

        workExperience = new WorkExperience("Бухгалтер",38);
        demandsToWork = new DemandsToWork("Бухгалтер",15000,"Оффис в цетре.");
        challanger = new Challanger(id++,"Высшее образование",14,03,2020, workExperience,demandsToWork);

        list.add(challanger);

        boolean endprog = false;
        boolean endChange = false;
        boolean endSerialization = false;
        boolean endDeserializtion = false;
        boolean folderDeserialization = true;
        boolean forlderSerialization = true;
        Scanner inInt = new Scanner(System.in);
        Scanner inStr = new Scanner(System.in);
        int menu;
        int menuChange;
        int changeExperience;
        int changeDemands;
        int menuSerialization;
        int menuDeserialization;

        while(!endprog)
        {
            System.out.println("1. Show all challanger");
            System.out.println("2. Add challanger");
            System.out.println("3. Delete chellanger");
            System.out.println("4. Change information");
            System.out.println("5. Clear list");
            System.out.println("6. Serialize data");
            System.out.println("7. Deserialize data");
            System.out.println("8. Exit");
            System.out.println("Enter option: \n");
            try
            {
                menu =  inInt.nextInt();
            }
            catch(java.util.InputMismatchException e)
            {
                System.out.println("Error! Ошибка ввода.");
                endprog = true;
                menu = 8;
            }

            switch(menu)
            {
                case 1:
                    list.printAll();
                    break;
                case 2:
                    System.out.println("Enter education of challanger: ");
                    String education = inStr.nextLine();
                    System.out.println("Enter day of dismissal: ");
                    int day = inInt.nextInt();
                    System.out.println("Enter month of dismissal: ");
                    int month = inInt.nextInt();
                    System.out.println("Enter year of dismissal: ");
                    int year = inInt.nextInt();
                    System.out.println("Enter pervious job: ");
                    String specializationPrevious = inStr.nextLine();
                    System.out.println("Enter experience of working: ");
                    int experience = inInt.nextInt();
                    System.out.println("Enter next job: ");
                    String specializationNext = inStr.nextLine();
                    System.out.println("Enter min salary: ");
                    int minSalary = inInt.nextInt();
                    System.out.println("Enter whishes to the next job: ");
                    String conditions = inStr.nextLine();

                    WorkExperience workExperienceAdd = new WorkExperience(specializationPrevious, experience);
                    DemandsToWork demandsToWorkAdd = new DemandsToWork(specializationNext,minSalary,conditions);
                    Challanger challangerAdd = new Challanger(id++,education,day,month,year,workExperienceAdd,demandsToWorkAdd);
                    list.add(challangerAdd);
                    break;
                case 3:
                    System.out.println("Enter ID to delete: ");
                    int delete = inInt.nextInt();
                    if(list.removeID(delete))
                        System.out.println("Challanger was deleted successfully.");
                    else
                        System.out.println("Error! Wrong ID.");
                    menu = 8;
                    break;
                case 4:
                    System.out.println("Enter ID to change information:");
                    int id1 = inInt.nextInt();
                    int position = 0;
                    for(; position < list.getSize(); position++)
                        if(list.mas[position].getRegistrationNum() == id1)
                            break;
                    if(position == list.getSize())
                    {
                        System.out.println("There is no challanger with that ID.");
                        break;
                    }
                    while (!endChange)
                    {
                        System.out.println("What do you want to change?");
                        System.out.println("1. Education");
                        System.out.println("2. Date of dismissal");
                        System.out.println("3. Work experience");
                        System.out.println("4. Demands to work");
                        System.out.println("5. Stop changing.");
                        menuChange = inInt.nextInt();
                        switch (menuChange)
                        {
                            case 1:
                                System.out.println("Enter new education: ");
                                list.mas[position].setEducation(inStr.nextLine());
                                break;
                            case 2:
                                System.out.println("Enter new day: ");
                                list.mas[position].setDismissalDay(inInt.nextInt());
                                System.out.println("Enter new day: ");
                                list.mas[position].setDismissalMonth(inInt.nextInt());
                                System.out.println("Enter new day: ");
                                list.mas[position].setDismissalYear(inInt.nextInt());
                                break;
                            case 3:
                                System.out.println("Information about work experience: ");
                                System.out.println("1. Specialization of previous job");
                                System.out.println("2. Experience (in years)");

                                changeExperience = inInt.nextInt();
                                switch(changeExperience) {
                                    case 1:
                                        System.out.println("Enter new previous specialization: ");
                                        list.mas[position].getWorkExperience().setSpecialization(inStr.nextLine());
                                        break;
                                    case 2:
                                        System.out.println("Enter new years of experience: ");
                                        list.mas[position].getWorkExperience().setExperience(inInt.nextInt());
                                        break;
                                    default:
                                        System.out.println("Error! Wrong num in menu.");
                                        break;
                                }
                                break;
                            case 4:
                                System.out.println("Information about demands to work: ");
                                System.out.println("1. Specialization of next job");
                                System.out.println("2. Min salary");
                                System.out.println("3. Conditions of work");

                                changeDemands = inInt.nextInt();
                                switch(changeDemands) {
                                    case 1:
                                        System.out.println("Enter new next specialization: ");
                                        list.mas[position].getDemandsToWork().setSpecialization(inStr.nextLine());
                                        break;
                                    case 2:
                                        System.out.println("Enter new min salary: ");
                                        list.mas[position].getDemandsToWork().setMinSalary(inInt.nextInt());
                                        break;
                                    case 3:
                                        System.out.println("Enter new conditions of work: ");
                                        list.mas[position].getDemandsToWork().setConditions(inStr.nextLine());
                                        break;
                                    default:
                                        System.out.println("Error! Wrong num in menu.");
                                        break;
                                }
                                break;
                            case 5:
                                endChange = true;
                                break;
                            default:
                                System.out.println("Error! Wrong num in menu.");
                                break;
                        }
                    }
                    break;
                case 5:
                    list.clear();
                    System.out.println("List was cleared.");
                    break;
                case 6:
                    String absolutePath = new File("").getAbsolutePath();
                    File folder = new File(absolutePath);
                    File[] listFiles = folder.listFiles();
                    String filename;
                    String currentDir = absolutePath;
                    String highestDir = folder.getName();

                    boolean leave = false;
                    position = 0;
                    System.out.print("Enter XML filename: ");
                    filename = inStr.nextLine();
                    if (filename.indexOf(".xml") == -1)
                        filename += ".xml";
                    while(!endSerialization)
                    {
                        position = 0;
                        System.out.println("\nCurrent path: " + currentDir);
                        System.out.println("XML file name: " + filename);
                        System.out.println("\nFiles and directories in this path:");
                        for (position = 0; position < listFiles.length; position++)
                            System.out.println(position + 1 + ". " + listFiles[position].toString().substring(currentDir.length()+1));
                        System.out.println();
                        System.out.println("Serialization menu: ");
                        System.out.println("1. Write XML file in current directory");
                        System.out.println("2. Go up one level folder");
                        System.out.println("3. Enter the folder");
                        System.out.println("4. End of serialization");
                        System.out.print("Enter option:");
                        menuSerialization = inInt.nextInt();
                        System.out.println();
                        switch(menuSerialization)
                        {
                            case 1:
                                endSerialization = true;
                                break;
                            case 2:
                                if(folder.getName().equals(highestDir))
                                {
                                    System.out.print("This is the highest directory.");
                                    break;
                                }
                                currentDir = currentDir.substring(0, currentDir.indexOf(folder.getName())-1);
                                folder = new File(currentDir);
                                listFiles = folder.listFiles();
                                break;
                            case 3:
                                while(forlderSerialization)
                                {
                                    System.out.print("Choose the number of folder:");
                                    position = inInt.nextInt();
                                    if(!listFiles[position-1].isDirectory() || position < 1 || position > listFiles.length)
                                        System.out.println("Error. That is not a folder.");
                                    else
                                    {
                                        currentDir = listFiles[position-1].toString();
                                        System.out.println("New current directory:" + currentDir);
                                        folder = new File(currentDir);
                                        listFiles = folder.listFiles();
                                        forlderSerialization = false;
                                    }
                                }
                                break;
                            case 4:
                                System.out.println("End of serialization");
                                leave = true;
                                endSerialization = true;
                                break;
                            default:
                                System.out.println("Error! Wrong num in menu.");
                                break;
                        }
                    }
                    if(leave == true)
                        break;
                    absolutePath = currentDir;
                    folder = new File(absolutePath);
                    File file = new File(folder,filename);
                    try {
                        XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(file)));
                        encoder.writeObject(list.mas);
                        encoder.close();
                    }
                    catch (Exception e) {
                        System.out.println(e);
                        break;
                    }
                    System.out.println("File was written in this directory: " + absolutePath);
                    System.out.println("Serialization was completed.");
                    break;
                case 7:
                    absolutePath = new File("").getAbsolutePath();
                    folder = new File(absolutePath);
                    listFiles = folder.listFiles();
                    currentDir = absolutePath;
                    highestDir = folder.getName();
                    leave = false;
                    position = 0;

                    while(!endDeserializtion)
                    {
                        position = 0;
                        System.out.println("Current path: " + currentDir);
                        System.out.println("Files and directories in this path:");
                        for (position = 0; position < listFiles.length; position++) {
                            System.out.println(position + 1 + ". " + listFiles[position].toString().substring(currentDir.length()+1));
                        }
                        System.out.println();
                        System.out.println("Deserialization menu:");
                        System.out.println("1. Read XML file in current directory");
                        System.out.println("2. Go up one level folder");
                        System.out.println("3. Enter the folder");
                        System.out.println("4. End of deserialization");
                        System.out.print("Enter option:");
                        menuDeserialization = inInt.nextInt();
                        System.out.println();
                        switch(menuDeserialization)
                        {
                            case 1:
                                System.out.print("Enter ID of the file:");
                                position = inInt.nextInt();
                                if(listFiles[position-1].getName().indexOf(".xml") == -1 || listFiles[position-1].isDirectory())
                                {
                                    System.out.println("Error, that's not a .XML file.");
                                    break;
                                }
                                endDeserializtion = true;
                                break;
                            case 2:
                                if(folder.getName().equals(highestDir))
                                {
                                    System.out.println("This is the highest directory.");
                                    break;
                                }
                                currentDir = currentDir.substring(0, currentDir.indexOf(folder.getName())-1);
                                folder = new File(currentDir);
                                listFiles = folder.listFiles();
                                break;
                            case 3:
                                while(folderDeserialization)
                                {
                                    System.out.print("Choose the number of folder:");
                                    position = inInt.nextInt();
                                    if(!listFiles[position-1].isDirectory() || position < 1 || position > listFiles.length)
                                        System.out.println("Error, that's not a folder.");
                                    else
                                    {
                                        currentDir = listFiles[position-1].toString();
                                        System.out.println("New current directory: " + currentDir);
                                        folder = new File(currentDir);
                                        listFiles = folder.listFiles();
                                        folderDeserialization = false;
                                    }
                                }
                                break;
                            case 4:
                                System.out.println("End of deserialization");
                                leave = true;
                                endDeserializtion = true;
                                break;
                            default:
                                System.out.println("Error! Wrong num in menu.");
                                break;
                        }
                    }
                    if(leave == true)
                        break;
                    absolutePath = currentDir + "\\" + listFiles[position-1].getName();
                    file = new File(absolutePath);
                    try
                    {
                        XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(file)));
                        list.mas = (Challanger[])decoder.readObject();
                        decoder.close();
                        list.setSize(list.mas.length);
                    }
                    catch (Exception e)
                    {
                        System.out.println(e);
                        break;
                    }
                    System.out.println("File was read from this directory: " + listFiles[position-1]);
                    System.out.println("Deserialization was completed.");
                    break;
                case 8:
                    endprog = true;
                    inInt.close();
                    inStr.close();
                    break;
                default:
                    System.out.println("Error! Wrong num in menu.");
                    break;
            }
        }
    }
}
