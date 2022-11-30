package com.smo.person.domain.exception;


import com.smo.person.domain.answer.AnswerException;

public class BodyException extends RuntimeException {
    AnswerException answerException;

    public AnswerException getAnswerException() {
        return answerException;
    }

    public void setAnswerException(AnswerException answerException) {
        this.answerException = answerException;
    }

}
