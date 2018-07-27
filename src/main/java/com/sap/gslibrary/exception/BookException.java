package com.sap.gslibrary.exception;

import com.sap.gslibrary.enums.BookResultEnum;

public class BookException extends RuntimeException{
    
	/**
	 * default serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer code;

    public BookException(BookResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
