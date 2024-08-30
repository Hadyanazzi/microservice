package com.test.shareddomain.constant;

import org.springframework.stereotype.Component;

@Component
public class GlobalConstant {
    public static final String ACTIVITY = "activity";
    public static final String FORMAT_TIMESTAMP = "yyyy-MM-dd HH:mm:ss";
    public static final String TAG_AUTHENTICATION_FORMAT = "JWT";
    public static final String TAG_AUTHENTICATION_HEADER = "Authorization";
    public static final String TAG_AUTHENTICATION_TYPE = "bearer";
    public static class Key {
        public static final String USER= "user";
    }
}
