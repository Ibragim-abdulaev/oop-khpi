package ua.khpi.oop.abdulaev05;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        Container container = new Container();

        container.add("Stroka 1");
        container.add("Stroka 2");
        container.add("Stroka 3");

        for (Iterator<String> it = container.iterator(); it.hasNext();) {
            String str = it.next();
            System.out.println(str);
        }

        container.remove("Stroka 2");

        System.out.println();

        for (Iterator<String> it = container.iterator(); it.hasNext();) {
            String str = it.next();
            System.out.println(str);
        }

        container.add("Stroka 4");

        System.out.println();

        for (Iterator<String> it = container.iterator(); it.hasNext();) {
            String str = it.next();
            System.out.println(str);
        }

        System.out.printf("\nContainer contains Stroka 4: %b\n", container.contains("Stroka 4"));
    }
}
