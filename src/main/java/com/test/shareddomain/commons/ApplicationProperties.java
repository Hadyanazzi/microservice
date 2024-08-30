package com.test.shareddomain.commons;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties
public class ApplicationProperties {
    private Spring spring;
    private Application application;

    @Data
    public static class Spring {
        private Profiles profile;
        private Application application;
        private Datasource datasource;
        private Flyway flyway;
        private Security security;

        @Data
        public static class Security {
            private String[] authWhiteList;
            private String[] allowOriginList;
            private String[] requestMethodList;
            private String[] allowHeaderList;
            private String[] exposeHeaderList;
            private List<String> intranetIpPrefix;
        }

        @Data
        public static class Profiles {
            private String active;
        }
        @Data
        public static class Application {
            private String id;
            private String name;
            private String version;
        }
        @Data
        public static class Datasource {
            private String url;
            private String username;
            private String password;
        }
        @Data
        public static class Flyway {
            private Boolean enable;
        }
    }

    @Data
    public static class Application {
        private Security security;

        @Data
        public static class Security {
            private Jwt jwt;
            @Data
            public static class Jwt {
                private String secretKey;
                private Long expiration;
                private RefreshToken refreshToken;
            }
            @Data
            public static class RefreshToken {
                private Long expiration;
            }
        }
    }
}
