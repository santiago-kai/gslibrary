package com.sap.gslibrary.handle;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sap.gslibrary.entity.Result;
import com.sap.gslibrary.exception.BookException;
import com.sap.gslibrary.utils.ResultUtil;

@ControllerAdvice
public class ExceptionHandle {
    
	private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @SuppressWarnings("rawtypes")
	@ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof BookException) {
            BookException bookException = (BookException) e;
            return ResultUtil.error(bookException.getCode(), bookException.getMessage());
        }else if (e instanceof SQLException) {
			return ResultUtil.error(300, SQLException.class.toString());
		}else {
            logger.error("[System abnormal]{}", e);
            return ResultUtil.error(-1, "Unknown Error");
        }
    }
}
