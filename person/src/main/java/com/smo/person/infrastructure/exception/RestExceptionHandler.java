package com.smo.person.infrastructure.exception;

import com.smo.person.domain.answer.AnswerException;
import com.smo.person.domain.exception.BussinessException;
import com.smo.person.domain.util.AnswerUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    private final AnswerUtil answerUtil;

    public RestExceptionHandler(AnswerUtil answerUtil) {
        this.answerUtil = answerUtil;
    }

    @ExceptionHandler(BussinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<AnswerException> handleBusinessException(BussinessException exception){
        return handleException(exception.getStatus(), exception.getDetail());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<AnswerException> handleBodyException(MethodArgumentNotValidException exception){
        String messageBuild = exception.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        return handleException(HttpStatus.BAD_REQUEST, messageBuild);
    }

    private ResponseEntity<AnswerException> handleException(HttpStatus status, String exception) {
        AnswerException answerException = answerUtil.buildMessageException(status, exception);
        return new ResponseEntity<>(answerException , answerException.getStatus());
    }

}
