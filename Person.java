package contacts;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Person extends CompanyMember {

    private String name;
    private String surname;
    private String birth;
    private String gender;

    public Person(String name, String surname, String birth, String phoneNumber, String gender, LocalDateTime created, LocalDateTime lastEdit) {
        super(phoneNumber, created, lastEdit);
        this.name = name;
        this.surname = surname;
        this.birth = birth;
        this.gender = gender;
    }

    public static Person createPerson() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name:");
        String name = sc.nextLine();

        System.out.println("Enter the surname:");
        String surname = sc.nextLine();

        System.out.println("Enter the birth date:");
        String birth = sc.nextLine();
        Validator.isCorrectDate(birth);
        birth = !"".equals(birth) ? birth : "[no data]";

        System.out.println("Enter the gender (M, F):");
        String gender = sc.nextLine();
        Validator.isValidGender(gender);
        gender = !"".equals(gender) ? gender : "[no data]";

        System.out.println("Enter the number");
        String number = sc.nextLine();
        Validator.isCorrectNumber(number);
        number = !"".equals(number) ? number : "[no data]";

        LocalDateTime created = LocalDateTime.now();
        LocalDateTime lastEdit = LocalDateTime.now();
        return new Person(name, surname, birth, number, gender, created, lastEdit);
    }

    @Override
    public void getFieldsName() {
        System.out.println("Select a field (name, surname, birth, gender, number):");
    }

    @Override
    public void changeValue(String field) {
        Scanner sc = new Scanner(System.in);
        switch (field) {
            case "name":
                System.out.println("Enter the name:");
                String newName = sc.nextLine();
                this.setName(newName);
                break;
            case "surname":
                System.out.println("Enter the surname:");
                String newSurname = sc.nextLine();
                this.setSurname(newSurname);
                break;
            case "birth":
                System.out.println("Enter the birth date:");
                String birth = sc.nextLine();
                Validator.isCorrectDate(birth);
                this.setBirth(birth);
                break;
            case "gender":
                System.out.println("Enter the gender:");
                String gender = sc.nextLine();
                Validator.isValidGender(gender);
                this.setGender(gender);
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
        System.out.println("Saved");
    }

    @Override
    public String getMergedAllData() {
        return MessageFormat.format(
                "{0} {1} {2} {3} {4}",
                this.name, this.surname, this.gender, this.birth, this.getPhoneNumber());
    }

    @Override
    public String getDescription() {
        return MessageFormat.format(
                "Name: {0}\nSurname: {1}\nBirth date: {2}\nGender: {3}\n{4}",
                name, surname, birth, gender, super.toString());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return MessageFormat.format("{0} {1}", name, surname);
    }
}
