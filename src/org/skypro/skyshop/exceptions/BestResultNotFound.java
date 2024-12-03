package org.skypro.skyshop.exceptions;

import java.io.IOException;

public class BestResultNotFound extends IOException {
    public BestResultNotFound() {
    }

    public BestResultNotFound(String message) {
        super(message);
    }

    public BestResultNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public BestResultNotFound(Throwable cause) {
        super(cause);
    }
}
