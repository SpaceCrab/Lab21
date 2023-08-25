package model;

public class OrgAccount extends Account{

    private String orgId;
    public OrgAccount(String accountId, double accountBalance, String accountType, String accountName, String orgId) {
        super(accountId, accountBalance, accountType, accountName);
        this.orgId = orgId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
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
