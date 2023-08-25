package model;

public class SalaryAccount extends Account{

    private String employer;

    public SalaryAccount(String accountId, double accountBalance, String accountType, String accountName, String employer) {
        super(accountId, accountBalance, accountType, accountName);
        this.employer = employer;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
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
}
