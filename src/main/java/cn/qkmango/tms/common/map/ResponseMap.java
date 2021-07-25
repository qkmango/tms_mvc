package cn.qkmango.tms.common.map;

import java.util.HashMap;

public class ResponseMap extends HashMap<String, Object> {

    public void setSuccess(boolean flag) {
        this.put("success",flag);
    }

    public void setMessage(String message) {
        this.put("message",message);
    }

    public void setData(Object data) {
        this.put("data",data);
    }

}