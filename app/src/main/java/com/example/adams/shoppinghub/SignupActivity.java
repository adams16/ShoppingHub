package com.example.adams.shoppinghub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener{

    EditText name, email, contact, password;

    Button signup;

    TextView haveaccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        setTitle("SignUp");

        name = (EditText) findViewById(R.id.editTextName);
        email = (EditText) findViewById(R.id.editTextEmail);
        password = (EditText) findViewById(R.id.editTextPassword);
        contact = (EditText) findViewById(R.id.editTextContact);


        signup = (Button) findViewById(R.id.buttonsignup);

        haveaccount = (TextView) findViewById(R.id.textViewsignin);

        signup.setOnClickListener(this);
        haveaccount.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == signup)
        {
            Toast.makeText(getApplicationContext(), "Registration Complete", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), SigninActivity.class);
            startActivity(intent);
            Toast.makeText(getApplicationContext(), "Login to Continue", Toast.LENGTH_SHORT).show();
        }
        if (view == haveaccount)
        {
            Toast.makeText(getApplicationContext(), "Login to Continue", Toast.LENGTH_SHORT).show();
            Intent intent1 = new Intent(getApplicationContext(), SigninActivity.class);
            startActivity(intent1);
        }
    }
}
