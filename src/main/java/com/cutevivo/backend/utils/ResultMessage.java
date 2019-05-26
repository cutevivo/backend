package com.cutevivo.backend.utils;

public class ResultMessage {
    private boolean result;
    private Object object;
    private String reason;

    public ResultMessage() {

    }

    public ResultMessage(boolean result, String reason) {
        this.result = result;
        this.reason = reason;
    }

    public ResultMessage(boolean result, Object object, String reason) {
        this.result = result;
        this.object = object;
        this.reason = reason;
    }

    public boolean getResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
