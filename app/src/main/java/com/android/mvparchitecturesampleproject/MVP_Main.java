package com.android.mvparchitecturesampleproject;

/**
 * Place the presenter and view interfaces within a holder
 * Created by Prerna Sharma on 4/26/2017.
 */

public interface MVP_Main {
    /**
     * View in MVP represents the UI components.
     * <p>
     * This interface is implemented by MainActivity.class
     * It contain the reference to Presenter.
     */

    interface ViewOperations {
        void loginSuccess();

        void loginFailed();

        void showToast();
    }

    /**
     * Presenter is a kind of bridge between View and Model.
     * It retrieves data from the Model and returns it formatted to the View.
     * But unlike the typical MVC, it also decides what happens when you interact with the View.
     * <p>
     * Here, this interface is implemented by LoginPresenter.class.
     */

    interface PresenterOperations {
        void getLogin(String username, String password);
    }
}
