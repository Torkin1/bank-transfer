package control;

public class TransferMoneyBean {

    private final String sourceAccountUser;
    private final String sourceAccountId;
    private final String destinationAccountUser;
    private final String destinationAccountId;
    private final double amount;

    public TransferMoneyBean(String sourceAccountId, String destinationAccountId, double amount, String sourceAccountUser, String destinationAccountUser) {
        this.sourceAccountId = sourceAccountId;
        this.destinationAccountId = destinationAccountId;
        this.amount = amount;
        this.sourceAccountUser = sourceAccountUser;
        this.destinationAccountUser = destinationAccountUser;
    }

    public String getSourceAccountId() {
        return sourceAccountId;
    }
    public String getDestinationAccountId() {
        return destinationAccountId;
    }
    public double getAmount() {
        return amount;
    }
    
    public String getSourceAccountUser() {
        return sourceAccountUser;
    }

    public String getDestinationAccountUser() {
        return destinationAccountUser;
    }
    
    
}
