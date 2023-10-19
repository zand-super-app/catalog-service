package ae.superapp.catalog.exception.enums;

import lombok.Getter;

@Getter
public enum CatalogErrorCodes {

    INVALID_REQUEST("0001", "Invalid request"),
    BAD_REQUEST("0028", "Bad Request received");
    private String errorCode;
    private String errorMessage;

    CatalogErrorCodes(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
