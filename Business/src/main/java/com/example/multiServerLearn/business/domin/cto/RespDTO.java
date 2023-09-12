package com.example.multiServerLearn.business.domin.cto;

/**
 *
 * 统一返回
 */
public class RespDTO<T> {

    private Integer code;
    private boolean success = false;
    private String msg;
    private T data;

    public RespDTO(){
    }

    public RespDTO(Integer code, boolean success, String msg, T data)
    {
        this.code = code;
        this.success = success;
        this.msg = msg;
        this.data = data;
    }

    public RespDTO(T data){
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("RespDTO{");
        sb.append("sussess=").append(success);
        sb.append(", code='").append(code).append('\'');
        sb.append(", msg='").append(msg).append('\'');
        sb.append(", data=").append(data);
        return sb.toString();
    }
}
