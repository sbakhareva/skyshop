package org.skypro.skyshop.exceptions;

import java.io.IOException;

public class IncorrectPriceValueException extends IOException {
    public IncorrectPriceValueException() {
    }

    public IncorrectPriceValueException(String message) {
        super(message);
    }

    public IncorrectPriceValueException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectPriceValueException(Throwable cause) {
        super(cause);
    }
}
