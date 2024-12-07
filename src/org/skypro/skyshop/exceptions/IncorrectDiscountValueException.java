package org.skypro.skyshop.exceptions;

import java.io.IOException;

public class IncorrectDiscountValueException extends IOException {
    public IncorrectDiscountValueException() {
    }

    public IncorrectDiscountValueException(String message) {
        super(message);
    }

    public IncorrectDiscountValueException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectDiscountValueException(Throwable cause) {
        super(cause);
    }
}
