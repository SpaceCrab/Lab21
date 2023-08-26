package controller;

import model.*;
import view.MainView;

public class Controller {
    private CustomerManager customerManager;
    private AccountManager accountManager;

    private MainView mainView;

    public Controller()
    {
        final int MAX_CUSTOMERS = 10;
        final int MAX_ACCOUNTS = 10;
        customerManager = new CustomerManager(MAX_CUSTOMERS);
        accountManager = new AccountManager(MAX_ACCOUNTS);

        // Create some test data
        customerManager.addCustomer(new Customer(customerManager.getNextID(), "Emily", "Wong", "555555-5555", new Address("789 Maple St", "Bigtown", "13579")));
        Account account = new SavingsAccount(accountManager.getNextID(), 0.0, "Sparkonto", AccountType.Savings, 0.05, 0.0, 50);
        account.addAccountHolder(customerManager.getCurrentID());
        accountManager.addAccount(account);

        customerManager.addCustomer(new Customer(customerManager.getNextID(), "John", "Doe", "111111-1111", new Address("123 Main St", "Anytown", "12345")));
        customerManager.addCustomer(new Customer(customerManager.getNextID(), "Sarah", "Smith", "333333-3333", new Address("789 Elm St", "Another Town", "54321")));
        customerManager.addCustomer(new Customer(customerManager.getNextID(), "David", "Lee", "444444-4444", new Address("456 Pine St", "Smalltown", "98765")));

        mainView = new MainView(this);
        showLogin();
    }

    private void showLogin()
    {
        int choice = 0;

        do {
            String[] persons = customerManager.getCustomerList();
            choice = mainView.showLoginMenu(persons);
            boolean ok = customerManager.setLoginAsCustomerIndex(choice);
            if (ok) showMainMenu();
            else mainView.showMessage("Felaktigt val");
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
                    mainView.displayCustomerInfo(customerManager.getLoginAsCustomer().getInfoStrings());
                    break;
                case 2:
                    String[] accountInfo = accountManager.getCustomerAccountInfos(customerManager.getLoginAsCustomer().getCustomerId());
                    mainView.displayCustomerInfo(accountInfo);
                    break;
                case 3:
                    showAccountCreationMenu();
                    break;
                case 4:
                    showAccountDeletionMenu();
                    break;
                case 5:
                    String[] allAccountInfo = accountManager.getAccountListStrings();
                    mainView.displayAccountInfo(allAccountInfo);
                    break;    
                case -1:
                    mainView.showMessage("Välkommen åter!");
                    customerManager.logout();
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
                case 5:
                    createOrgAccount();
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

        do {
            String customerID = customerManager.getLoginAsCustomer().getCustomerId();
            String[] accountInfo = accountManager.getCustomerAccountInfos(customerID);
            choice = mainView.showAccountDeletionMenu(accountInfo);

            if(choice != -1){
                Account[] accounts = accountManager.getCustomerAccounts(customerID);
                boolean ok = accountManager.removeCustomerAccount(customerID, accounts[choice].getAccountId());
                
                if(ok)
                    mainView.showMessage("Konto borttaget");
                else
                    mainView.showMessage("Kunde inte ta bort konto");
            }

        }while (choice != -1);
    }

    public void createSavingsAccount(){
        String accountId = accountManager.getNextID();
        String accountName = mainView.getInformation("Ange kontonamn");
        AccountType accountType = AccountType.Savings;
        double interestRate = 0.05;
        double accountBalance = 0;
        double minimumBalance = 0;
        double maximumWithdrawals = 50;

        Account savingsAccount = new SavingsAccount(accountId, accountBalance, accountName, accountType, interestRate, minimumBalance, maximumWithdrawals);
        savingsAccount.addAccountHolder(customerManager.getLoginAsCustomer().getCustomerId());
        accountManager.addAccount(savingsAccount);
    }

    public void createCreditAccount(){
        String accountId = accountManager.getNextID();
        String accountName = mainView.getInformation("Ange kontonamn");
        AccountType accountType = AccountType.CreditCard;
        double creditLimit = 10000;
        double interestRate = 0.05;
        double accountBalance = 0;

        Account creditAccount = new CreditCardAccount(accountId, accountBalance, accountName, accountType, creditLimit, interestRate);
        creditAccount.addAccountHolder(customerManager.getLoginAsCustomer().getCustomerId());
        accountManager.addAccount(creditAccount);
    }

    public void createSalaryAccount(){
        String accountId = accountManager.getNextID();
        String accountName = mainView.getInformation("Ange kontonamn");
        AccountType accountType = AccountType.Salary;
        String employer = mainView.getInformation("Ange arbetsgivare");
        double accountBalance = 0;

        Account salaryAccount = new SalaryAccount(accountId, accountBalance, accountName, accountType, employer);
        salaryAccount.addAccountHolder(customerManager.getLoginAsCustomer().getCustomerId());
        accountManager.addAccount(salaryAccount);
    }

    public void createPensionAccount(){
        String accountId = ""+(int)(Math.random() * 100) ;
        String accountName = mainView.getInformation("Ange kontonamn");
        AccountType accountType = AccountType.Pension;
        double accountBalance = 0;
        int pensionAge = 65;
        int pensionWithdrawalAge = 70;

        Account pensionAccount = new PensionAccount(accountId, accountBalance, accountName, accountType, pensionAge, pensionWithdrawalAge);
        pensionAccount.addAccountHolder(customerManager.getLoginAsCustomer().getCustomerId());
        accountManager.addAccount(pensionAccount);
    }

    public void createOrgAccount(){
        String accountId = accountManager.getNextID();
        String accountName = mainView.getInformation("Ange kontonamn");
        AccountType accountType = AccountType.Organization;
        String orgId = mainView.getInformation("Ange orgId");
        double accountBalance = 0;

        Account orgAccount = new OrgAccount(accountId, accountBalance, accountName, accountType, orgId);
        orgAccount.addAccountHolder(customerManager.getLoginAsCustomer().getCustomerId());
        accountManager.addAccount(orgAccount);
    }

    // public String[] getCustomerInfo(Customer customer){
    //     return customer.getInfoStrings();
    // }

    // public String[] getAccountInfo(Customer customer){
    //     return customer.getAccountStrings();
    // }
    // public void setCustomerPersonNr(String personNr){
    //     if(currentCustomer == null)
    //         currentCustomer = new Customer();

    //     currentCustomer.setPersonalNr(personNr);

    // }

    // public void setCustomerFirstName(String firstName){
    //     if(currentCustomer == null)
    //         currentCustomer = new Customer();

    //     currentCustomer.setFirstName(firstName);
    // }

    // public void setCustomerLastName(String lastName){
    //     if(currentCustomer == null)
    //         currentCustomer = new Customer();

    //     currentCustomer.setLastName(lastName);
    // }

    public void addNewCustomer(){
        // boolean ok = customerManager.addCustomer(currentCustomer);
        // if (ok)
        //     mainView.showMessage("ny kund registrerad!");
        // else
        //     mainView.showMessage("kunde inte registrera");
    }
}
