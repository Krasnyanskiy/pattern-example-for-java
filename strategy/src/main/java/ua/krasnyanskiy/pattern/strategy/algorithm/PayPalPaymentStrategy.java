package ua.krasnyanskiy.pattern.strategy.algorithm;

/**
 * @author Alexander Krasnyanskiy
 */
public class PayPalPaymentStrategy implements PaymentStrategy {

    private String emailId;
    private String password;
    private int commission;

    public PayPalPaymentStrategy(String emailId, String password) {
        this.emailId = emailId;
        this.password = password;
        commission = 3;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCommission() {
        return commission;
    }

    public void setCommission(int commission) {
        this.commission = commission;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + commission + " paid with PayPal of account " + emailId);
    }
}
