package com.example.adams.shoppinghub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class PhoneVerificationActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonsendcode;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phoneverification);

        setTitle("Phone Verification");

        buttonsendcode = (Button) findViewById(R.id.buttonsendcode);

        buttonsendcode.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view == buttonsendcode) {
            FirebaseAuth.getInstance().signOut();
            //closing activity
            finish();
            //starting login activity
            Toast.makeText(PhoneVerificationActivity.this, "Logout Successful", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(PhoneVerificationActivity.this, SigninActivity.class));
        }

    }
}
