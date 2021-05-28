package abdulaev;

import static org.junit.jupiter.api.Assertions.*;

import java.util.regex.Pattern;
import ua.khpi.oop.abdulaev11.RegexCheck;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class test11 {

    public static int[][] getData() {
        return new int[][] { {32, 13, 1832, 0}, {0, -10, 2134, 0}, {-4, 11, 2012, 0}, {5, 3, 2018, 1}};
    }

    @ParameterizedTest
    @MethodSource(value = "getData")
    void testIntRegexCheck(int[] data) {
        boolean check = true;
        boolean temp;
        Pattern patternDay = Pattern.compile("([1-9]|[12]\\d|3[01])");
        Pattern patternMonth = Pattern.compile("([1-9]|1[012])");
        Pattern patternYear = Pattern.compile("(19|20)\\d{2}");
        int day = data[0];
        int month = data[1];
        int year = data[2];
        boolean expected = intToBoolean(data[3]);
        temp = RegexCheck.intRegexCheck(day, patternDay);
        check = check & temp;
        temp = RegexCheck.intRegexCheck(month, patternMonth);
        check = check & temp;
        temp = RegexCheck.intRegexCheck(year, patternYear);
        check = check & temp;
        assertEquals(expected, check, "Have to be the same");
    }

    @Test
    void testStringRegexCheck() {
        boolean expected1 = true;
        boolean expected2 = false;
        Pattern patternConditions = Pattern.compile("(\\w+(\\.|\\s)(\\s|))+");
        String str_true = "Posibility to dose not have buisness trip. Paid vocations. Free dinner.";
        String str_false = " Paid vocations. Free coffie.  Posibility to have a nap ";
        boolean actual1 = RegexCheck.stringRegexCheck(str_true, patternConditions);
        boolean actual2 = RegexCheck.stringRegexCheck(str_false, patternConditions);
        assertEquals(expected1, actual1, "Have to be the same");
        assertEquals(expected2, actual2, "Havr to be the same");
    }

    private boolean intToBoolean(int input) {
        if(input == 0) {
            return false;
        }
        else if(input == 1) {
            return true;
        }
        else {
            throw new IllegalArgumentException("Входное значение может быть равно только 0 или 1 !");
        }
    }
}
