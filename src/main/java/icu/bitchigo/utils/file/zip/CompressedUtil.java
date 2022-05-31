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
     * @param sourcePath   文件路径
     * @param targetPath 目标路径
     * @return {@link EnumFileProcessStatus}
     */
    public static EnumFileProcessStatus decompress(String sourcePath, String targetPath) {
        //根据文件后缀判断文件类型
        String fileExtension = FileUtil.getFileExtension(sourcePath);
        if (StringUtil.isEmpty(fileExtension)) {
            return EnumFileProcessStatus.UNKNOWN_FILE_TYPE;
        }
        EnumCompressFileType fileType = EnumCompressFileType.getFileType(fileExtension);
        //判断是否为可识别的文件类型
        if (NullUtil.isNull(fileType)) {
            return EnumFileProcessStatus.UNKNOWN_FILE_TYPE;
        }
        return decompress(sourcePath, targetPath, fileType);
    }

    /**
     * 解压缩
     *
     * @param sourcePath             文件路径
     * @param targetPath           目标路径
     * @param enumCompressFileType 压缩文件类型
     * @return {@link EnumFileProcessStatus}
     */
    public static EnumFileProcessStatus decompress(String sourcePath, String targetPath, EnumCompressFileType enumCompressFileType) {
        return enumCompressFileType.getDecompressFunction().apply(sourcePath, targetPath);
    }

    /**
     * 压缩文件
     *
     * @param sourcePath             文件路径
     * @param targetPath           目标路径
     * @param enumCompressFileType 压缩文件类型
     * @return {@link EnumFileProcessStatus}
     */
    public static EnumFileProcessStatus compress(String sourcePath, String targetPath, EnumCompressFileType enumCompressFileType) {
        return enumCompressFileType.getCompressFunction().apply(sourcePath, targetPath);
    }

    public static EnumFileProcessStatus compress(String sourcePath, EnumCompressFileType enumCompressFileType) {
        return enumCompressFileType.getCompressFunction().apply(sourcePath, null);
    }
}
