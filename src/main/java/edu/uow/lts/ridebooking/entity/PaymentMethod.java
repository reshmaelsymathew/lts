package edu.uow.lts.ridebooking.entity;

public enum PaymentMethod {
    CREDIT_CARD("Credit Card"),
    APPLE_PAYMENT("Apple Payment"),
    CASH("Cash"),
    BANK_TRANSFER("Bank Transfer");

    private final String paymentMethodName;

    PaymentMethod(String paymentMethodName) {
        this.paymentMethodName = paymentMethodName;
    }

    public String getPaymentMethodName() {
        return paymentMethodName;
    }


    /**
     * @return
     */
    @Override
    public String toString() {
        return super.toString();
    }
}