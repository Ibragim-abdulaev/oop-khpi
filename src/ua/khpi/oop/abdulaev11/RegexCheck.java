package ua.khpi.oop.abdulaev11;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexCheck {
    public static boolean intRegexCheck(int value, Pattern pattern)
    {
        Matcher matcher;
        matcher = pattern.matcher(Integer.toString(value));
        if(!matcher.matches())
        {
            return false;
        }
        return true;
    }

    public static boolean stringRegexCheck(String value, Pattern pattern)
    {
        Matcher matcher;
        matcher = pattern.matcher(value);
        if(!matcher.matches())
        {
            return false;
        }
        return true;
    }
}