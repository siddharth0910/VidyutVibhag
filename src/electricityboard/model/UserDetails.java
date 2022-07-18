package electricityboard.model;

public class UserDetails {
    private  int id;
    private  String customerId;
    private int consumedUnits;
    private  String  customerName;
    private  String state;
    private long walletBalance;

    public UserDetails() {}


    public UserDetails(int id, String customerId, int consumedUnits, String state, String customerName, long walletBalance){
        this.consumedUnits = consumedUnits;
        this.customerId = customerId;
        this.id= id;
        this.customerName=customerName;
        this.state=state;
        this.walletBalance=walletBalance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public int getConsumedUnits() {
        return consumedUnits;
    }

    public void setConsumedUnits(int consumedUnits) {
        this.consumedUnits = consumedUnits;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(long walletBalance) {
        this.walletBalance = walletBalance;
    }
}


