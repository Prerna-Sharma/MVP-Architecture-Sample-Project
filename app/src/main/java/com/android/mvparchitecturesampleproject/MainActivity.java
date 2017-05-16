package com.android.mvparchitecturesampleproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MVP_Main.ViewOperations, View.OnClickListener {
    private LoginPresenter loginPresenter;
    private EditText editTextName, editTextPassword;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize views
        editTextName = (EditText) findViewById(R.id.editText_username);
        editTextPassword = (EditText) findViewById(R.id.editText_password);
        buttonSubmit = (Button) findViewById(R.id.btn_login);

        // Initialize presenter class
        loginPresenter = new LoginPresenter(this);

        //Implementing OnClickListener on button
        buttonSubmit.setOnClickListener(this);
    }

    /**
     * Called when a view has been clicked.
     * It gets username and password from user and sends that data
     * to the loginPresenter for background process of checking whether data is valid or not.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        String userName = editTextName.getText().toString();
        String password = editTextPassword.getText().toString();
        loginPresenter.getLogin(userName, password);
    }

    /**
     * Called when username and password provided is correct.
     */
    @Override
    public void loginSuccess() {
        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
    }

    /**
     * Called when username and password provided is incorrect.
     */
    @Override
    public void loginFailed() {
        Toast.makeText(this, "Failure", Toast.LENGTH_SHORT).show();
    }

    /**
     * Called when user has provided any data in editText.
     */
    @Override
    public void showToast() {
        Toast.makeText(this, "Invalid Login!", Toast.LENGTH_SHORT).show();
    }
}
