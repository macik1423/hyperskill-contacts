package contacts;

import java.util.Scanner;

enum RecordOption {
    edit("edit"), delete("delete"), menu("menu");

    private final String name;

    RecordOption(String name) {
        this.name = name;
    }

    public static void getOptions() {
        StringBuilder options = new StringBuilder();
        options.append("[record] Enter action (");
        for (RecordOption option : RecordOption.values()) {
            options.append(option.name);
            options.append(", ");
        }
        String sub = options.substring(0, options.length() - 2);
        sub = sub + "):";
        System.out.println(sub);
    }
}

public class Record {
    final static Scanner sc = new Scanner(System.in);
    public static void getRecord(CompanyMember record) {
        RecordOption.getOptions();
        RecordOption recordOption = RecordOption.valueOf(sc.nextLine());
        switch (recordOption) {
            case menu:
                Menu.getOption();
                break;
            case edit:
                record.getFieldsName();
                String field = sc.nextLine();
                record.changeValue(field);
                System.out.println(record.getDescription());
                System.out.println();
                Record.getRecord(record);
                break;
            case delete:
                break;
        }
    }


}
