package model;

public abstract class Account implements IAccount {
    private String accountId;
    private double accountBalance;
    private AccountType accountType;
    private String accountName;


    private String accountHolders[] = null;
    private int accountHolderCount = 0;

    public Account(String accountId, double accountBalance, String accountName, AccountType accountType) {
        this.accountId = accountId;
        this.accountBalance = accountBalance;
        this.accountType = accountType;
        this.accountName = accountName;
    }

    @Override
    public void addAccountHolder(String customerID) {
        if (accountHolders == null) accountHolders = new String[1];
        if (accountHolderCount == accountHolders.length) {
            String[] temp = new String[accountHolders.length + 1];
            for (int i = 0; i < accountHolders.length; i++) {
                temp[i] = accountHolders[i];
            }
            accountHolders = temp;
        }
        accountHolders[accountHolderCount++] = customerID;
    }

    @Override
    public String[] getAccountHolders() {
        return accountHolders;
    }

    @Override
    public String getAccountId() {
        return accountId;
    }

    @Override
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @Override
    public String getAccountName() {
        return accountName;
    }

    @Override
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @Override
    public AccountType getAccountType() {
        return accountType;
    }

    @Override
    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    @Override
    public double getBalance() {
        return accountBalance;
    }

    @Override
    public void setBalance(double balance) {
        this.accountBalance = balance;
    }

    @Override
    public String toString() {
        return accountName + " " + accountId + " " + accountType + " " + accountBalance;
    }
}
