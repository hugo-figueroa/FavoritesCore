package com.favorites.core.generics.models;

/**
 * 12/03/18
 */
public class FCError {

    private String message = "";
    private int type = 0;

    public FCError() {

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
