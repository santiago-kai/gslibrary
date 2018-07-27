package com.sap.gslibrary.utils;

import com.sap.gslibrary.entity.Result;

public class ResultUtil {

    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static Result success(Object object) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("SUCCESS");      
        result.setData(object);
        return result;
    }

    @SuppressWarnings("rawtypes")
	public static Result success() {
        return success(null);
    }

    @SuppressWarnings("rawtypes")
	public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
