package icu.bitchigo.utils.fake;

import icu.bitchigo.utils.lang.UUIDUtil;

public class IDUtil {

    public static String UUID() {
        return UUIDUtil.getUUIDString();
    }

    public static String SimpleUUID() {
        return UUIDUtil.getSimpleUUID();
    }

}
