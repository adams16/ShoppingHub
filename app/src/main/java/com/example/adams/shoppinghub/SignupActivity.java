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

public class SignupActivity extends AppCompatActivity implements View.OnClickListener{

    private Button buttonsignup;

    private EditText editTextName1;
    private EditText editTextEmail1;
    private EditText editTextPassword1;
    private EditText editTextContact1;

    private TextView textViewsignin;

    private ProgressDialog progressDialog1;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        setTitle("SignUp");

        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() != null)
        {
            finish();
            Intent intent2 = new Intent(SignupActivity.this,SendcodeActivity.class);
            startActivity(intent2);
        }

        progressDialog1 = new ProgressDialog(this);

        editTextName1 = (EditText) findViewById(R.id.editTextName);
        editTextEmail1 = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword1 = (EditText) findViewById(R.id.editTextPassword);
        editTextContact1 = (EditText) findViewById(R.id.editTextContact);


        buttonsignup = (Button) findViewById(R.id.buttonsignup);

        textViewsignin = (TextView) findViewById(R.id.textViewsignin);

        buttonsignup.setOnClickListener(this);
        textViewsignin.setOnClickListener(this);
    }

    private void registerUser()
    {
        String name = editTextName1.getText().toString().trim();
        String email = editTextEmail1.getText().toString().trim();
        String password = editTextPassword1.getText().toString().trim();
        String contact = editTextContact1.getText().toString().trim();

        if (editTextName1.getText().length() == 0)
        {
            editTextName1.setError("Please Enter the Name");
            return;
        }
        if (editTextEmail1.getText().length() == 0)
        {
            editTextEmail1.setError("Please Enter the Email");
            return;
        }
        if (editTextContact1.getText().length() == 0)
        {
            editTextContact1.setError("Please Enter the Contact Number");
            return;
        }
        if (editTextPassword1.getText().length() == 0)
        {
            editTextPassword1.setError("Please Enter the Password");
            return;
        }


        progressDialog1.setMessage("Registering User...");
        progressDialog1.show();

        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            Toast.makeText(SignupActivity.this, "Registration Complete",Toast.LENGTH_SHORT).show();
                            Intent intent1 = new Intent(SignupActivity.this,SendcodeActivity.class);
                            startActivity(intent1);

                        }
                        else
                        {
                            Toast.makeText(SignupActivity.this, "Registration Failed",Toast.LENGTH_SHORT).show();
                        }
                        progressDialog1.dismiss();
                    }


                });
    }

    @Override
    public void onClick(View view) {
        if (view == buttonsignup)
        {
            registerUser();
        }
        if (view == textViewsignin)
        {
            Toast.makeText(getApplicationContext(), "Login to Continue", Toast.LENGTH_SHORT).show();
            Intent intent1 = new Intent(getApplicationContext(), SigninActivity.class);
            startActivity(intent1);
        }
    }
}
