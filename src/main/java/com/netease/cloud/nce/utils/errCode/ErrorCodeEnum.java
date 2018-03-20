package com.netease.cloud.nce.utils.errCode;

/**
 * Created by hzzhouxiang on 2018/2/28.
 */
public enum ErrorCodeEnum {

    Success("Success", "Success", "处理成功", 200),

    InvalidFormat("InvalidFormat", "The format of the input parameter %s is illegal.", "参数 %s 的格式非法", 400),
    InvalidBodyFormat("InvalidFormat", "The format of the request body is illegal.", "请求体格式非法", 400),
    ParameterNull("ParameterNull", "Parameter null", "参数为空", 400),
    ParameterError("ParameterError", "Parameter %s error.", "参数%s错误", 400);

    private String code;
    private String enMsg;
    private String msg;
    private int statusCode;

    private ErrorCodeEnum(String code, String enMsg, String msg, int statusCode) {
        this.code = code;
        this.enMsg = enMsg;
        this.msg = msg;
        this.statusCode = statusCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getEnMsg() {
        return enMsg;
    }

    public void setEnMsg(String enMsg) {
        this.enMsg = enMsg;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

}
