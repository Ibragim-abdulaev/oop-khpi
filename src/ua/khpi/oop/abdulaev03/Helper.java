package ua.khpi.oop.abdulaev03;

/**
 * Уилітарний клас Helper
 */
public class Helper {
    /**
     * Розбити рядки на три групи:
     * - починається з голосної;
     * - починається з приголосної;
     * - починається не з букви.
     * Знайти найкоротший рядок в кожній групі. Вивести цей рядок та його довжину.
     * @param text текст
     */
    public static void stringsInfo(String text) {
        String[] arr = split(text);
        final char[][] letterRange = {{65, 90}, {97, 122}};
        final char[] vowels = {65, 69, 73, 79, 85, 89, 97, 101, 105, 111, 117, 121};
        StringBuilder vowelGroup, consonantGroup, notLetterGroup;
        String[] minStrings = new String[3];
        /// [0] -> notLetter, [1] -> vowel, [2] -> consonant

        vowelGroup = new StringBuilder();
        consonantGroup = new StringBuilder();
        notLetterGroup = new StringBuilder();

        for (String str : arr) {
            if (str.isEmpty()) continue;

            char ch = str.charAt(0);
            boolean isLetter = false;
            boolean isVowel = false;

            for (char[] lr : letterRange) {
                if (ch >= lr[0] && ch <= lr[1]) {
                    isLetter = true;
                    break;
                }
            }

           if (!isLetter) {
               if (minStrings[0] == null || str.length() < minStrings[0].length())
                   minStrings[0] = str;

               notLetterGroup.append(str).append(" ");
               continue;
           }

           for (char v : vowels) {
               if (ch == v) {
                   isVowel = true;
                   break;
               }
           }

           if (isVowel) {
               if (minStrings[1] == null || str.length() < minStrings[1].length())
                   minStrings[1] = str;

               vowelGroup.append(str).append(" ");
           }
           else {
               if (minStrings[2] == null || str.length() < minStrings[2].length())
                   minStrings[2] = str;

               consonantGroup.append(str).append(" ");
           }
        }

        for (int i = 0; i < minStrings.length; i++)
            if (minStrings[i] == null)
                minStrings[i] = "";

        System.out.printf("1) Починається з голосної: -> \n\t %s\n", vowelGroup.toString());
        System.out.printf("Найкоротший рядок та його довжина -> \n\t['%s', %d]\n", minStrings[1], minStrings[1].length());

        System.out.printf("2) Починається з приголосної: -> \n\t %s\n", consonantGroup.toString());
        System.out.printf("Найкоротший рядок та його довжина -> \n\t['%s', %d]\n", minStrings[2], minStrings[2].length());

        System.out.printf("3) Починається не з букви: -> \n\t %s\n", notLetterGroup.toString());
        System.out.printf("Найкоротший рядок та його довжина -> \n\t['%s', %d]\n", minStrings[0], minStrings[0].length());
    }

    public static String[] split(String text) {
        String[] arr = new String[]{};
        StringBuilder word = new StringBuilder();
        int i, j;

        for (i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch != ' ') {
                word.append(ch);
            } else {
                String[] oldArr = arr;
                arr = new String[arr.length + 1];

                for (j = 0; j < oldArr.length; j++)
                    arr[j] = oldArr[j];

                arr[j] = word.toString();

                word.setLength(0);
            }
        }

        return arr;
    }
}
