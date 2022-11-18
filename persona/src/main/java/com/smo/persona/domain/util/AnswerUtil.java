package com.smo.persona.domain.util;

import com.smo.persona.domain.answer.AnswerData;
import com.smo.persona.domain.answer.AnswerException;
import org.springframework.http.HttpStatus;

public class AnswerUtil {

    public AnswerException buildMessageException(HttpStatus status, String message){
        return new AnswerException(status, message);
    }

    public AnswerData buildMessageData(){
        return null;
    }

}
