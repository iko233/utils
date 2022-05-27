package icu.bitchigo.utils.lang;

import org.jetbrains.annotations.Contract;

/**
 * null工具类
 *
 * @author iko233
 * @date 2022/05/27
 */
public class NullUtil {
    /**
     * 是否为null
     */
    public static boolean isNull(Object obj) {
        return obj == null;
    }

    /**
     * 是否存在null
     */
    public static boolean isExistNull(Object... obj) {
        for (Object o : obj) {
            if (isNull(o)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 是否不为null
     */
    public static boolean isNotNull(Object obj) {
        return !isNull(obj);
    }

    /**
     * 是否都不为null
     */
    public static boolean isAllNotNull(Object... obj) {
        for (Object o : obj) {
            if (isNull(o)) {
                return false;
            }
        }
        return true;
    }


}
