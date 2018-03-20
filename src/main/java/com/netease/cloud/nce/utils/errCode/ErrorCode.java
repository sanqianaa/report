package com.netease.cloud.nce.utils.errCode;

import com.netease.libs.holder.WebContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hzzhouxiang on 2018/2/28.
 */
public class ErrorCode {

    private static Logger logger = LoggerFactory.getLogger(ErrorCode.class);

    public static final String SUCCESS = "Success";

    private String code;
    private String message;
    private String enMessage;
    private int statusCode;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        HttpServletRequest request = WebContextHolder.getRequest();
        if (null != request && "zh".equals(request.getHeader("X-163-AcceptLanguage"))) {
            return message;
        } else {
            return enMessage;
        }
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    protected ErrorCode(ErrorCodeEnum errorCodeEnum, String... args) {
        try {
            this.statusCode = errorCodeEnum.getStatusCode();
            this.code = errorCodeEnum.getCode();
            this.message = String.format(errorCodeEnum.getMsg(), args);
            this.enMessage = String.format(errorCodeEnum.getEnMsg(), args);
        } catch (Exception e) {
            logger.error("ErrorCode 中string.format异常, 请立即检查!", e);
            this.message = errorCodeEnum.getEnMsg();
        }
    }
}
