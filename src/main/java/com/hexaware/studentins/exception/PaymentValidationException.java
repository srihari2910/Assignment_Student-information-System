package com.hexaware.studentins.exception;

public class PaymentValidationException extends Exception {
	private static final long serialVersionUID = 1L;
    public PaymentValidationException(String PaymentValidation) {
        super(PaymentValidation);
    }
}
