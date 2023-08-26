package model;

public class CreditCardAccount extends Account {

    private double creditLimit;
    private double interestRate;

    public CreditCardAccount(String accountId, double accountBalance, String accountName, AccountType accountType, double creditLimit, double interestRate) {
        super(accountId, accountBalance, accountName, accountType);
        this.creditLimit = creditLimit;
        this.interestRate = interestRate;
    }

    public double getCreditLimit() {
        return creditLimit;
    }
    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }
    public double getInterestRate() {
        return interestRate;
    }
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return super.toString() + " " + creditLimit + " " + interestRate;
    }
}
