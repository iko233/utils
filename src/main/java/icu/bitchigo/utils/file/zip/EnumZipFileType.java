package icu.bitchigo.utils.file.zip;

import icu.bitchigo.utils.file.EnumFileProcessStatus;
import icu.bitchigo.utils.lang.StringUtil;

import java.util.function.BiFunction;
/**
 * 枚举压缩文件类型
 *
 * @author iko233
 * @date 2022/05/31
 */
public enum EnumZipFileType {
        ZIP("zip", ".zip", ZipFileUtil::decompress, ZipFileUtil::compress),
        TAR("tar", ".tar", TarFileUtil::decompress, TarFileUtil::compress),
        SevenZip("7z", ".7z", SevenZipFileUtil::decompress, SevenZipFileUtil::compress),
        GZIP("gz", ".gz", GZipFileUtil::decompress, GZipFileUtil::compress),
        TGZ("tgz", "tgz", TGZipFileUtil::decompress, TGZipFileUtil::compress),
        TARGZ("tar.gz", ".tar.gz", TarGZipFileUtil::decompress, TarGZipFileUtil::compress),
        ;

        /**
         * 类型
         */
        private final String type;
        /**
         * 后缀
         */
        private final String suffix;
        /**
         * 解压方法
         */
        private final BiFunction<String, String, EnumFileProcessStatus> decompressFunction;
        /**
         * 压缩方法
         */
        private final BiFunction<String, String, EnumFileProcessStatus> compressFunction;

        /**
         * 获取文件类型
         *
         * @param type 类型
         * @return {@link EnumZipFileType}
         */
        public static EnumZipFileType getFileType(String type) {
            if (StringUtil.isEmpty(type)) {
                return null;
            }
            type = type.contains(".") ? type : '.' + type;
            for (EnumZipFileType enumZipFileType : values()) {
                if (StringUtil.toLowerCase(type).equals(enumZipFileType.suffix)) {
                    return enumZipFileType;
                }
            }
            return null;
        }

        private EnumZipFileType(final String type, final String suffix, BiFunction<String, String, EnumFileProcessStatus> decompressFunction, BiFunction<String, String, EnumFileProcessStatus> compressFunction) {
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

        public BiFunction<String, String, EnumFileProcessStatus> getDecompressFunction() {
            return decompressFunction;
        }

        public BiFunction<String, String, EnumFileProcessStatus> getCompressFunction() {
            return compressFunction;
        }
    }