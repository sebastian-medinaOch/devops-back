package com.smo.persona.domain.exception;


import com.smo.persona.domain.answer.AnswerException;
import org.springframework.http.HttpStatus;

public class BodyException extends RuntimeException {
    AnswerException answerException;

    public AnswerException getAnswerException() {
        return answerException;
    }

    public void setAnswerException(AnswerException answerException) {
        this.answerException = answerException;
    }

}
