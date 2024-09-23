package shop.mtcoding.filmtalk.core.util;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;

public class TimeFormatter {

    public static String commentTimeFormat(Timestamp dbTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dbTime.toLocalDateTime().format(formatter);
    }
}
