package model;

public abstract class Account implements IAccount {
    private String accountId;
    private double accountBalance;
    private String accountType;

    private String accountName;

    public Account(String accountId, double accountBalance, String accountType, String accountName) {
        this.accountId = accountId;
        this.accountBalance = accountBalance;
        this.accountType = accountType;
        this.accountName = accountName;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;

    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return accountBalance;
    }

}
