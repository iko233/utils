package icu.bitchigo.utils.file.zip;


import icu.bitchigo.utils.file.FileProcessStatus;
import icu.bitchigo.utils.file.FileUtil;
import icu.bitchigo.utils.lang.NullUtil;
import icu.bitchigo.utils.lang.StringUtil;

import java.util.function.BiFunction;

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
     * @return {@link FileProcessStatus}
     */
    public static FileProcessStatus decompress(String filePath, String targetPath) {
        //判断文件类型根据文件后缀
        String fileExtension = FileUtil.getFileExtension(filePath);
        if (StringUtil.isEmpty(fileExtension)) {
            return FileProcessStatus.UNKNOWN_FILE_TYPE;
        }
        EnumFileType fileType = EnumFileType.getFileType(fileExtension);
        //判断是否为可识别的文件类型
        if (NullUtil.isNull(fileType)) {
            return FileProcessStatus.UNKNOWN_FILE_TYPE;
        }
        return decompress(filePath, targetPath, fileType);
    }

    /**
     * 解压缩
     *
     * @param filePath     文件路径
     * @param targetPath   目标路径
     * @param enumFileType 压缩文件类型
     * @return {@link FileProcessStatus}
     */
    public static FileProcessStatus decompress(String filePath, String targetPath, EnumFileType enumFileType) {
        return enumFileType.decompressFunction.apply(filePath, targetPath);
    }

    /**
     * 压缩文件
     *
     * @param filePath     文件路径
     * @param targetPath   目标路径
     * @param enumFileType 压缩文件类型
     * @return {@link FileProcessStatus}
     */
    public static FileProcessStatus compress(String filePath, String targetPath, EnumFileType enumFileType) {
        return enumFileType.compressFunction.apply(filePath, targetPath);
    }


    /**
     * 枚举压缩文件类型
     *
     * @author iko233
     * @date 2022/05/31
     */
    public enum EnumFileType {

        ZIP("zip", ".zip", ZipFileUtil::decompress, ZipFileUtil::compress),

        ;

        private final String type;
        private final String suffix;
        private final BiFunction<String, String, FileProcessStatus> decompressFunction;
        private final BiFunction<String, String, FileProcessStatus> compressFunction;

        public static EnumFileType getFileType(String type) {
            if (StringUtil.isEmpty(type)) {
                return null;
            }
            type = type.contains(".") ? type : '.' + type;
            for (EnumFileType enumFileType : values()) {
                if (StringUtil.toLowerCase(type).equals(enumFileType.suffix)) {
                    return enumFileType;
                }
            }
            return null;
        }

        private EnumFileType(final String type, final String suffix, BiFunction<String, String, FileProcessStatus> decompressFunction, BiFunction<String, String, FileProcessStatus> compressFunction) {
            this.type = type;
            this.suffix = suffix;
            this.decompressFunction = decompressFunction;
            this.compressFunction = compressFunction;
        }

        public String getType() {
            return type;
        }

        public String getSuffix() {
            return suffix;
        }

        public BiFunction<String, String, FileProcessStatus> getDecompressFunction() {
            return decompressFunction;
        }

        public BiFunction<String, String, FileProcessStatus> getCompressFunction() {
            return compressFunction;
        }
    }
}
