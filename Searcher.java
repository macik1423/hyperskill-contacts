package contacts;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

enum SearchOption {
    number("[number]"), back("back"), again("again");

    private final String name;

    SearchOption(String name) {
        this.name = name;
    }

    public static void getOptions() {
        StringBuilder options = new StringBuilder();
        options.append("[search] Enter action (");
        for (SearchOption option : SearchOption.values()) {
            options.append(option.name);
            options.append(", ");
        }
        String sub = options.substring(0, options.length() - 2);
        sub = sub + "):";
        System.out.println(sub);
    }
}

public class Searcher {
    final static Scanner sc = new Scanner(System.in);

    public static void search() {
        System.out.println("Enter search query: ");
        String wordToFind = sc.nextLine();
        Pattern pattern = Pattern.compile(wordToFind, Pattern.CASE_INSENSITIVE);
        List<CompanyMember> filterCompanyMembers = new ArrayList<>();
        for (CompanyMember companyMember : PhoneBook.phoneBook) {
            Matcher matcher = pattern.matcher(companyMember.getMergedAllData());
            if (matcher.find()) {
                filterCompanyMembers.add(companyMember);
            }
        }
        System.out.println("Found " + filterCompanyMembers.size() + " results:");
        for (int i = 0; i < filterCompanyMembers.size(); i++) {
            System.out.println(MessageFormat.format("{0}. {1}", i + 1, filterCompanyMembers.get(i)));
        }
        SearchOption.getOptions();
        String option = sc.nextLine();
        switch (option) {
            case "again":
                Searcher.search();
                break;
            case "back":
                Menu.getOption();
                break;
            default:
                int index = Integer.parseInt(option) - 1;
                CompanyMember companyMember = filterCompanyMembers.get(index);
                System.out.println(companyMember.getDescription());
                Record.getRecord(companyMember);
                break;
        }

    }
}
