package icu.bitchigo.utils.lang;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    private static final String CHINESE_DATE_AND_TIME_STANDER_FORMAT = "yyyy年MM月dd日 HH时mm分ss秒";

    private static final String CHINESE_DATE_STANDER_FORMAT = "yyyy年MM月dd日";

    private static final String DATE_AND_TIME_STANDER_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private static final String DATE_STANDER_FORMAT = "yyyy-MM-dd";

    /**
     * 日期格式化成字符串
     *
     * @param date   日期
     * @param format 格式
     * @return {@link String}
     */
    public static String DateFormatToString(Date date, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }


    /**
     * 字符串格式化成日期
     *
     * @param format 格式
     * @param date   日期
     * @return {@link Date}
     */
    public static Date StringFormatToDate(String format,String date) {
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
