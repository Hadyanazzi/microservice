package com.test.shareddomain.message;

import com.test.shareddomain.util.FieldValidationMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MessageSourceUtil {

    @Autowired
    private MessageSource messageSource;
    @Autowired
    FieldValidationMessage fieldValidationMessage;

    public String getMessageSource(String message) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(message, null, locale);
    }

    public String getMessageSourceWithParam(String message, String param) {
        param=fieldValidationMessage.getFieldMessage(param);
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(message,  new Object[]{param}, locale);
    }
}
