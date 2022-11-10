import javax.swing.*;

abstract public class Person {
    protected String name;
    protected String emailId;
    protected String password;
    protected String contactNumber;

    private Person() {
        // Do nothing
    }
    protected Person(String name, String emailId, String password, String contactNumber) {
        this.name = name;
        this.emailId = emailId;
        this.password = password;
        this.contactNumber = contactNumber;
    }

    abstract public JFrame dashboardScreen();

    static public JFrame loginScreen() {
        // Add code here
        return null;
    }

    static public JFrame registerScreen() {
        // Add code here
        return null;
    }


}
