package com.test.shareddomain.util;


import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;



@Slf4j
public enum Activity {
    EXAMPLE("example");

    private final String properties;

    Activity(String properties) {
        this.properties = properties;
    }

    public static String getProperties(String name) {
        Activity activ = Arrays.stream(Activity.values())
                .filter(activity -> !activity.name().equals("NOT_FOUND")) // Excluding NOT_FOUND to avoid null pointer exception
                .filter(activity -> activity.name().matches(name))
                .findFirst()
                .orElse(null);
        return activ != null ? activ.properties : null;
    }
}
