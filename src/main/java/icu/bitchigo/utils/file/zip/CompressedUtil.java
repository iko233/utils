package icu.bitchigo.utils.file.zip;


import icu.bitchigo.utils.file.EnumFileProcessStatus;
import icu.bitchigo.utils.file.FileUtil;
import icu.bitchigo.utils.lang.NullUtil;
import icu.bitchigo.utils.lang.StringUtil;


/**
 * 压缩包工具类
 *
 * @author iko233
 * @date 2022/05/31
 */
public class CompressedUtil {
    /**
     * 自动判断压缩文件类型并解压
     *
     * @param filePath   文件路径
     * @param targetPath 目标路径
     * @return {@link EnumFileProcessStatus}
     */
    public static EnumFileProcessStatus decompress(String filePath, String targetPath) {
        //根据文件后缀判断文件类型
        String fileExtension = FileUtil.getFileExtension(filePath);
        if (StringUtil.isEmpty(fileExtension)) {
            return EnumFileProcessStatus.UNKNOWN_FILE_TYPE;
        }
        EnumZipFileType fileType = EnumZipFileType.getFileType(fileExtension);
        //判断是否为可识别的文件类型
        if (NullUtil.isNull(fileType)) {
            return EnumFileProcessStatus.UNKNOWN_FILE_TYPE;
        }
        return decompress(filePath, targetPath, fileType);
    }

    /**
     * 解压缩
     *
     * @param filePath        文件路径
     * @param targetPath      目标路径
     * @param enumZipFileType 压缩文件类型
     * @return {@link EnumFileProcessStatus}
     */
    public static EnumFileProcessStatus decompress(String filePath, String targetPath, EnumZipFileType enumZipFileType) {
        return enumZipFileType.getDecompressFunction().apply(filePath, targetPath);
    }

    /**
     * 压缩文件
     *
     * @param filePath        文件路径
     * @param targetPath      目标路径
     * @param enumZipFileType 压缩文件类型
     * @return {@link EnumFileProcessStatus}
     */
    public static EnumFileProcessStatus compress(String filePath, String targetPath, EnumZipFileType enumZipFileType) {
        return enumZipFileType.getCompressFunction().apply(filePath, targetPath);
    }
}
