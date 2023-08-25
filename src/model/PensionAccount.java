package model;

public class PensionAccount extends SavingsAccount{

    private int pensionAge;
    private int pensionWithdrawalAge;
    public PensionAccount(String accountId, double accountBalance, String accountType, String accountName, double interestRate, int pensionAge, int pensionWithdrawalAge) {
        super(accountId, accountBalance, accountType, accountName, interestRate, 0, -1);
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
}
