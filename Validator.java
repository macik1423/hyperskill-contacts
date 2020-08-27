package contacts;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static void isCorrectNumber(String number) {
        Pattern pattern = Pattern.compile("^(\\+?\\(?[0-9A-Za-z]+\\)?)$|((\\+?[0-9A-Za-z]+)?([ -]?\\([0-9A-Za-z]{2,}\\))?([ -][0-9A-Za-z]{2,})*)");
        Matcher matcher = pattern.matcher(number);
        if (matcher.matches()) {
        } else {
            System.out.println("Wrong number format!");
            number = "[no number]";
        }
    }

    public static void isCorrectDate(String date) {
        if (date == null || "".equals(date)) {
            System.out.println("Bad birth date!");
        }
    }

    public static void isValidGender(String gender) {
        if (gender.equals("M") || gender.equals("F")) {

        } else {
            System.out.println("Bad gender!");
        }
    }
}
