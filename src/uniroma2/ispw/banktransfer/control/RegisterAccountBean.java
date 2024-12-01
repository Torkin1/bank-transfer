package uniroma2.ispw.banktransfer.control;

public class RegisterAccountBean {
    
    private final String username;
    private final String accountId;
    private final double initialBalance;
    
    public String getAccountId() {
        return accountId;
    }
    public double getInitialBalance() {
        return initialBalance;
    }

    public String getUsername() {
        return username;
    }

    public RegisterAccountBean(String username, String accountId, double initialBalance) {
        this.accountId = accountId;
        this.initialBalance = initialBalance;
        this.username = username;
    }


}
