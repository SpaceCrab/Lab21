package controller;

import model.*;
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
                    showAccountDeletionMenu();
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
                    createSavingsAccount();
                    break;
                case 2:
                    createSalaryAccount();
                    break;
                case 3:
                    createCreditAccount();
                    break;
                case 4:
                    createPensionAccount();
                    break;
                case -1:
                    break;
                default:
                    break;
            }

        }while (choice != -1);
    }

    private void showAccountDeletionMenu(){
        int choice = 0;
        do{
            String[] accountInfo = getAccountInfo(currentCustomer);
            choice = mainView.showAccountDeletionMenu(accountInfo);
            if(choice >= 0 && choice < accountInfo.length){
                currentCustomer.removeAccount(currentCustomer.getAccount(choice));
            }
        }while(choice != -1);
    }

    public void createCreditAccount(){
        String accountId = ""+(int)(Math.random() * 100) ;
        String accountName = mainView.getInformation("Ange kontonamn");
        String accountType = "Credit";
        double interestRate = 0.05;
        double creditLimit = 10000;
        double accountBalance = 0;

        Account creditAccount = new CreditCardAccount(accountId, accountName, accountBalance, accountType, creditLimit, interestRate);
        currentCustomer.addAccount(creditAccount);
    }

    public void createSavingsAccount(){
        String accountId = ""+(int)(Math.random() * 100) ;
        String accountName = mainView.getInformation("Ange kontonamn");
        String accountType = "Savings";
        double interestRate = 0.05;
        double accountBalance = 0;
        double minimumBalance = 0;
        double maximumWithdrawals = 50;

        Account savingsAccount = new SavingsAccount(accountId, accountBalance, accountType, accountName, interestRate, minimumBalance, maximumWithdrawals);
        currentCustomer.addAccount(savingsAccount);
    }

    public void createSalaryAccount(){
        String accountId = ""+(int)(Math.random() * 100) ;
        String accountName = mainView.getInformation("Ange kontonamn");
        String accountType = "Salary";
        String employer = mainView.getInformation("Ange arbetsgivare");
        double accountBalance = 0;

        Account salaryAccount = new SalaryAccount(accountId, accountBalance, accountType, accountName, employer);
        currentCustomer.addAccount(salaryAccount);
    }

    public void createPensionAccount(){
        String accountId = ""+(int)(Math.random() * 100) ;
        String accountName = mainView.getInformation("Ange kontonamn");
        String accountType = "Pension";
        double interestRate = 0.05;
        double accountBalance = 0;
        int pensionAge = 65;
        int pensionWithdrawalAge = 70;

        Account pensionAccount = new PensionAccount(accountId, accountBalance, accountType, accountName, interestRate, pensionAge, pensionWithdrawalAge);
        currentCustomer.addAccount(pensionAccount);
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
