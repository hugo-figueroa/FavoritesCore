package com.favorites.core.favorites;

import android.app.Application;

import com.favorites.core.favorites.controller.FCFavoritesPresenter;
import com.favorites.core.generics.interfaces.FCContract;
import com.favorites.core.generics.interfaces.OnFCListener;
import com.favorites.core.generics.models.FCError;
import com.favorites.core.generics.models.FCResponse;

/**
 * 13/03/18
 * <p>
 * View - Here requests are made to the presenter
 */
public class FCFavoritesView implements FCContract.View {

    private OnFCListener onFCListener;
    private static FCFavoritesView instance = null;
    private FCFavoritesPresenter fcFavoritesPresenter;

    private FCFavoritesView() {
    }

    public synchronized static FCFavoritesView getInstance() {
        if (instance == null) {
            instance = new FCFavoritesView();
        }
        return instance;
    }

    /**
     * Makes a request for get favorites
     */
    public void getFavorites() {
        fcFavoritesPresenter.getFavorites();
    }

    /**
     * Makes a request for get favorites
     */
    public void getFavorites(OnFCListener onFCListener) {
        setOnFCListener(onFCListener);
        fcFavoritesPresenter.getFavorites();
    }

    /**
     * Allows to initiate the injection of dependencies in this class
     *
     * @param application Application context
     */
    public void initialize(Application application) {
        fcFavoritesPresenter = new FCFavoritesPresenter(application);
        fcFavoritesPresenter.setView(this);
    }

    /**
     * Adds a listener to this class to return a response
     *
     * @param onFCListener Listener
     */
    public void setOnFCListener(OnFCListener onFCListener) {
        this.onFCListener = onFCListener;
    }

    /**
     * Returns a successful response
     *
     * @param response Response received
     */
    @Override
    public void showResponse(FCResponse response) {
        onFCListener.onResponse(response);
    }

    /**
     * Returns a failed response
     *
     * @param fcError Class with failed response details
     */
    @Override
    public void showError(FCError fcError) {
        onFCListener.onError(fcError);
    }
}
