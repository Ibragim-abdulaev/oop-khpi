package ua.khpi.oop.abdulaev04;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static boolean exitFlag = false;

    /**
     * Очікування клавіші Enter
     */
    public static void waitForEnter() {
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Очищення вікна консолі
     */
    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Обробка аргументів командного рядка
     * @param args масив аргументів командного рядка
     */
    public static void commandArguments(String[] args) {
        for (String arg : args) {
            switch (arg) {
                case "-debug":
                case "-d":
                    Helper.DEBUG = true;
                    break;
                case "-help":
                case "-h":
                    exitFlag = true;
                    System.out.println(
                            "Аргументи командного рядка: \n"
                                    + "\t-d[-debug] діагностичні повідомлення, проміжні значення змінних\n"
                                    + "\t-h[-help] інформація про автора програми, призначення, опис режимів роботи\n"
                                    + "Програмне меню:\n"
                                    + "\t0 - Вихід\n"
                                    + "\t1 - Введення даних\n"
                                    + "\t2 - Перегляд даних\n"
                                    + "\t3 - Виконання обчислень\n"
                                    + "\t4 - Відображення результату\n"
                                    + "Автор:\n"
                                    + "\tАбдулаєв Ібрагім студент гр. КІТ-119в\n"
                    );
                    break;
            }
        }
    }

    /**
     * Циклічне відображення програмного меню
     */
    public static void appMenu() {
        Scanner input = new Scanner(System.in);
        int option = 0;
        int inputLength = 0;
        String inputData = null;
        String inputReplacer = null;
        String outputData = null;

        while (true) {
            clearConsole();
            System.out.println(
                    "\t0 - Вихід\n"
                            + "\t1 - Введення даних\n"
                            + "\t2 - Перегляд даних\n"
                            + "\t3 - Виконання обчислень\n"
                            + "\t4 - Відображення результату"
            );

            option = input.nextInt();

            switch (option) {
                case 0:
                    return;
                case 1:
                    input.nextLine();
                    System.out.println("Введіть текст для обробки:");
                    inputData = input.nextLine();
                    input.nextLine();
                    break;
                case 2:
                    if (inputData != null && !inputData.isEmpty())
                        System.out.printf("Дані: %s\n", inputData);
                    else
                        System.out.println("Введено невірні значення. Перевірте вхідні дані");
                    waitForEnter();
                    break;
                case 3:
                    if (inputData != null && !inputData.isEmpty())
                        outputData = Helper.stringsInfo(inputData.split(" "));
                    else
                        System.out.println("Введено невірні значення. Перевірте вхідні дані");
                    waitForEnter();
                    break;
                case 4:
                    if (outputData != null)
                        System.out.println(outputData);
                    else
                        System.out.println("Обчислення не виконувались");
                    waitForEnter();
                    break;
            }
        }
    }

    public static void main(String[] args) {
        commandArguments(args);

        if (exitFlag) return;

        appMenu();
    }
}