package icu.bitchigo.utils.file;

import icu.bitchigo.utils.lang.StringUtil;

import java.io.File;

public class FileUtil {
    public static String getFileExtension(File file) {
        if (file == null) {
            return "";
        }
        String fileName = file.getName();
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        }
        return "";
    }

    public static String getFileExtension(String filePath) {
        if (StringUtil.isEmpty(filePath)){
            return "";
        }
        return getFileExtension(new File(filePath));
    }
}
