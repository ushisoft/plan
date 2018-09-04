package io.ushi.plan.controller.advice;

import io.ushi.exception.UnexpectedLogicException;
import io.ushi.rest.ErrorEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ValidExceptionHandler {

    // 422, UNPROCESSABLE_ENTITY 数据格式错误
    // 401, UNAUTHORIZED 鉴权失败

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ResponseBody
    public List<ErrorEntity> processBeanValidation(MethodArgumentNotValidException ex) {
        return ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(source -> ErrorEntity.field(source.getField())
                        .error(source.getCode())
                        .message(source.getDefaultMessage())
                        .build())
                .collect(Collectors.toList());
    }

    @ExceptionHandler(UnexpectedLogicException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public List<ErrorEntity> processUnexpectedLogic(UnexpectedLogicException ex) {
        return Arrays.asList(ex.getErrorEntity());
    }
}
