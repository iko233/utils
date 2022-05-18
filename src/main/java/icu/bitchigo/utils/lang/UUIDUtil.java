package icu.bitchigo.utils.lang;

import java.util.UUID;

public class UUIDUtil {

    public String getSimpleUUID() {
        return getUUIDString().replace("-", "");
    }

    public String getUUIDString() {
        return getUUID().toString();
    }

    public UUID getUUID() {
        return UUID.randomUUID();
    }

}
