package com.jeff.common.base;

/**
 * 基礎枚舉類
 */
public enum BaseEnum {
    /**
     *後台處理成功
     */
    SUCCESS("後台處理成功！",200),
    /**
     *後台處理失敗
     */
    FAIL("後台處理失敗！",100),
    /**
     *資源沒有找到
     */
    RESOURCE_NOT_FOUND("資源沒有找到",101),
    /**
     * 數組越界了！
     */
    INDEX_OUT_BOUNDS("數組越界了！",102),
    /**
     * 系統錯誤，未知的錯誤
     */
    SYSTEM_ERROR("系統錯誤，未知的錯誤!",103),
    /**
     * 空指針錯誤
     */
    NULL_POINTER("空指針異常！",104),
    /**
     * IO異常
     */
    IO_EXCEPTION("IO異常！",105),
    /**
     * 未知的方法
     */
    NO_SUCH_METHOD("找不到方法，未知的方法",106),
    /**
     * 類型轉換錯誤
     */
    CLASS_CAST("類型轉換出錯，請檢查",107),
    /**
     * 文件未找到錯誤
     */
    FILE_NOT_FOUND("文件沒有找到，請確認文件位置！",108),
    /**
     * 字符串轉換数字異常
     */
    NUMBER_FORMAT("字符串轉換数字出錯了!",109),
    /**
     * 操作數據庫錯誤
     */
    SQL_EXCEPTION("操作數據庫出錯了!",110),
    /**
     * 傳遞的參數出錯了
     */
    ILLEGAL_ARGUMENT("傳遞的參數出錯了！",111),
    /**
     * 堆棧溢出錯誤
     */
    STACK_OVERFLOW("棧溢出了！",112),
    /**
     * 用戶未註冊
     */
    USER_UNREGISTERED("用戶未註冊",113),
    /**
     * 用戶已註冊
     */
    USER_REGISTERED("用戶已註冊",114),
    /**
     * 用戶名或密碼錯誤
     */
    PASSWORD_ERROR("用戶名或密碼錯誤！",115),
    /**
     * 驗證碼發送失敗
     */
    SEND_FAIL("驗證碼發送失敗",116),
    /**
     * 缺少參數或值為空
     */
    PARAMETER_IS_NULL("缺少參數或值為空",117),
    /**
     * 參數不合法
     */
    PARAMETER_IS_WRONGFUL("參數不合法",118),
    /**
     * 無效的Token
     */
    INVALID_TOKEN("無效的Token",119),
    /**
     * 無操作權限
     */
    NO_OPERATION_AUTHORITY("無操作權限",120),
    /**
     * 自定義異常
     */
    CUSTOMIZE_EXCEPTION("自定義異常，請檢查",121),
    /**
     * token過期了，請重新登錄!
     */
    LOGIN_AGAIN("token過期了，請重新登錄!",122),
    /**
     * 400錯誤
     */
    BAD_REQUEST("Bad Request!",400),
    /**
     * 405錯誤
     */
    METHOD_NOT_ALLOWED("Method Not Allowed! 有可能是接口類型錯誤！",405),
    /**
     * 500錯誤
     */
    INTERNAL_SERVER_ERROR("Internal Server Error",500),
    /**
     * 404錯誤攔截
     */
    NO_HANDLER("這個頁面石沉大海了！接口沒找到",404);

    private String msg;

    private int index;

    BaseEnum(String msg, int index) {
        this.msg = msg;
        this.index = index;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

}
