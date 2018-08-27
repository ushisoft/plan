package io.ushi.plan.controller.advice;

import io.ushi.rest.ErrorEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ValidExceptionHandler {

    // 422, UNPROCESSABLE_ENTITY 数据格式错误
    // 401, UNAUTHORIZED 鉴权失败

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ResponseBody
    public List<ErrorEntity> process(MethodArgumentNotValidException ex) {
        return ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(source -> {
                    ErrorEntity target = new ErrorEntity();
                    target.setField(source.getField());
                    target.setCode(source.getCode());
                    target.setMessage(source.getDefaultMessage());
                    return target;
                })
                .collect(Collectors.toList());
    }
}
