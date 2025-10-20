package payExample;

public class XPayToPayDAdapter implements PayD {

    private String custCardNo;
    private String cardOwnerName;
    private String cardExpMonthDate;
    private Integer cVVNo;
    private Double totalAmount;
    private final XPay xpay;

    public XPayToPayDAdapter(XPay xpay){
        this.xpay = xpay;
        setProp();
    }

    public String getCustomCardNo() {
        return custCardNo;
    }

    public String getCardOwnerName() {
        return cardOwnerName;
    }

    public String getCardExpMonthDate() {
        return cardExpMonthDate;
    }

    public Integer getCVVNo() {
        return cVVNo;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setCustomCardNo(String customCardNo) {
        this.custCardNo = custCardNo;
    }

    public void setCardOwnerName(String cardOwnerName) {
        this.cardOwnerName = cardOwnerName;
    }

    public void setCardExpMonthDate(String cardExpMonthDate) {
        this.cardExpMonthDate = cardExpMonthDate;
    }

    public void setCVVNo(Integer cVVNo) {
        this.cVVNo = cVVNo;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    private void setProp() {
        setCardOwnerName(this.xpay.getCustomerName());
        setCustomCardNo(this.xpay.getCreditCardNo());
        setCardExpMonthDate(this.xpay.getCardExpMonth()+"/"+this.xpay.getCardExpYear());
        setCVVNo(this.xpay.getCardCVVNo().intValue());
        setTotalAmount(this.xpay.getAmount());
    }
}
