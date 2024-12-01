package control;

public class TransferMoneyBean {

    private final String sourceAccountId;
    private final String destinationAccountId;
    private final double amount;

    private double updatedSourceBalance;
    private double updatedDestinationBalance;

    public TransferMoneyBean(String sourceAccountId, String destinationAccountId, double amount) {
        this.sourceAccountId = sourceAccountId;
        this.destinationAccountId = destinationAccountId;
        this.amount = amount;
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
    
    public double getUpdatedSourceBalance() {
        return updatedSourceBalance;
    }

    public void setUpdatedSourceBalance(double updatedSourceBalance) {
        this.updatedSourceBalance = updatedSourceBalance;
    }

    public double getUpdatedDestinationBalance() {
        return updatedDestinationBalance;
    }

    public void setUpdatedDestinationBalance(double updatedDestinationBalance) {
        this.updatedDestinationBalance = updatedDestinationBalance;
    }
    
    
}
