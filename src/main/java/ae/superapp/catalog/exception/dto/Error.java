package ae.superapp.catalog.exception.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class Error implements Serializable {

    private static final long serialVersionUID = 1L;

    private String errorCode;
    private String errorMessage;
}
