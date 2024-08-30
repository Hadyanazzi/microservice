package com.test.shareddomain.message;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.shareddomain.constant.GlobalConstant;
import com.test.shareddomain.transform.ConvertTransform;
import com.test.shareddomain.util.Activity;
import com.test.shareddomain.util.GlobalResponse;
import com.test.shareddomain.util.ResultResponse;
import lombok.AllArgsConstructor;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static com.test.shareddomain.util.StatusCode.OK;

@Component
public class MessageUtils {
    @Autowired
    MessageSourceUtil messageSourceUtil;


    public GlobalResponse<Object> successDto(Object data) {
        ResultResponse resultResponse= ResultResponse.builder()
                .fieldErrorList(new ArrayList<>())
                .message(messageSourceUtil.getMessageSourceWithParam("global.messages.success",
                        messageSourceUtil.getMessageSource(Activity.getProperties(MDC.get(GlobalConstant.ACTIVITY)))))
                .data(data)
                .build();
        return new GlobalResponse<>(
                ConvertTransform.timestampTotimestampWithTimeZone(Timestamp.valueOf(LocalDateTime.now())),
                OK.getHttpStatus().value(),
                OK.getCodeDesc(),
                OK,
                OK.getMessage(),
                resultResponse);
    }
}
