package com.flash.logic.postman.collection;

public class ErrorResponse {

    private final String mMessage;
    private final Throwable mThrowable;
    private final int mCode;

    public ErrorResponse(String message, int code, Throwable throwable) {
        mMessage = message;
        mCode = code;
        mThrowable = throwable;
    }

    public String getMessage() {
        return mMessage;
    }

    public Throwable getThrowable() {
        return mThrowable;
    }
}
