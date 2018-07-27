package com.sap.gslibrary.enums;

public enum BookResultEnum {
    UNKONWN_ERROR(-1, "Unknown Error!"),
    SUCCESS(0, "Success"),
    BOOK_UNAVAILABLE(100, "Book is unavailable!"),
    BOOK_NOT_FOUND(101, "Book is not found!"),

    ;

    private Integer code;

    private String msg;

    BookResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
