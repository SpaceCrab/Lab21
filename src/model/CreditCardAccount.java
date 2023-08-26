package model;

public class CreditCardAccount extends Account{

    private double creditLimit;

    private double interestRate;

    public CreditCardAccount(String accountId, String accountName, double accountBalance, String accountType, double creditLimit, double interestRate) {
        super(accountId, accountBalance, accountName, accountType);
        this.creditLimit = creditLimit;
        this.interestRate = interestRate;
    }

    @Override
    public void setAccountId() {

    }

    @Override
    public String getAccountName() {
        return null;
    }

    @Override
    public void setAccountName() {

    }

    @Override
    public void setAccountType() {

    }

    @Override
    public double setBalance() {
        return 0;
    }

    @Override
    public String toString() {
        return super.toString() + " " + creditLimit + " " + interestRate;
    }
}
