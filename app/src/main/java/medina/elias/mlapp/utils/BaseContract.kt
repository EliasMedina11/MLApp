package medina.elias.mlapp.utils;

import android.support.annotation.NonNull;
import android.support.annotation.StringRes;


public interface BaseContract {

    interface Presenter {
        /**
         * Clear any data that is held by the presenter.
         */
        fun dispose()
    }

    interface View {

        /**
         * Basic loading overlay to be show or not.
         * @param showLoading Whether should show loading indicator or not
         */
        fun showLoading(showLoading: Boolean)
    }
}
