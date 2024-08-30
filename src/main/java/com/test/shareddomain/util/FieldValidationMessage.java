package com.test.shareddomain.util;

import com.test.shareddomain.dto.response.BusinessFailedException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Component
public class FieldValidationMessage {

    public String getFieldMessage(String field){
        Properties appProps = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("field_validation.properties")) {

            if (input == null) {
                throw new BusinessFailedException("Error Message Properties", "global.messages.notfound", StatusCode.NOT_FOUND);
            }
            appProps.load(input);

        } catch (IOException ex) {
            throw new BusinessFailedException("Error Message Properties", "global.messages.notfound", StatusCode.NOT_FOUND);
        }
        return appProps.getProperty(field)==null?field:appProps.getProperty(field);
    }
}
