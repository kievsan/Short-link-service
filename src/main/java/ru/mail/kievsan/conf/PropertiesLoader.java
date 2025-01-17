package ru.mail.kievsan.conf;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

    public static final String PROPS_FILEPATH = "./src/main/resources/application.properties";
    public static final String PROP_KEY_DEFAULT_LENGTH = "shortlink.length";
    public static final String PROP_KEY_DEFAULT_DAYS = "shortlink.lifetime.days";
    public static final String PROP_KEY_DEFAULT_HOURS = "shortlink.lifetime.hours";

    public static int loadLinkLength() {
        int length = 6;
        try {
            length = Integer.parseInt(loadProperties().getProperty(PROP_KEY_DEFAULT_LENGTH, "6"));
        } catch (Exception ignored) {}
        return length > 5 ? length : 6;
    }

    public static int loadLifetimeDays() {
        int days = 0;
        try {
            days = Integer.parseInt(loadProperties().getProperty(PROP_KEY_DEFAULT_DAYS, "0"));
        } catch (Exception ignored) {}
        return days < 0 || days > 100 ? 1 : days;
    }

    public static int loadLifetimeHours() {
        int hours = 1;
        try {
            hours = Integer.parseInt(loadProperties().getProperty(PROP_KEY_DEFAULT_HOURS, "1"));
        } catch (Exception ignored) {}
        return hours < 0 || hours > 23 ? 1 : hours;
    }

    public static Properties loadProperties() {
        Properties props = new Properties();
        try (InputStream input = new FileInputStream(PROPS_FILEPATH)) {
            props.load(input);  // Загружаем свойства из файла
        } catch (IOException e) {
            props.put(PROP_KEY_DEFAULT_LENGTH, "6");
            props.put(PROP_KEY_DEFAULT_DAYS, "0");
            props.put(PROP_KEY_DEFAULT_HOURS, "1");
        }
        return props;
    }
}
