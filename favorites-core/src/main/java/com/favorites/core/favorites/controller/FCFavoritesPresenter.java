package com.favorites.core.favorites.controller;

import android.content.Context;

import com.favorites.core.favorites.request.FCFavoritesImpl;
import com.favorites.core.generics.interfaces.FCContract;
import com.favorites.core.generics.interfaces.OnFCListener;
import com.favorites.core.generics.models.FCError;
import com.favorites.core.generics.models.FCResponse;

/**
 * 13/03/18
 * <p>
 * Presenter - Here the requests of the view to the model are controlled
 */
public class FCFavoritesPresenter implements OnFCListener {

    private FCContract.View view;
    private FCFavoritesImpl fcFavoritesImpl;

    public FCFavoritesPresenter(Context context) {
        fcFavoritesImpl = new FCFavoritesImpl(context);
        fcFavoritesImpl.setOnFCListener(this);
    }

    /**
     * Makes a request for get favorites
     */
    public void getFavorites() {
        fcFavoritesImpl.getFavorites();
    }

    /**
     * Adds the view layer to the layer presenter in order to return a response
     *
     * @param view View layer
     */
    public void setView(FCContract.View view) {
        this.view = view;
    }

    /**
     * Returns a successful response
     *
     * @param response Response received
     */
    @Override
    public void onResponse(FCResponse response) {
        view.showResponse(response);
    }

    /**
     * Returns a failed response
     *
     * @param fcError Class with failed response details
     */
    @Override
    public void onError(FCError fcError) {
        view.showError(fcError);
    }
}
