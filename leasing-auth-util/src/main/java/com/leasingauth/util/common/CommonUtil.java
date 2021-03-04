package com.leasingauth.util.common;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Date;

public class CommonUtil {

    public static final String PROJECT_NAME = "SCHEDULE PILOTO Service - 2020";
    public static final String COMPANY_NAME_DEFAULT = "SCHEDULE S.A.S";
    public static final String TYPE_PLAIN = "text/plain";
    public static final String TYPE_HTML = "text/html";
    public static final String ENCODING_DEFAULT = "UTF-8";
    public static final String CLASSPATH_MESSAGE = "classpath:messages";
    public static final String CLASSPATH = "classpath:";
    public static final String MESSAGE_SOURCE_DEFAULT = "messageSource";
    public static final String NAME_ASYNC_TASK_EXECUTOR = "threadPoolTaskExecutor";
    public static final String HEADER_CONTENT_TYPE = "Content-Type";
    public static final String HEADER_VALUES_CONTENT_TYPE = "text/plain; charset=UTF-8";
    public static final String LOG_STARTING_APPLICATION_START = "STARTING THE APPLICATION: {} STARTED!";
    public static final String LOG_STARTING_APPLICATION_END = "STARTING THE APPLICATION: {} COMPLETED!";
    public static final String LOG_EXECUTING_APPLICATION = "EXECUTING: {} command line runner";
    public static final String LOG_ERROR_DEFAULT = "ERROR CODE: {} - ERROR DESCRIPTION: {}";
    public static final String REDIRECT_ANOTHER_PAGE_COMMAND = "redirect:";
    public static DateTimeFormatter LOCAL_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    public static final SimpleDateFormat DATE_FORMAT_DEFAULT = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat DATE_TIME_FORMATTER = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    //    public static final String URL_APP_WEB = "http://localhost:4200";
    public static final String END_POINT_LOGIN_WEB = "/#/login";

    public static Integer getInteger(String integerStr) {
        try {
            return Integer.parseInt(integerStr);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static String encodeBase64(String decodeStr) {
        return Base64.getEncoder().encodeToString(decodeStr.getBytes());
    }

    public static String decodeBase64(String encodeStr) {
        return new String(Base64.getDecoder().decode(encodeStr));
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static LocalDateTime convertStringToLocalDateTime(String localDateTimeStr) {
        if (localDateTimeStr != null) {
            return LocalDateTime.parse(localDateTimeStr, LOCAL_DATE_TIME_FORMATTER);
        }
        return null;
    }

    public static Date convertStringToDate(String localDateTimeStr) throws Exception {
        if (localDateTimeStr != null) {
            try {
                return DATE_TIME_FORMATTER.parse(localDateTimeStr);
            } catch (ParseException ex) {
                throw new Exception(ex);
            }
        }
        return null;
    }
}
