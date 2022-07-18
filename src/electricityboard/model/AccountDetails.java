package electricityboard.model;

public class AccountDetails {
    private  int id;
    private long cardNumber;
    private long cvv;
    private long pin;
    private int balance;
    private String accountHolderName;

    public AccountDetails() {
    }

    public AccountDetails(int id, long cardNumber, long cvv, long pin, int balance, String accountHolderName){
        this.id = id;
        this.cardNumber= cardNumber;
        this.cvv= cvv;
        this.pin = pin;
        this.balance= balance;
        this.accountHolderName=accountHolderName;
    }

    public int getId() {
        return id;
    }

    public void setid(int id) {
        id = id;
    }

    public long getcardNumber() {
        return cardNumber;
    }

    public void setcardNumber(long cardNumber) {this.cardNumber = cardNumber;
    }

    public long getcvv() {
        return cvv;
    }

    public void setcvv(long cvv) {
        this.cvv = cvv;
    }

    public long getpin() {
        return pin;
    }

    public void setpin(long pin) {
        this.pin = pin;
    }

    public int getbalance() {
        return balance;
    }

    public void setbalance(int balance) {
        this.balance = balance;
    }

    public String getaccountHoldeName() {
        return accountHolderName;
    }

    public void setaccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }


}


