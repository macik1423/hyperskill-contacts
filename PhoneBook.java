package contacts;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneBook {
    public static List<CompanyMember> phoneBook = new ArrayList<>();
    final private static Scanner sc = new Scanner(System.in);

    public static void add(CompanyMember companyMember) {
        phoneBook.add(companyMember);
    }

    public static int countRecord() {
        return phoneBook.size();
    }

    public static String getList() {
        StringBuilder list = new StringBuilder();
        for(int i = 0; i < phoneBook.size(); i++) {
            list.append(MessageFormat.format("{0}. {1}", i + 1, phoneBook.get(i)));
            if (i != phoneBook.size() - 1) {
                list.append("\n");
            }
        }
        return list.toString();
    }
}
