package icu.bitchigo.utils.lang;

import java.util.Random;

public class RandomUtil {
    private static final Random RANDOM = new Random();

    public static long nextLong() {
        return RANDOM.nextLong();
    }

    public static Long rangeLong(Long min, Long max) {
        return RANDOM.nextLong(max - min) + min;
    }

    public static long nextSignedLong() {
        return nextLong() * (nextBoolean() ? 1 : -1);
    }


    public static int rangeInt(int min, int max) {
        return RANDOM.nextInt(max - min) + min;
    }

    public static int nextInt() {
        return RANDOM.nextInt();
    }

    public static int nextSignedInt() {
        return nextInt() * (nextBoolean() ? 1 : -1);
    }

    public static boolean nextBoolean() {
        return RANDOM.nextBoolean();
    }
}
