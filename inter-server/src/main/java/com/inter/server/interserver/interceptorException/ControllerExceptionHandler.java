package com.inter.server.interserver.interceptorException;

import com.inter.server.interserver.exception.BusinessRuleException;
import com.inter.server.interserver.exception.NonExistentException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ControllerExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public MessageBuilder processValidationError(MethodArgumentNotValidException exception) {
        MessageBuilder messageBuilder = new MessageBuilder();
        messageBuilder.setField(exception.getBindingResult().getFieldError().getField());
        messageBuilder.setMessage(exception.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        return messageBuilder;
    }

    @ExceptionHandler(BusinessRuleException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public MessageBuilder processValidationErrorIntern(BusinessRuleException exception) {
        MessageBuilder messageBuilder = new MessageBuilder();
        messageBuilder.setField(exception.getField());
        messageBuilder.setTitle(exception.getError());
        messageBuilder.setMessage(exception.getMessage());
        return messageBuilder;
    }

    @ExceptionHandler(NonExistentException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public MessageBuilder processValidationErrorNotFound(NonExistentException exception) {
        MessageBuilder messageBuilder = new MessageBuilder();
        messageBuilder.setField(exception.getField());
        messageBuilder.setTitle(exception.getError());
        messageBuilder.setMessage(exception.getMessage());
        return messageBuilder;
    }
}