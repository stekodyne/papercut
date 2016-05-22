package com.stekodyne;

/**
 * Created by steffen on 5/21/16.
 */
public class Constants {
    public static String A4_COLOR_DOUBLE = "a4.color.double";
    public static String A4_COLOR_SINGLE = "a4.color.single";
    public static String A4_BW_DOUBLE = "a4.bw.double";
    public static String A4_BW_SINGLE = "a4.bw.single";
    public static String QUEUE_FILE_LOCATION = "queue.file.location";
    public static String QUEUE_FILE_NAME = "queue.file.name";
    public static String LANGUAGE = "locale.language";
    public static String COUNTRY = "locale.country";

    public enum Paper {
        A4 ("a4");

        private final String name;

        Paper(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
