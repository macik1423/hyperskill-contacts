package contacts;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public abstract class CompanyMember {
    private String phoneNumber;
    private LocalDateTime created;
    private LocalDateTime lastEdit;

    public CompanyMember(String phoneNumber, LocalDateTime created, LocalDateTime lastEdit) {
        this.phoneNumber = phoneNumber;
        this.created = created;
        this.lastEdit = lastEdit;
    }

    public abstract void getFieldsName();
    public abstract void changeValue(String field);
    public abstract String getMergedAllData();
    public abstract String getDescription();

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getLastEdit() {
        return lastEdit;
    }

    public void setLastEdit(LocalDateTime lastEdit) {
        this.lastEdit = lastEdit;
    }

    @Override
    public String toString() {
        return MessageFormat.format("Number: {0}\nTime created: {1}\nTime last edit: {2}",
                phoneNumber, created.truncatedTo(ChronoUnit.MINUTES), lastEdit.truncatedTo(ChronoUnit.MINUTES));
    }
}
