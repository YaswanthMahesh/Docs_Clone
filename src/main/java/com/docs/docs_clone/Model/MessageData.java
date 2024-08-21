package com.docs.docs_clone.Model;

public class MessageData {
    private String message;
    private String id;

    public MessageData(String message, String id) {
        this.message = message;
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MessageData{" +
                "message='" + message + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}