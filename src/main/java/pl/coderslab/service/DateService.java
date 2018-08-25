package pl.coderslab.service;

import java.sql.Timestamp;
import java.util.Calendar;

public class DateService {

    public static Timestamp currentTimeToDb() {
        Calendar calendar = Calendar.getInstance();
        return new Timestamp(calendar.getTimeInMillis());
    }
}
