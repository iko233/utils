package icu.bitchigo.utils.lang;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    private static final String CHINESE_DATE_AND_TIME_STANDER_FORMAT = "yyyy年MM月dd日 HH时mm分ss秒";

    private static final String CHINESE_DATE_STANDER_FORMAT = "yyyy年MM月dd日 HH时mm分ss秒";

    private static final String DATE_AND_TIME_STANDER_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private static final String DATE_STANDER_FORMAT = "yyyy-MM-dd";

    public static String DateFormatToString(Date date, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }

    public static Date StringFormatToDate(String date, String format) {
        if (StringUtils.isEmpty(date)){
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        try {
            return simpleDateFormat.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }
}
