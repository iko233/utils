package icu.bitchigo.utils.lang;

import java.util.Random;

public class RandomUtil {
    public static Long number(Long min, Long max) {
        return new Random().nextLong(max - min) + min;
    }

    public static String numberString(Long min, Long max, int length) {
        return String.format("%0" + length + "d", number(min, max));
    }

    public static String numberString(Long min, Long max) {
        return String.format("%d", number(min, max));
    }
}
