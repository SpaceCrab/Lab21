package controller;

import model.CustomerManager;
import model.Customer;
import model.Person;
import view.MainView;

public class Controller {
    private CustomerManager customerManager;
    private MainView mainView;
    private Customer currentCustomer;


    public Controller() {
        final int MAX_CUSTOMERS = 100;
        customerManager = new CustomerManager();
        mainView = new MainView(this);
    }

    private void showmenu() {
        int choice = 0;

        do {
            choice = mainView.showMenu();

            switch (choice){
                case 1:
                    mainView.displayCustomerInfo(currentPerson.getInfoStrings());
                    break;
                case 2:
                    break;
                case 3:
                    mainView.readCustomerInfo();
                    break;
                case 4:
                    break;
                case -1:
                    break;
                default:
                    break;
            }

        }while (choice != 0);

    }

    private void showLogin()
    {
        int choice = 0;

        do {

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
