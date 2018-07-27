package com.sap.gslibrary.entity;

public class Result<T> {
   
	/** status code */
    private Integer code;
    
    /** error message */
    private String msg;

    /** success data */
    private T data;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
    
}
