package cn.jt.common.vo;

/**
 * 京淘商城自定义响应结�?
 */
public class SysResult {
    // 响应业务状�??
    /*
     * 200	成功
     * 201	错误
     * 400	参数错误
     */
    private Integer status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;

    public static SysResult build(Integer status, String msg, Object data) {
        return new SysResult(status, msg, data);
    }

    public static SysResult ok(Object data) {
        return new SysResult(data);
    }

    public static SysResult ok() {
        return new SysResult(null);
    }

    public SysResult() {

    }

    public static SysResult build(Integer status, String msg) {
        return new SysResult(status, msg, null);
    }

    public SysResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public SysResult(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

    public Boolean isOK() {
        return this.status == 200;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
