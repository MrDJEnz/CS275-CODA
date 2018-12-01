package com.devteam.coda.coda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private static EditText email;
    private EditText password;
    private CardView bLogin;
    private TextView info;
    private TextView register;

    private int counter = 5;

    public static String getUsername() {
        return email.getText().toString();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
//        getSupportActionBar().hide();

        email = (EditText)findViewById(R.id.editEmail);
        password = (EditText)findViewById(R.id.editPassword);
        register = (TextView) findViewById(R.id.register);
        bLogin = (CardView) findViewById(R.id.bLogin);
        info = (TextView)findViewById(R.id.textInfo);


        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateLogin(email.getText().toString(), password.getText().toString());
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(registerIntent);
            }
        });
    }

    public void validateLogin(String userName, String userPassword) {
        if ((userName.equals("test")) && (userPassword.equals("1234"))) {
            Intent homeIntent = new Intent(LoginActivity.this, HomeActivity.class);

            startActivity(homeIntent);
        } else {
            counter--;

            info.setText("No. of attempts remaining: " + String.valueOf(counter));




            if (counter == 0) {
                bLogin.setEnabled(false);
            }
        }
    }
}
