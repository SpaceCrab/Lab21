package view;
import controller.Controller;

public class MainView {
    private Controller controller;
    CustomerView customerView;

    public MainView (Controller controller){
        this.controller = controller;
        customerView = new CustomerView(controller);
    }

    public int showMenu(){
        int choice = 0;

        Utilities.padChars('*', 40);
        System.out.println("Välj ett alternativ \n");
        System.out.println("1. Visa kundinformation");
        System.out.println("2. Visa konton");
        System.out.println("3. skapa konto");
        System.out.println("4. Ta bort konto");
        System.out.println("-1. Avsluta");

        choice = Utilities.getInteger(-1,4);

        return choice;
    }

    public int showLoginMenu(String[] persons){
        int choice = 0;

        Utilities.padChars('*', 40);
        System.out.println("Välj en användare \n");

        for (int i = 0; i < persons.length; i++) {
            System.out.println(i + ". " + persons[i]);
        }

        System.out.println("-1. Avsluta");

        choice = Utilities.getInteger(-1,persons.length-1);

        return choice;
    }
    public void displayCustomerInfo(String[] infoStrings){
        for (int i = 0; i < infoStrings.length; i++) {
           System.out.println(infoStrings[i]);
        }
    }

    public void readCustomerInfo(){
        customerView.readCustomerInfo();
    }

    public void showMessage(String message){
        System.out.println(message);
    }
}
