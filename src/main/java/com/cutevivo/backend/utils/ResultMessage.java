package com.cutevivo.backend.utils;

public class ResultMessage {
    private boolean result;
    private Object data;
    private String reason;

    public boolean getResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultMessage() {

    }

    public ResultMessage(boolean result, String reason) {
        this.result = result;
        this.reason = reason;
    }

    public ResultMessage(boolean result, Object data, String reason) {
        this.result = result;
        this.data = data;
        this.reason = reason;
    }


}
