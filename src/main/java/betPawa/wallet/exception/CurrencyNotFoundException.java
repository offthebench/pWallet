package betPawa.wallet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CurrencyNotFoundException extends RuntimeException {

    public CurrencyNotFoundException() {
        super();
    }

    public CurrencyNotFoundException(String message) {
        super(message);
    }

    public CurrencyNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
