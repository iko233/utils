package icu.bitchigo.utils.file;

public enum FileProcessStatus {
    SUCCESS("SUCCESS", "操作成功",true),
    FILE_NOT_FOUND("FILE_NOT_FOUND","文件未找到",false),
    FILE_CORRUPTION("FILE_CORRUPTION","文件已损坏",false),
    IO_ERROR("IO_ERROR","文件流出错",false),
    UNKNOWN_FILE_TYPE("UNKNOWN_FILE_TYPE","未知的文件类型",false),
    BAD_PATH("BAD_PATH","无效的路径",false),

    ;
    private final String code;
    private final String message;

    private final boolean success;


    private FileProcessStatus(String code, String message,boolean success) {
        this.code = code;
        this.message = message;
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }

    public boolean isSuccess() {
        return success;
    }
}
