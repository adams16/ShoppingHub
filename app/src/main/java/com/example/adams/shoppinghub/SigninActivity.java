package com.example.adams.shoppinghub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class SigninActivity extends AppCompatActivity implements View.OnClickListener{

    EditText contact, password;

    Button signin;

    TextView newaccount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        setTitle("SignIn");

        contact = (EditText) findViewById(R.id.editTextContact);
        password = (EditText) findViewById(R.id.editTextPassword);

        signin = (Button) findViewById(R.id.buttonsignin);

        newaccount = (TextView) findViewById(R.id.textViewsignup);

        signin.setOnClickListener(this);
        newaccount.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if(view == signin)
        {
            Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
        if (view == newaccount)
        {
            Toast.makeText(getApplicationContext(), "Create New Account", Toast.LENGTH_SHORT).show();
            Intent intent1 = new Intent(getApplicationContext(), SignupActivity.class);
            startActivity(intent1);
        }

    }
}
