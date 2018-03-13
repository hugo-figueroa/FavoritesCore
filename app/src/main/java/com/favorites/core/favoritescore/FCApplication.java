package com.favorites.core.favoritescore;

import android.app.Application;

import com.favorites.core.favorites.FCFavoritesView;

/**
 * 13/03/18
 */
public class FCApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FCFavoritesView.getInstance().initialize(this);
    }

}
