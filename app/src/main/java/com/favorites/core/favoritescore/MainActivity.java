package com.favorites.core.favoritescore;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.favorites.core.favorites.FCFavoritesView;
import com.favorites.core.generics.interfaces.OnFCListener;
import com.favorites.core.generics.models.FCError;
import com.favorites.core.generics.models.FCResponse;
import com.favorites.core.generics.network.FCRequestType;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, OnFCListener {

    private Button btnFavorites;
    private FCFavoritesView fcFavoritesView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fcFavoritesView = FCFavoritesView.getInstance();

        btnFavorites = findViewById(R.id.btnFavorites);
        btnFavorites.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnFavorites:
                fcFavoritesView.setOnFCListener(this);
                fcFavoritesView.getFavorites();
                break;
        }
    }

    @Override
    public void onResponse(FCResponse response) {
        switch (response.getType()) {
            case FCRequestType.GET_FAVORITES:
                showMessage("Favoritos obtenidos con éxito");
                break;
        }
    }

    @Override
    public void onError(FCError fcError) {
        switch (fcError.getType()) {
            case FCRequestType.GET_FAVORITES:
                showMessage("Error al obtener Favoritos");
                break;
        }
    }

    public void showMessage(String message) {
        View view = findViewById(android.R.id.content);
        Snackbar.make(view, message, Snackbar.LENGTH_LONG)
                .show();
    }
}
