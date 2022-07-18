package electricityboard.model;

public class TransactionDetails {
    private String customerId;
    private String transactionId;
    private String transactionTime;
    private String status;
    private double amountPaid;

    public TransactionDetails() {}

    public TransactionDetails(String customerId,String transactionId,String transactionTime, String status,double amountPaid){
        this.customerId = customerId;
        this.transactionId  = transactionId;
        this.transactionTime = transactionTime;
        this.status = status;
        this.amountPaid= amountPaid;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(String transactionTime) {
        this.transactionTime = transactionTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

}


