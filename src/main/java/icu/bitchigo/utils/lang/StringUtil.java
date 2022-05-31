package icu.bitchigo.utils.lang;

import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.text.Collator;
import java.util.Locale;
import java.util.function.Function;

/**
 * 字符串工具
 *
 * @author bitchigo
 * @date 2022/05/09
 */
public class StringUtil {

    /**
     * 判断字符序列是否为null或者为""
     *
     * @param cs cs
     * @return boolean
     */
    public static boolean isEmpty(final CharSequence cs) {
        return StringUtils.isEmpty(cs);
    }

    public static boolean isExistEmpty(final CharSequence...cs) {
        for (CharSequence c : cs) {
            if (isEmpty(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isAllNotEmpty(final CharSequence...cs){
        return !isExistEmpty(cs);
    }

    /**
     * 判断字符序列是否非null或者不为""
     *
     * @param cs cs
     * @return boolean
     */
    public static boolean isNotEmpty(final CharSequence cs) {
        return StringUtils.isNotEmpty(cs);
    }

    /**
     * 判断两个字符串是否内容相同
     *
     * @param cs1
     * @param cs2
     * @return boolean
     */
    public static boolean equals(final CharSequence cs1, final CharSequence cs2) {
        return StringUtils.equals(cs1, cs2);
    }

    /**
     * 字符串全部转大写
     *
     * @param str str
     * @return {@link String}
     */
    public static String toUpperCase(final String str) {
        if (isEmpty(str)) {
            return str;
        }
        return traverse4StringBuilder(str, CharacterUtil::toUpperCase);
    }

    /**
     * 字符串全部转小写
     *
     * @param str str
     * @return {@link String}
     */
    public static String toLowerCase(final String str) {
        if (isEmpty(str)) {
            return str;
        }
        return traverse4StringBuilder(str, CharacterUtil::toLowerCase);
    }

    public static String toUnderLineCase(final String str, boolean isUpperCase) {
        if (isUpperCase) {
            return toUpperUnderLineCase(str);
        }
        return toLowerUnderLineCase(str);
    }


    public static String toUpperUnderLineCase(final String str) {
        if (isEmpty(str)) {
            return str;
        }
        boolean hasUnderline = str.contains("_");
        if (hasUnderline) {
            return toUpperCase(str);
        }
        String[] strings = StringUtils.splitByCharacterTypeCamelCase(str);
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (String s : strings) {
            String upperString = traverse4StringBuilder(s, CharacterUtil::toUpperCase);
            if (!first) {
                sb.append('_');
            }
            sb.append(upperString);
            first = false;
        }
        return sb.toString();
    }

    public static String toLowerUnderLineCase(final String str) {
        if (isEmpty(str)) {
            return str;
        }
        boolean hasUnderline = str.contains("_");
        if (hasUnderline) {
            return toLowerCase(str);
        }
        String[] strings = StringUtils.splitByCharacterTypeCamelCase(str);
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (String s : strings) {
            String upperString = traverse4StringBuilder(s, CharacterUtil::toLowerCase);
            if (!first) {
                sb.append('_');
            }
            sb.append(upperString);
            first = false;
        }
        return sb.toString();
    }

    public static String traverse4StringBuilder(final String str, Function<Character, Character> function) {
        if (isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            Character character = function.apply(str.charAt(i));
            if(NullUtil.isNotNull(character)) {
                sb.append(character);
            }
        }
        return sb.toString();
    }

    
    public static String buildString(String... args) {
        StringBuilder sb = new StringBuilder();
        for (String arg : args) {
            sb.append(arg);
        }
        return sb.toString();
    }


    public static int sortChineseRule(String str1, String str2) {
        return sortRule(Locale.CHINA,str1,str2);
    }

    public static int sortDefaultRule(String str1, String str2) {
        return sortRule(Locale.getDefault(),str1,str2);
    }

    public static int sortRule(Locale locale, String str1, String str2) {
        return Collator.getInstance(locale).compare(str1, str2);
    }

}
