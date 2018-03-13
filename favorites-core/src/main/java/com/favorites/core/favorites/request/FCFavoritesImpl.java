package com.favorites.core.favorites.request;

import android.content.Context;

import com.favorites.core.R;
import com.favorites.core.favorites.interfaces.FCFavoritesRetrofitMethods;
import com.favorites.core.favorites.models.Favorites;
import com.favorites.core.generics.interfaces.OnFCListener;
import com.favorites.core.generics.models.FCError;
import com.favorites.core.generics.models.FCResponse;
import com.favorites.core.generics.network.FCRequestType;
import com.favorites.core.generics.network.FCRetrofitManager;
import com.favorites.core.generics.utils.FCGeneralValidations;
import com.favorites.core.generics.utils.FCUtilities;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * 12/03/18
 * <p>
 * Model - Here requests to web services are made
 */
public class FCFavoritesImpl {

    private Context context;

    private OnFCListener onFCListener;
    private FCUtilities fcUtilities;
    private FCGeneralValidations fcGeneralValidations;
    private FCFavoritesRetrofitMethods fcFavoritesRetrofitMethods;
    private Retrofit retrofit;

    public FCFavoritesImpl(Context context) {
        this.context = context;
        fcUtilities = new FCUtilities();
        fcGeneralValidations = new FCGeneralValidations();
        retrofit = FCRetrofitManager.getInstance().getRetrofitFC();
        fcFavoritesRetrofitMethods = retrofit.create(FCFavoritesRetrofitMethods.class);
    }

    /* *********************************************************************************************
     *********************               getFavoriteCards             ******************************
     ***********************************************************************************************/

    /**
     * Get a favorite list usign Retrofit
     */
    public void getFavorites() {
        fcFavoritesRetrofitMethods.getFavorites().enqueue(new Callback<List<Favorites>>() {
            @Override
            public void onResponse(Call<List<Favorites>> call, Response<List<Favorites>> response) {
                getFavoritesResponse(response);
            }

            @Override
            public void onFailure(Call<List<Favorites>> call, Throwable t) {
                onFCListener.onError(fcUtilities.getOnFailureResponse(context, t, FCRequestType.GET_FAVORITES));
            }
        });
    }

    /**
     * Checks whether the server response is successful or error
     *
     * @param response Server response
     */
    public void getFavoritesResponse(Response<List<Favorites>> response) {
        FCError fcError = new FCError();
        fcError.setType(FCRequestType.GET_FAVORITES);
        if (fcGeneralValidations.verifySuccessCode(response.code())) {
            getFavoritesSuccess(response, fcError);
        } else {
            onFCListener.onError(fcUtilities.getErrorByStatusCode(context, response.code(), context.getString(R.string.fc_error_favorites), fcError));
        }
    }

    /**
     * Handles a successful response of the getFavorites method
     *
     * @param response Server response
     * @param fcError  Error Object
     */
    public void getFavoritesSuccess(Response<List<Favorites>> response, FCError fcError) {
        List<Favorites> favoritesList = (List<Favorites>) response.body();
        if (favoritesList != null) {
            FCResponse<List<Favorites>> fcResponse = new FCResponse<>();
            fcResponse.setType(FCRequestType.GET_FAVORITES);
            fcResponse.setResponse(favoritesList);
            onFCListener.onResponse(fcResponse);
        } else {
            fcError.setMessage(context.getString(R.string.fc_error_favorites));
            onFCListener.onError(fcError);
        }
    }

    //**********************************************************************************************

    /**
     * Adds the layer of the presenter to the layer of the model in order to return a response
     *
     * @param onFCListener Presenter layer
     */
    public void setOnFCListener(OnFCListener onFCListener) {
        this.onFCListener = onFCListener;
    }
}
