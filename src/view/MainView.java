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
        System.out.println("1: Skapa en ny kund");
        System.out.println("2: Visa kundinfo");
        System.out.println("3: Skapa ett nytt konto");
        System.out.println("4: Visa kontoinfo");
        System.out.println("0: Lämna");

        choice = Utilities.getInteger(0,4);

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
