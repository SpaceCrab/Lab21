package model;

public class OrgAccount extends Account {
    private String orgId;
    public OrgAccount(String accountId, double accountBalance, String accountName, AccountType accountType, String orgId) {
        super(accountId, accountBalance, accountName, accountType);
        this.orgId = orgId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }
}
