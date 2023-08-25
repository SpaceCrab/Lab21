package controller;

import model.CustomerManager;
import model.Customer;
import view.MainView;

public class Controller {
    private CustomerManager customerManager;
    private MainView mainView;
    private Customer currentCustomer;

    public Controller() {
        final int MAX_CUSTOMERS = 100;
        customerManager = new CustomerManager(MAX_CUSTOMERS);
        mainView = new MainView(this);

        showmenu();
    }

    private void showmenu() {
        int choice = 0;

        do {
            choice = mainView.showMenu();

            switch (choice)
            {
                case 1:
                    currentCustomer = new Customer();
                    mainView.readCustomerInfo();
                    addNewCustomer();
                    break;
                case 2:
                    mainView.showMessage("Visa kundinfo");
                    break;


                case 0:
                    mainView.showMessage("Välkommen åter!");
                    break;

                default:
                    mainView.showMessage("Felaktigt val, försök igen!");
                    break;
            }
        }while (choice != 0);

    }
    public void setCustomerPersonnr(String personnr){
        if(currentCustomer == null)
            currentCustomer = new Customer();

        currentCustomer.setPersonalNr(personnr);

    }

    public void setCustomerFirstName(String firstName){
        if(currentCustomer == null)
            currentCustomer = new Customer();

        currentCustomer.setFirstName(firstName);
    }

    public void setCustomerLastName(String lastName){
        if(currentCustomer == null)
            currentCustomer = new Customer();

        currentCustomer.setLastName(lastName);
    }

    public void addNewCustomer(){
        boolean ok = customerManager.addNew(currentCustomer);

        if (ok)
            mainView.showMessage("ny kund registrerad!");
        else
            mainView.showMessage("kunde inte registrera");
    }
}
