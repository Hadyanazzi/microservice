package com.test.shareddomain.transform;

import com.test.shareddomain.constant.GlobalConstant;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public interface ConvertTransform {
    public static String timestampTotimestampWithTimeZone(Timestamp input) {
        String result = null;

        if(input!=null){
            String localeDate = input.toLocalDateTime().toString();
            ZoneId timeZone = ZoneId.of("Asia/Jakarta");
            ZonedDateTime zonedDateTime = LocalDateTime.parse(localeDate, DateTimeFormatter.ISO_DATE_TIME).atZone(timeZone);
            result = zonedDateTime.toString().split("[\\[]")[0];
        }

        return result;
    }

    public static String getTimestamp(Date date){
        DateFormat dateFormat = new SimpleDateFormat(GlobalConstant.FORMAT_TIMESTAMP);
        return dateFormat.format(date);
    }
}
