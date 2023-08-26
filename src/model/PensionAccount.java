package model;

public class PensionAccount extends SavingsAccount{
    private int pensionAge;
    private int pensionWithdrawalAge;
    private double bonus = 1.1;

    public PensionAccount(
        String accountId,
        double accountBalance,
        String accountName,
        AccountType accountType,
        int pensionAge,
        int pensionWithdrawalAge
    ) {
        super(accountId, accountBalance, accountName, accountType, 0.0, 0.0, -1.0);
        this.pensionAge = pensionAge;
        this.pensionWithdrawalAge = pensionWithdrawalAge;
    }

    public int getPensionAge() {
        return pensionAge;
    }

    public void setPensionAge(int pensionAge) {
        this.pensionAge = pensionAge;
    }

    public int getPensionWithdrawalAge() {
        return pensionWithdrawalAge;
    }

    public void setPensionWithdrawalAge(int pensionWithdrawalAge) {
        this.pensionWithdrawalAge = pensionWithdrawalAge;
    }

    @Override
    public double calculateSavingsAmount(int years) {
        // Krav 9 - Pensionssparande överskugga SavingsAccount
        double savingsAmount = getBalance() * Math.pow(1 + interestRate, years) * bonus;
        return savingsAmount;
    }

    @Override
    public String toString() {
        return super.toString() + " " + pensionAge + " " + pensionWithdrawalAge;
    }
}
