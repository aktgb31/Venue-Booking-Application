package models;

import javax.swing.*;

abstract public class Person {
    protected String name;
    protected String emailId;
    protected String password;
    protected String contactNumber;

    public Person() {
        // Do nothing
    }
    protected Person(String name, String emailId, String password, String contactNumber) {
        this.name = name;
        this.emailId = emailId;
        this.password = password;
        this.contactNumber = contactNumber;
    }
}
