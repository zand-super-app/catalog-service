package ae.superapp.catalog.exception.advice;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import ae.superapp.catalog.exception.BadRequestException;
import ae.superapp.catalog.exception.dto.ApiError;
import ae.superapp.catalog.exception.dto.Error;
import ae.superapp.catalog.exception.enums.CatalogErrorCodes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
@Hidden
@Slf4j
public class RestControllerExceptionHandler {

    /*
     * Handles javax.validation.ConstraintViolationException. Thrown when @Validated
     * fails.
     */
    @ExceptionHandler(value = { ConstraintViolationException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleConstraintViolationException(ConstraintViolationException exception,
                                                       WebRequest request) {
        List<ConstraintViolation<?>> constraintViolations = exception.getConstraintViolations().stream().toList();
        List<Error> errorList = new ArrayList<>();
        Error error = new Error();
        constraintViolations.forEach(constraintViolation -> {
            error.setErrorCode(CatalogErrorCodes.BAD_REQUEST.getErrorCode());
            error.setErrorMessage(constraintViolation.getMessage());
            errorList.add(error);
        });
        return ApiError.builder()
                .status(HttpStatus.BAD_REQUEST)
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .debugMessage("Violations Errors")
                .errors(errorList)
                .build();
    }

    /*
     * Handle MethodArgumentNotValidException. Triggered when an object fails @Valid
     * validation.
     */
    @ExceptionHandler(value = { MethodArgumentNotValidException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleMethodArgumentNotValidException(MethodArgumentNotValidException exception,
            WebRequest request) {
        List<Error> errorList = new ArrayList<>();
        Error error = new Error();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        List<ObjectError> globalErrors = exception.getBindingResult().getGlobalErrors();
        fieldErrors.forEach(fieldError -> {
            error.setErrorCode(CatalogErrorCodes.BAD_REQUEST.getErrorCode());
            error.setErrorMessage(fieldError.getField());
            errorList.add(error);
            globalErrors.forEach(globalError -> {
                error.setErrorCode(CatalogErrorCodes.BAD_REQUEST.getErrorCode());
                error.setErrorMessage(globalError.getObjectName());
                errorList.add(error);
            });
        });
        return ApiError.builder()
            .status(HttpStatus.BAD_REQUEST)
            .statusCode(HttpStatus.BAD_REQUEST.value())
            .debugMessage("Violations Errors")
            .timestamp(LocalDateTime.now())
            .errors(errorList)
            .build();
    }

    @ExceptionHandler(value = { HttpMediaTypeNotSupportedException.class })
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    public ApiError handleMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException exception,
            WebRequest request) {
        return ApiError.builder()
                .status(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
                .statusCode(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value())
                .debugMessage(exception.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ExceptionHandler(value = { HttpMessageNotReadableException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleHttpMessageNotReadableException(HttpMessageNotReadableException exception,
            WebRequest request) {
        return ApiError.builder()
                .status(HttpStatus.BAD_REQUEST)
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .debugMessage(exception.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleBadRequestException(BadRequestException ex, WebRequest request) {
        List<Error> errorList = new ArrayList<>();
        log.error("Bad Request", ex);
        Error error = new Error();
        error.setErrorCode(ex.getErrorCode());
        error.setErrorMessage(ex.getMessage());
        errorList.add(error);
        return ApiError.builder()
                .status(HttpStatus.BAD_REQUEST)
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .debugMessage("Bad Request")
                .timestamp(LocalDateTime.now())
                .errors(errorList)
                .build();
    }

    @ExceptionHandler(value = { Exception.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiError handleNoHandlerFoundException(NoHandlerFoundException exception, WebRequest request) {
        log.error("Unknown exception happened : ", exception);
        return ApiError.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .debugMessage(exception.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }

}
