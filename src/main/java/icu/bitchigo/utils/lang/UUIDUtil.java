package icu.bitchigo.utils.lang;

import java.util.UUID;

public class UUIDUtil {

    public static String getSimpleUUIDString() {
        return getUUIDString().replace("-", "");
    }

    public static String getUUIDString() {
        return getUUID().toString();
    }

    public static UUID getUUID() {
        return UUID.randomUUID();
    }

}
