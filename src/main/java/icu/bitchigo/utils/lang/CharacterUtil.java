package icu.bitchigo.utils.lang;

import org.jetbrains.annotations.Nullable;

import java.text.Collator;
import java.util.Locale;

public class CharacterUtil {

    /**
     * 字符类型转大写
     */
    public static char toUpperCase(char c) {
        return Character.toUpperCase(c);
    }
    /**
     * 字符类型转小写
     */
    public static char toLowerCase(char c) {
        return Character.toLowerCase(c);
    }

    /**
     * 中文排序规则
     */
    public static int sortByChineseRuler(char c1, char c2) {
        return sortRuler(Locale.CHINA, c1, c2);
    }

    /**
     * 排序规则
     */
    public static int sortRuler(@Nullable Locale locale, char c1, char c2) {
        if (NullUtil.isNull(locale)){
            locale = Locale.getDefault();
        }
        return Collator.getInstance(locale).compare(c1, c2);
    }
}
