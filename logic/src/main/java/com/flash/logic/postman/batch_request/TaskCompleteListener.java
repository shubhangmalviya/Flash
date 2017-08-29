package com.flash.logic.postman.batch_request;

public interface TaskCompleteListener<TOKEN, RESPONSE> {

    /**
     * Informs about the success of the task.
     * @param token the token that was sent with this request.
     * @param data the completed task data.
     */
    void onTaskSuccess(TOKEN token, RESPONSE data);

    /**
     * Notifies the caller about the failure of the Task.
     * @param token the token that was sent with this request.
     * @param message the failure message.
     * @return This method should return true if the caller wan'ts the next task to be performed, false otherwise.
     */
    boolean onTaskFailure(TOKEN token, String message);

}
