package com.codepath.tejen.lab1_cloningaloginscreens;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText etEmail;
    EditText etPassword;
    Button btnLogin;
    TextWatcher tw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        tw = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                onFieldsChanged();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        etEmail.addTextChangedListener(tw);
        etPassword.addTextChangedListener(tw);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isFormFilled())
                    Toast.makeText(getApplicationContext(), "sorry not sorry", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean isFormFilled() {
        return etEmail.getText().toString().length() > 0 && etPassword.getText().toString().length() > 0;
    }

    private void onFieldsChanged() {
        if(isFormFilled()) {
            btnLoginEnable();
        } else {
            btnLoginDisable();
        }
    }

    private void btnLoginEnable() {
        btnLogin.setAlpha(1);
    }

    private void btnLoginDisable() {
        btnLogin.setAlpha((float) 0.4);
    }

}
