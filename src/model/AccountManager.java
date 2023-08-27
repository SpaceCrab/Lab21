package model;

public class AccountManager {
    Account[] accounts;
    int maxAccounts;
    int accountCount;

    public AccountManager(int maxAccounts)
    {
        this.maxAccounts = maxAccounts;
        accounts = new Account[this.maxAccounts];
        accountCount = 0;
    }

    /**
     * Returns an array of strings with the account information
     * @return
     */
    public String[] getAccountListStrings()
    {
        String[] accountStrings = new String[accountCount];
        for (int i = 0; i < accountCount; i++) {
            accountStrings[i] = accounts[i].toString();
        }
        return accountStrings;
    }

    /**
     * adds an account to the account list
     * @param account
     */
    public void addAccount(Account account)
    {
        accounts[accountCount++] = account;
    }

    /**
     * returns an account from the account list from the index index
     * as long as the index is in the range of the account list
     * @param index
     * @return Account
     */
    public Account getAccount(int index)
    {
        if (index < 0 || index >= accountCount)
            return null;
        return accounts[index];
    }

    /**
     * gets the next account id in the sequence
     * the account id is simply a sequencial number, it is unique for each account
     * @return String - the next account id
     */
    public String getNextID() {
        return String.valueOf(accountCount + 1);
    }

    /**
     * gets the current account id in the sequence
     * @return String - the current account id
     */
    public String getCurrentID() {
        return String.valueOf(accountCount);
    }

    /**
     * gets the number of accounts in the account list
     * @return int - the number of accounts
     */
    public int getAccountCount() {
        return accountCount;
    }

    /**
     * gets a list of accounts for a specific customerID
     * @param String customerID
     * @return Account[] - an array of accounts
     */
    public Account[] getCustomerAccounts(String customerID) {
        int[] accountIDs = new int[accountCount];
        int count = 0;
        for (int i = 0; i < accountCount; i++) {
            Account account = accounts[i];
            String[] accountHolders = account.getAccountHolders();
            for (int j = 0; j < accountHolders.length; j++) {
                if (accountHolders[j].equals(customerID)) {
                    accountIDs[count++] = i;
                    break;
                }
            }
        }
        Account[] customerAccounts = new Account[count];
        for  (int i = 0; i < count; i++) {
            customerAccounts[i] = accounts[accountIDs[i]];
        }
        return customerAccounts;
    }

    /**
     * gets a list of account information for a specific customerID
     * @param String customerID
     * @return String[] - an array of account information
     */
    public String[] getCustomerAccountInfos(String customerID) {
        Account[] customerAccounts = getCustomerAccounts(customerID);
        String[] accountStrings = new String[customerAccounts.length];
        for  (int i = 0; i < customerAccounts.length; i++) {
            accountStrings[i] = customerAccounts[i].toString();
        }
        return accountStrings;
    }

    /**
     * removes an account from the account list
     * @param customerID
     * @param accountID
     * @return boolean - true if the account was removed, false otherwise
     */
    public boolean removeCustomerAccount(String customerID, String accountID){
        int index = -1;
        for (int i = 0; i < accountCount; i++) {
            Account account = accounts[i];
            if (account.getAccountId().equals(accountID)) {
                String[] accountHolders = account.getAccountHolders();
                for (int j = 0; j < accountHolders.length; j++) {
                    if (accountHolders[j].equals(customerID)) {
                        index = i;
                        break;
                    }
                }
            }
        }
        if (index != -1) {
            for (int i = index; i < accountCount - 1; i++) {
                accounts[i] = accounts[i + 1];
            }
            accountCount--;
            return true;
        }
        return false;
    }
}
