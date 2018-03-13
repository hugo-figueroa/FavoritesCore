package com.favorites.core.generics.utils;

/**
 * 13/03/18
 */
public class FCGeneralValidations {

    /**
     * Checks if the responseCode is 200
     *
     * @param responseCode Response code
     * @return Returns true if responseCode is 200, otherwise returns false
     */
    public boolean verifySuccessCode(int responseCode) {
        if (responseCode == 200) {
            return true;
        } else {
            return false;
        }
    }

}
