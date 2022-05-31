package icu.bitchigo.utils.file.zip;

import icu.bitchigo.utils.file.EnumFileProcessStatus;
import icu.bitchigo.utils.lang.StringUtil;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipInputStream;

class ZipFileUtil {

    public static EnumFileProcessStatus decompress(String sourcePath, String targetPath) {
        //判断路径是否为空
        if (StringUtil.isExistEmpty(sourcePath, targetPath)) {
            return EnumFileProcessStatus.BAD_PATH;
        }
        File destDir = new File(targetPath);
        byte[] buffer = new byte[1024];
        ZipInputStream zis = null;
        try {
            zis = new ZipInputStream(new FileInputStream(sourcePath));
        } catch (FileNotFoundException e) {
            return EnumFileProcessStatus.FILE_NOT_FOUND;
        }
        ZipEntry zipEntry = null;
        try {
            zipEntry = zis.getNextEntry();
            while (zipEntry != null) {
                File destFile = new File(targetPath, zipEntry.getName());
                String destDirPath = destDir.getCanonicalPath();
                String destsourcePath = destFile.getCanonicalPath();
                if (!destsourcePath.startsWith(destDirPath + File.separator)) {
                    return EnumFileProcessStatus.IO_ERROR;
                }
                FileOutputStream fos = new FileOutputStream(destFile);
                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                fos.close();
                zipEntry = zis.getNextEntry();
            }
        } catch (ZipException e) {
            //todo log
            return EnumFileProcessStatus.FILE_CORRUPTION;
        } catch (IOException e) {
            //todo log
            return EnumFileProcessStatus.IO_ERROR;
        } finally {
            try {
                zis.closeEntry();
                zis.close();
            } catch (IOException e) {
                return EnumFileProcessStatus.IO_ERROR;
            }
        }
        return EnumFileProcessStatus.SUCCESS;
    }

    public static EnumFileProcessStatus compress(String sourcePath, String targetPath) {
        return EnumFileProcessStatus.SUCCESS;
    }

}
