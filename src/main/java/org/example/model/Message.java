package org.example.model;

public class Message {

    private int id;

    private String user;

    private String message;

    public Message(int _id, String _user, String _message) {
        id = _id;
        user = _user;
        message = _message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
