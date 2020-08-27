package contacts;

import java.util.Scanner;

enum ListOption {
    number("[number]"), back("back");

    private final String name;

    ListOption(String name) {
        this.name = name;
    }

    public static void getOptions() {
        StringBuilder options = new StringBuilder();
        options.append("[list] Enter action (");
        for (ListOption option : ListOption.values()) {
            options.append(option.name);
            options.append(", ");
        }
        String sub = options.substring(0, options.length() - 2);
        sub = sub + "):";
        System.out.println(sub);
    }
}

public class List {
    final static Scanner sc = new Scanner(System.in);
    public static void getList() {
        System.out.println(PhoneBook.getList());
        System.out.println();
        ListOption.getOptions();
        String option = sc.nextLine();
        if ("back".equals(option)) {
            Menu.getOption();
        } else {
            int index = Integer.parseInt(option) - 1;
            CompanyMember companyMember = PhoneBook.phoneBook.get(index);
            System.out.println(companyMember.getDescription());
            System.out.println();
            Record.getRecord(companyMember);
        }
    }
}
