package icu.bitchigo.utils.fake;

import icu.bitchigo.utils.lang.UUIDUtil;

public class IDUtil {

    /**
     * 获取uuid
     *
     * @return {@link String}
     */
    public static String UUID() {
        return UUIDUtil.getUUIDString();
    }

    /**
     * 获取简化uuid
     *
     * @return {@link String}
     */
    public static String SimpleUUID() {
        return UUIDUtil.getSimpleUUID();
    }

}
