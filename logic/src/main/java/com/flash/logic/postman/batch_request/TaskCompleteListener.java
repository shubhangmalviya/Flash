package com.flash.logic.postman.batch_request;

public interface TaskCompleteListener<RESPONSE> {

    void onTaskSuccess(RESPONSE data);

    void onTaskFailure(String message);

}
