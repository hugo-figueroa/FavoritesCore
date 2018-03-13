package com.favorites.core.generics.interfaces;

import com.favorites.core.generics.models.FCError;
import com.favorites.core.generics.models.FCResponse;

/**
 * 12/03/18
 */
public interface FCContract {

    interface View<T> {
        void showResponse(FCResponse<T> response);
        void showError(FCError fcError);
    }
}
