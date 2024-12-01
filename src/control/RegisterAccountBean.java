package control;

public class RegisterAccountBean {
    
    private final String accountId;
    private final double initialBalance;
    
    public String getAccountId() {
        return accountId;
    }
    public double getInitialBalance() {
        return initialBalance;
    }

    public RegisterAccountBean(String accountId, double initialBalance) {
        this.accountId = accountId;
        this.initialBalance = initialBalance;
    }


}
