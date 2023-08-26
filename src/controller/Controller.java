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
        customerManager = new CustomerManager();
        mainView = new MainView(this);
        currentCustomer = null;

        showLogin();
    }

    private void showLogin()
    {
        int choice = 0;

        do {
            String[] persons = customerManager.getCustomerList();
            choice = mainView.showLoginMenu(persons);

            if (choice >= 0 && choice < persons.length)
            {
                currentCustomer = customerManager.getCustomer(choice);
                mainView.showMessage("Välkommen " + currentCustomer.getFirstName() + " " + currentCustomer.getLastName());
                showMainMenu();
            }
        }while (choice != -1);

    }

    /*
    * Shows the main menu and handles the user input
     */
    private void showMainMenu() {
        int choice = 0;

        do {
            choice = mainView.showMainMenu();

            switch (choice){
                case 1:
                    String[] customerInfo = getCustomerInfo(currentCustomer);
                    mainView.displayCustomerInfo(customerInfo);
                    break;
                case 2:
                    String[] accountInfo = getAccountInfo(currentCustomer);
                    mainView.displayCustomerInfo(accountInfo);
                    break;
                case 3:
                    showAccountCreationMenu();
                    break;
                case 4:
                    break;
                case -1:
                    mainView.showMessage("Välkommen åter!");
                    break;
                default:
                    break;
            }

        }while (choice != -1);

    }


    private void showAccountCreationMenu(){
        int choice = 0;

        do {
            choice = mainView.showAccountCreationMenu();

            switch (choice){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case -1:
                    break;
                default:
                    break;
            }

        }while (choice != -1);
    }

    public String[] getCustomerInfo(Customer customer){
        return customer.getInfoStrings();
    }

    public String[] getAccountInfo(Customer customer){
        return customer.getAccountStrings();
    }
    public void setCustomerPersonNr(String personNr){
        if(currentCustomer == null)
            currentCustomer = new Customer();

        currentCustomer.setPersonalNr(personNr);

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
