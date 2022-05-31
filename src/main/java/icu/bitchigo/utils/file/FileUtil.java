package icu.bitchigo.utils.file;

import icu.bitchigo.utils.lang.StringUtil;

import java.io.File;

public class FileUtil {
    /**
     * 获取文件扩展名
     *
     * @param file 文件
     * @return {@link String}
     */
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

    /**
     * 获取文件扩展名
     *
     * @param filePath 文件路径
     * @return {@link String}
     */
    public static String getFileExtension(String filePath) {
        if (StringUtil.isEmpty(filePath)){
            return "";
        }
        return getFileExtension(new File(filePath));
    }
}
