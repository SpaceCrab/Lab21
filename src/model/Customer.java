package model;

public class Customer extends Person{

    public Customer(String firstName, String lastName, String personalnr,String customerId,Address address) {
        super(firstName, lastName, personalnr);
        this.customerId = customerId;
        this.address = address;
    }

    public Customer() {
    }
    private String customerId;
    private Address address;

    private String phoneNumber;

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getAddressString() {
        return address.toString();
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    //list of customer accounts
    private Account[] accounts;

    public Account getAccount(int index){
        return accounts[index];
    }

    public String[] getAccountStrings(){
        if(accounts == null)
        {
            String[] retString= new String[1];
            retString[0] = "No accounts";
            return retString;
        }
        String[] accountStrings = new String[accounts.length];
        for(int i = 0; i < accounts.length; i++)
        {
            accountStrings[i] = accounts[i].toString();
        }
        return accountStrings;
    }

    public void addAccount(Account account){
        if(accounts == null)
        {
            accounts = new Account[1];
            accounts[0] = account;
        }
        else
        {
            Account[] temp = new Account[accounts.length + 1];
            for(int i = 0; i < accounts.length; i++)
            {
                temp[i] = accounts[i];
            }
            temp[accounts.length] = account;
            accounts = temp;
        }
    }

    public void removeAccount(Account account){
        if(accounts == null)
        {
            return;
        }
        else
        {
            Account[] temp = new Account[accounts.length - 1];
            int j = 0;
            for(int i = 0; i < accounts.length; i++)
            {
                if(!accounts[i].equals(account))
                {
                    temp[j] = accounts[i];
                    j++;
                }
            }
            accounts = temp;
        }
    }

    public String[] getInfoStrings()
    {
        String[] infoStrings = new String[5];
        infoStrings[0] = "First name: " + getFirstName();
        infoStrings[1] = "Last name: " + getLastName();
        infoStrings[2] = "Personal Nr: " + getPersonalNr();
        infoStrings[3] = "Customer Id: " + customerId;
        infoStrings[4] = "Address: " + address.toString();
        return infoStrings;
    }

}
