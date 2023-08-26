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

    public String[] getAccountListStrings()
    {
        String[] accountStrings = new String[accountCount];
        for (int i = 0; i < accountCount; i++) {
            accountStrings[i] = accounts[i].toString();
        }
        return accountStrings;
    }

    public void addAccount(Account account)
    {
        accounts[accountCount++] = account;
    }

    public Account getAccount(int index)
    {
        if (index < 0 || index >= accountCount)
            return null;
        return accounts[index];
    }

    public String getNextID() {
        return String.valueOf(accountCount + 1);
    }

    public String getCurrentID() {
        return String.valueOf(accountCount);
    }

    public int getAccountCount() {
        return accountCount;
    }

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

    public String[] getCustomerAccountInfos(String customerID) {
        Account[] customerAccounts = getCustomerAccounts(customerID);
        String[] accountStrings = new String[customerAccounts.length];
        for  (int i = 0; i < customerAccounts.length; i++) {
            accountStrings[i] = customerAccounts[i].toString();
        }
        return accountStrings;
    }

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
