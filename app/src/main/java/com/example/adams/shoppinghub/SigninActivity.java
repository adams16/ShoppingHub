package com.example.adams.shoppinghub;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SigninActivity extends AppCompatActivity implements View.OnClickListener{

    private Button buttonsignin;

    private EditText editTextEmail;
    private EditText editTextPassword;

    private TextView textViewsignup;

    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        setTitle("SignIn");

        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() != null) {
            finish();
            Intent intent3 = new Intent(SigninActivity.this, SendcodeActivity.class);
            startActivity(intent3);
        }

        progressDialog = new ProgressDialog(this);

        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);

        buttonsignin = (Button) findViewById(R.id.buttonsignin);

        textViewsignup = (TextView) findViewById(R.id.textViewsignup);

        buttonsignin.setOnClickListener(this);
        textViewsignup.setOnClickListener(this);
    }

    private void UserLogin() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (editTextEmail.getText().length() == 0) {
            editTextEmail.setError("Please Enter the Email");
            return;
        }
        if (editTextPassword.getText().length() == 0) {
            editTextPassword.setError("Please Enter the Password");
            return;
        }
        progressDialog.setMessage("Signing In...");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()) {
                            Intent intent2 = new Intent(SigninActivity.this, SendcodeActivity.class);
                            startActivity(intent2);
                            finish();
                        } else {
                            Toast.makeText(SigninActivity.this, "SignIn Failed", Toast.LENGTH_SHORT).show();
                        }
                    }

                });
    }


    @Override
    public void onClick(View view) {
        if(view == buttonsignin)
        {
            UserLogin();
        }
        if (view == textViewsignup)
        {
            Toast.makeText(getApplicationContext(), "Create New Account", Toast.LENGTH_SHORT).show();
            Intent intent1 = new Intent(getApplicationContext(), SignupActivity.class);
            startActivity(intent1);
        }

    }
}
