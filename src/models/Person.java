package models;

abstract public class Person {
    protected String name;
    protected String emailId;
    protected String password;
    protected String contactNumber;

    protected Person() {
        // Do Nothing
    }

    protected Person(String name, String emailId, String password, String contactNumber) {
        this.name = name;
        this.emailId = emailId;
        this.password = password;
        this.contactNumber = contactNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

}
