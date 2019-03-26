package betPawa.wallet.user;

import betPawa.wallet.constant.Currency;

public class DepositRequest {

    private Long userId;

    private Double amount;

    private String currency;

    public DepositRequest() {
    }

    public DepositRequest(Long userId, Double amount, String currency) {
        this.userId = userId;
        this.amount = amount;
        this.currency = currency;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
