package icu.bitchigo.utils.lang;

import java.text.Collator;
import java.util.Locale;

public class CharacterUtil {
    public static char toUpperCase(char c) {
        return Character.toUpperCase(c);
    }

    public static char toLowerCase(char c) {
        return Character.toLowerCase(c);
    }

    public static int sortChineseRule(char c1, char c2) {
        return sortRule(Locale.CHINA, c1, c2);
    }

    public static int sortDefaultRule(char c1, char c2) {
        return sortRule(Locale.getDefault(), c1, c2);
    }

    public static int sortRule(Locale locale, char c1, char c2) {
        return Collator.getInstance(locale).compare(c1, c2);
    }
}
