package model;

public class SavingsAccount extends Account{

    private double interestRate;

    private double minimumBalance;

    private double maximumWithdrawals;

    private double currentWithdrawals;
    public SavingsAccount(String accountId, double accountBalance, String accountType, String accountName, double interestRate, double minimumBalance, double maximumWithdrawals) {
        super(accountId, accountBalance, accountType, accountName);
        this.interestRate = interestRate;
        this.minimumBalance = minimumBalance;
        this.maximumWithdrawals = maximumWithdrawals;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public double getMaximumWithdrawals() {
        return maximumWithdrawals;
    }

    public void setMaximumWithdrawals(double maximumWithdrawals) {
        this.maximumWithdrawals = maximumWithdrawals;
    }

    public double getCurrentWithdrawals() {
        return currentWithdrawals;
    }

    public void increaseCurrentWithdrawals() {
        this.currentWithdrawals++;
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
        return super.toString() + " " + interestRate + " " + minimumBalance + " " + maximumWithdrawals;
    }
}
