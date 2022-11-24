import gui.PersonGUI;

public class App {
    public static void main(String[] args) {
//        GUI.getInstance().setPanel(GUI.login());
        PersonGUI.getInstance().setPanel(PersonGUI.login());
//        while (true) {
//            try {
//                PersonGUI gui = PersonGUI.loginScreen();
//            } catch (Exception e) {
//                System.out.println(e);
//                break;
//            }
//        }
    }
}

