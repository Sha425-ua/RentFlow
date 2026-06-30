package com.rentflow.app.model.enums;

import lombok.Getter;

@Getter
public enum PaymentMethod {
    CASH("Готівка"),
    CREDIT_CARD("Кредитна картка"),
    BANK_TRANSFER("Банківський переказ"),
    PAYPAL("PayPal"),
    APPLE_PAY("Apple Pay"),
    GOOGLE_PAY("Google Pay");

    private final String label;

    PaymentMethod(String label) {
        this.label = label;
    }
}
