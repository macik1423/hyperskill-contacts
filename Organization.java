package contacts;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Organization extends CompanyMember {

    private String name;
    private String address;

    public Organization(String phoneNumber, String name, String address, LocalDateTime created, LocalDateTime lastEdit) {
        super(phoneNumber, created, lastEdit);
        this.name = name;
        this.address = address;
    }

    public static CompanyMember createOrganization() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the organization name:");
        String name = sc.nextLine();
        System.out.println("Enter the address:");
        String address = sc.nextLine();
        System.out.println("Enter the number");
        String number = sc.nextLine();

        Validator.isCorrectNumber(number);
        number = !"".equals(number) ? number : "[no data]";

        LocalDateTime created = LocalDateTime.now();
        LocalDateTime lastEdit = LocalDateTime.now();
        return new Organization(number, name, address, created, lastEdit);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public void getFieldsName() {
        System.out.println("Select a field (name, address, number):");
    }

    @Override
    public void changeValue(String field) {
        Scanner sc = new Scanner(System.in);
        switch (field) {
            case "name":
                System.out.println("Enter the organization name:");
                String newName = sc.nextLine();
                this.setName(newName);
                break;
            case "address":
                System.out.println("Enter the address:");
                String newSurname = sc.nextLine();
                this.setAddress(newSurname);
                break;
            case "number":
                System.out.println("Enter the number:");
                String newNumber = sc.nextLine();
                Validator.isCorrectNumber(newNumber);
                newNumber = newNumber != null ? newNumber : "[no number]";
                this.setPhoneNumber(newNumber);
                break;
        }
        this.setLastEdit(LocalDateTime.now());
    }

    @Override
    public String getMergedAllData() {
        return MessageFormat.format("{0} {1} {2}", this.name, this.address, this.getPhoneNumber());
    }

    @Override
    public String getDescription() {
        return MessageFormat.format(
                "Organization name: {0}\nAddress: {1}\n{2}",
                name, address, super.toString());
    }

    @Override
    public String toString() {
        return MessageFormat.format("{0}", name);
    }
}
