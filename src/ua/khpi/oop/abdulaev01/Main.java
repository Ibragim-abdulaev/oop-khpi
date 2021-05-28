
package ua.khpi.oop.abdulaev01;

public class Main {

    static void evenCount() {
        int recordBook = 0x43D0615; //71108117
        long phoneNumber = 380997557965L;
        int lastTwo = 0b1000001; //65
        int lastFour = 017435; //7965
        int numberJournal = ((1 - 1) % 26) + 1;

        int count = 0;
        while (recordBook > 0) {
            if ((recordBook % 10) % 2 == 0) count++;
            recordBook /= 10;
        }
        int count1 = 0;
        while (phoneNumber > 0) {
            if ((phoneNumber % 10) % 2 == 0) count1++;
            phoneNumber /= 10;
        }
        int count2 = 0;
        while (lastTwo > 0) {

            if ((lastTwo % 10) % 2 == 0) count2++;
            lastTwo /= 10;
        }
        int count3 = 0;
        while (lastFour > 0) {

            if ((lastFour % 10) % 2 == 0) count3++;
            lastFour /= 10;
        }
        int count4 = 0;
        while (numberJournal > 0) {
            if ((numberJournal % 10) % 2 == 0) count4++;
            numberJournal /= 10;
        }
    }

    static void oddCount() {
        int recordBook = 0x43D0615; //71108117
        long phoneNumber = 380997557965L;
        int lastTwo = 0b1000001; //65
        int lastFour = 017435; //7965
        int numberJournal = ((1 - 1) % 26) + 1;

        int count = 0;
        while (recordBook > 0) {
            if ((recordBook % 10) % 2 != 0) count++;
            recordBook /= 10;
        }
        int count1 = 0;
        while (phoneNumber > 0) {
            if ((phoneNumber % 10) % 2 != 0) count1++;
            phoneNumber /= 10;
        }
        int count2 = 0;
        while (lastTwo > 0) {
            if ((lastTwo % 10) % 2 != 0) count2++;
            lastTwo /= 10;
        }
        int count3 = 0;
        while (lastFour > 0) {
            if ((lastFour % 10) % 2 != 0) count3++;
            lastFour /= 10;
        }
        int count4 = 0;
        while (numberJournal > 0) {
            if ((numberJournal % 10) % 2 != 0) count4++;
            numberJournal /= 10;
        }
    }

    static void binaryOneCount() {
        int recordBook = 0x43D0615; //71108117
        long phoneNumber = 380997557965L;
        int lastTwo = 0b1000001; //65
        int lastFour = 017435; //7965
        int numberJournal = ((1 - 1) % 26) + 1;

        int count = 0;
        for (; recordBook > 0; count++) {
            recordBook &= recordBook - 1;
        }
        int count1 = 0;
        for (; phoneNumber > 0; count1++) {
            phoneNumber &= phoneNumber - 1;
        }
        int count2 = 0;
        for (; lastTwo > 0; count2++) {
            lastTwo &= lastTwo - 1;
        }
        int count3 = 0;
        for (; lastFour > 0; count3++) {
            lastFour &= lastFour - 1;
        }
        int count4 = 0;
        for (; numberJournal > 0; count4++) {
            numberJournal &= numberJournal - 1;
        }
    }

    public static void main(String[] args) {
        int recordBook = 0x43D0615; //71108117
        long phoneNumber = 380997557965L;
        int lastTwo = 0b1000001; //65
        int lastFour = 017435; //7965
        int numberJournal = ((1 - 1) % 26) + 1;
        char letterNumber = 'A'; //1 буква английского алфавита
        evenCount();
        oddCount();
        binaryOneCount();

    }

}

