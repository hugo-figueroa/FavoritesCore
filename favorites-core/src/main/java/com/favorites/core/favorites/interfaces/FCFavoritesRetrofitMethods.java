package com.favorites.core.favorites.interfaces;

import com.favorites.core.favorites.models.Favorites;
import com.favorites.core.generics.utils.FCConstants;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * 12/03/18
 */
public interface FCFavoritesRetrofitMethods {

    //********************************       getFavorites        ***********************************
    @Headers("Content-Type: application/json")
    @GET(FCConstants.GET_FAVORITES)
    Call<List<Favorites>> getFavorites();

}
