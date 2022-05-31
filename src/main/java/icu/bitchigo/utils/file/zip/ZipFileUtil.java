package icu.bitchigo.utils.file.zip;

import icu.bitchigo.utils.file.FileProcessStatus;
import icu.bitchigo.utils.lang.StringUtil;
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipInputStream;

public class ZipFileUtil {

    public static FileProcessStatus decompress(String filePath, String targetPath) {
        //判断路径是否为空
        if (StringUtil.isAllNotEmpty(filePath,targetPath)){
            return FileProcessStatus.BAD_PATH;
        }
        File destDir = new File(targetPath);
        byte[] buffer = new byte[1024];
        ZipInputStream zis = null;
        try {
            zis = new ZipInputStream(new FileInputStream(filePath));
        } catch (FileNotFoundException e) {
            return FileProcessStatus.FILE_NOT_FOUND;
        }
        ZipEntry zipEntry = null;
        try {
            zipEntry = zis.getNextEntry();
            while (zipEntry != null) {
                File destFile = new File(targetPath, zipEntry.getName());
                String destDirPath = destDir.getCanonicalPath();
                String destFilePath = destFile.getCanonicalPath();
                if (!destFilePath.startsWith(destDirPath + File.separator)) {
                    return FileProcessStatus.IO_ERROR;
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
            return FileProcessStatus.FILE_CORRUPTION;
        } catch (IOException e) {
            //todo log
            return FileProcessStatus.IO_ERROR;
        } finally {
            try {
                zis.closeEntry();
                zis.close();
            } catch (IOException e) {
                return FileProcessStatus.IO_ERROR;
            }
        }
        return FileProcessStatus.SUCCESS;
    }

    public static FileProcessStatus compress(String filePath, String targetPath) {
        return FileProcessStatus.SUCCESS;
    }
}
