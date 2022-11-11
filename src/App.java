import gui.PersonGUI;

public class App {
    public static void main(String[] args) {
        while (true) {
            try {
                PersonGUI gui = PersonGUI.loginScreen();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

