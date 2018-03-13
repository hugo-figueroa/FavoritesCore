package com.favorites.core.generics.utils;

import android.content.Context;

import com.favorites.core.R;
import com.favorites.core.generics.models.FCError;

import java.io.IOException;

/**
 * 13/03/18
 */
public class FCUtilities {

    /**
     * Handles a retrofit error response
     *
     * @param context     Application context
     * @param t           Exception object
     * @param requestType Request type
     * @return An error object
     */
    public FCError getOnFailureResponse(Context context, Throwable t, int requestType) {
        FCError fcError = new FCError();
        fcError.setType(requestType);

        if (t instanceof IOException) {
            fcError.setMessage(context.getString(R.string.fc_network_error));
        } else if (t instanceof IllegalStateException) {
            fcError.setMessage(context.getString(R.string.fc_error_serialization));
        } else {
            fcError.setMessage(context.getString(R.string.fc_error_unknown));
        }
        return fcError;
    }

    /**
     * Handles an error response
     *
     * @param context      Application context
     * @param responseCode Response Code
     * @param message      Error message
     * @param fcError      Error Object
     * @return An error object with an error message
     */
    public FCError getErrorByStatusCode(Context context, int responseCode, String message, FCError fcError) {
        switch (responseCode) {
            case 400: //Bad Request
                fcError.setMessage(context.getString(R.string.fc_error_bad_request));
                break;
            case 401: //Unauthorized
                fcError.setMessage(context.getString(R.string.fc_error_unauthorized));
                break;
            case 404: //Not Found
                fcError.setMessage(context.getString(R.string.fc_error_not_found));
                break;
            case 500: // Internal Server Error
                fcError.setMessage(context.getString(R.string.fc_server_error));
                break;
            default:
                fcError.setMessage(message);
                break;
        }
        return fcError;
    }

}
