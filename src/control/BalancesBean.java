package control;

import java.util.HashMap;
import java.util.Map;

public class BalancesBean {

    private final String username;
    private final Map<String, Double> balances = new HashMap<>();

    public BalancesBean(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public Map<String, Double> getBalances() {
        return balances;
    }

}
