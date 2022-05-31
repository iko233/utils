package icu.bitchigo.utils.file;

public enum EnumFileProcessStatus {
    /**
     * 操作成功
     */
    SUCCESS("SUCCESS", "操作成功", true),
    /**
     * 文件未找到
     */
    FILE_NOT_FOUND("FILE_NOT_FOUND", "文件未找到", false),
    /**
     * 文件已损坏
     */
    FILE_CORRUPTION("FILE_CORRUPTION", "文件已损坏", false),
    /**
     * io错误
     */
    IO_ERROR("IO_ERROR", "文件流出错", false),
    /**
     * 未知文件类型
     */
    UNKNOWN_FILE_TYPE("UNKNOWN_FILE_TYPE", "未知的文件类型", false),
    /**
     * 无效的路径
     */
    BAD_PATH("BAD_PATH", "无效的路径", false),

    ;
    /**
     * 文件处理状态码
     */
    private final String code;
    /**
     * 提示消息
     */
    private final String message;
    /**
     * 是否成功
     */
    private final boolean success;


    private EnumFileProcessStatus(String code, String message, boolean success) {
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
