package model;

public class SavingsAccount extends Account{

    private double minimumBalance;
    private double maximumWithdrawals;
    private double currentWithdrawals;
    protected double interestRate;

    public SavingsAccount(
        String accountId,
        double accountBalance,
        String accountName,
        AccountType accountType,
        double interestRate,
        double minimumBalance,
        double maximumWithdrawals
    ) {
        super(accountId, accountBalance, accountName, accountType);
        this.interestRate = interestRate;
        this.minimumBalance = minimumBalance;
        this.maximumWithdrawals = maximumWithdrawals;
        this.currentWithdrawals = 0.0;
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

    public double calculateSavingsAmount(int years) {
        double savingsAmount = getBalance() * Math.pow(1 + interestRate, years);
        return savingsAmount;
    }

    @Override
    public String toString() {
        return super.toString() + " " + interestRate + " " + minimumBalance + " " + maximumWithdrawals;
    }
}
