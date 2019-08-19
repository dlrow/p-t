package com.pt.teacher.helper.dto;


/**
 * Purpose:-
 * This  class holds ResponseMessage(both status code and its corresponding message) to be sent to AA client.
 *
 * @author Priyanshu Raj
 * @version 1.0
 * @since   2019-07-28
 */
public class ResponseMessage {

    /**
     * represent the status code of response that aggregator send's
     */
    private String statusCode;

    /**
     * represent the Message of response that aggregator send's
     */
    private String message;
    

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResponseMessage{" +
                "statusCode='" + statusCode + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}

