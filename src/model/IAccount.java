package model;

public interface IAccount {
    public void addAccountHolder(String customerID);
    public String[] getAccountHolders();

    public String getAccountId();
    public void setAccountId(String accountId);
    public String getAccountName();
    public void setAccountName(String accountName);
    public AccountType getAccountType();
    public void setAccountType(AccountType accountType);
    public double getBalance();
    public void setBalance(double balance);
}
