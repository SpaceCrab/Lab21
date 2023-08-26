package view;
import controller.Controller;

public class MainView {
    private Controller controller;
    CustomerView customerView;

    public MainView (Controller controller){
        this.controller = controller;
        customerView = new CustomerView(controller);
    }

    public int showMainMenu(){
        int choice = 0;

        Utilities.padChars('*', 40);
        System.out.println("Välj ett alternativ \n");
        System.out.println("1. Visa kundinformation");
        System.out.println("2. Visa användarens konton");
        System.out.println("3. skapa konto");
        System.out.println("4. Ta bort konto");
        System.out.println("5. visa alla konton");
        System.out.println("-1. Avsluta");

        choice = Utilities.getInteger(-1,5);

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

    public int showAccountCreationMenu(){
        int choice = 0;

        Utilities.padChars('*', 40);
        System.out.println("Välj ett konto att skapa \n");
        System.out.println("1. Sparkonto");
        System.out.println("2. Lönekonto");
        System.out.println("3. Kreditkonto");
        System.out.println("4. Pensionsskonto");
        System.out.println("5. Organisationskonto");
        System.out.println("-1. Avsluta");

        choice = Utilities.getInteger(-1,5);

        return choice;
    }

    public void displayCustomerInfo(String[] customerInfo){
        Utilities.padChars('*', 40);
        System.out.println("Kundinformation \n");
        Utilities.printArray(customerInfo);
    }

    public void displayAccountInfo(String[] accountInfo){
        Utilities.padChars('*', 40);
        System.out.println("Kontoinformation \n");
        Utilities.printArray(accountInfo);
    }

    public int showAccountDeletionMenu(String[] accountInfo){
        Utilities.padChars('*', 40);
        System.out.println("Kontoinformation \n");
        Utilities.printNumberedArray(accountInfo);
        System.out.println("Välj ett konto att ta bort eller -1 för att avsluta \n");
        int choice = Utilities.getInteger(-1,accountInfo.length-1);
        return choice;
    }

    public String getInformation(String message){
        showMessage(message);
        return Utilities.getString();
    }

    public void showMessage(String message){
        System.out.println(message);
    }
}
