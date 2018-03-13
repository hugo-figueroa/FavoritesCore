package com.favorites.core.generics.interfaces;

import com.favorites.core.generics.models.FCError;
import com.favorites.core.generics.models.FCResponse;

/**
 * 12/03/18
 */
public interface OnFCListener<T> {

    void onResponse(FCResponse<T> response);
    void onError(FCError fcError);

}
