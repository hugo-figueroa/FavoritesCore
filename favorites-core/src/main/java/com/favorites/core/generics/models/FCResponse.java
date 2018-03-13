package com.favorites.core.generics.models;

/**
 * 12/03/18
 */
public class FCResponse<T> {

    private T response;
    private int type = 0;

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
