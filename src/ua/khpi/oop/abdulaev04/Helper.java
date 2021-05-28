package ua.khpi.oop.abdulaev04;

/**
 * Уилітарний клас Helper
 */
public class Helper {
    public static boolean DEBUG = false;

    /**
     * Розбити рядки на три групи:
     * - починається з голосної;
     * - починається з приголосної;
     * - починається не з букви.
     * Знайти найкоротший рядок в кожній групі. Вивести цей рядок та йогої довжину.
     * @param arr масив рядків
     */
    public static String stringsInfo(String[] arr) {
        final char[][] letterRange = {{65, 90}, {97, 122}};
        final char[] vowels = {65, 69, 73, 79, 85, 89, 97, 101, 105, 111, 117, 121};
        StringBuilder vowelGroup, consonantGroup, notLetterGroup, output;
        String[] minStrings = new String[3];
        /// [0] -> notLetter, [1] -> vowel, [2] -> consonant

        vowelGroup = new StringBuilder();
        consonantGroup = new StringBuilder();
        notLetterGroup = new StringBuilder();
        output = new StringBuilder();

        for (String str : arr) {
            if (str.isEmpty()) continue;

            char ch = str.charAt(0);
            boolean isLetter = false;
            boolean isVowel = false;

            if (DEBUG) System.out.printf("[%s, %c]\n", str, ch);

            for (char[] lr : letterRange) {
                if (ch >= lr[0] && ch <= lr[1]) {
                    isLetter = true;
                    break;
                }
            }

            if (!isLetter) {
                if (minStrings[0] == null || str.length() < minStrings[0].length())
                    minStrings[0] = str;

                if (DEBUG) System.out.printf("isLetter -> %b\n", false);

                notLetterGroup.append(str).append(" ");
                continue;
            }

            if (DEBUG) System.out.printf("isLetter -> %b\n", true);

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

            System.out.printf("isVowel -> %b\n", isVowel);
            System.out.printf("isConsonant -> %b\n", !isVowel);

            if (DEBUG) {
                System.out.println("Groups ->");
                System.out.printf("\tVowel: '%s'\n", vowelGroup.toString());
                System.out.printf("\tConsonant: '%s'\n", consonantGroup.toString());
                System.out.printf("\tNotLetter: '%s'\n", notLetterGroup.toString());
            }
        }

        for (int i = 0; i < minStrings.length; i++)
            if (minStrings[i] == null)
                minStrings[i] = "";

        output
            .append(String.format("1) Починається з голосної: -> \n\t %s\n", vowelGroup.toString()))
            .append(String.format("Найкоротший рядок та його довжина -> \n\t['%s', %d]\n", minStrings[1], minStrings[1].length()))
            .append(String.format("2) Починається з приголосної: -> \n\t %s\n", consonantGroup.toString()))
            .append(String.format("Найкоротший рядок та його довжина -> \n\t['%s', %d]\n", minStrings[2], minStrings[2].length()))
            .append(String.format("3) Починається не з букви: -> \n\t %sa\n", notLetterGroup.toString()))
            .append(String.format("Найкоротший рядок та його довжина -> \n\t['%s', %d]\n", minStrings[0], minStrings[0].length()));

        return output.toString();
    }
}
