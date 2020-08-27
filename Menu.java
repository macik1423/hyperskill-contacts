package contacts;

import java.text.MessageFormat;
import java.util.Scanner;

enum MenuOption {
    add("add"), list("list"), search("search"), count("count"), exit("exit");

    private final String name;

    MenuOption(String name) {
        this.name = name;
    }

    public static void getOptions() {
        StringBuilder options = new StringBuilder();
        options.append("[menu] Enter action (");
        for (MenuOption option : MenuOption.values()) {
            options.append(option.name);
            options.append(", ");
        }
        String sub = options.substring(0, options.length() - 2);
        sub = sub + "):";
        System.out.println(sub);
    }
}

public class Menu {
    final static Scanner sc = new Scanner(System.in);

    public static void getOption() {
        while (true) {
            MenuOption.getOptions();
            try {
                MenuOption menuOption = MenuOption.valueOf(sc.nextLine());
                switch (menuOption) {
                    case add:
                        getAddOption();
                        break;
                    case list:
                        List.getList();
                        break;
                    case search:
                        Searcher.search();
                        break;
                    case count:
                        getCountOption();
                        break;
                    case exit:
                        System.exit(0);
                    default:
                        System.out.println("bad option");
                        break;
                }
                System.out.println();
            } catch (IllegalArgumentException e) {
                System.out.println("bad option");
            }
        }
    }

    private static void getCountOption() {
        String message = MessageFormat.format("The Phone Book has {0} records.",  PhoneBook.countRecord());
        System.out.println(message);
    }

    private static void getAddOption() {
        System.out.println("Enter the type (person, organization):");
        String option = sc.nextLine();
        CompanyMember companyMember = null;
        switch (option) {
            case "person":
                companyMember = Person.createPerson();
                break;
            case "organization":
                companyMember = Organization.createOrganization();
                break;
        }
        PhoneBook.add(companyMember);
        System.out.println("The record added.");
    }
}
