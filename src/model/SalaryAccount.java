package model;

public class SalaryAccount extends Account{

    private String employer;

    public SalaryAccount(String accountId, double accountBalance, String accountName, AccountType accountType, String employer) {
        super(accountId, accountBalance, accountName, accountType);
        this.employer = employer;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    @Override
    public String toString() {
        return super.toString() + " " + employer;
    }
}
