package com.example.newopedia;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login_Form extends AppCompatActivity {
    EditText txtemail,txtpassword;
    Button btnLogin,btnreg;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__form);

        txtemail = (EditText) findViewById(R.id.email_login);
        txtpassword = (EditText) findViewById(R.id.password);
        btnLogin= (Button) findViewById(R.id.login);
        btnreg = (Button) findViewById(R.id.goreg);
        auth = FirebaseAuth.getInstance();


        auth = FirebaseAuth.getInstance();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = txtemail.getText().toString();
                final String password = txtpassword.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }


                auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Login_Form.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (!task.isSuccessful()) {

                                    Log.e( "error", "onComplete: Failed=" + task.getException().getMessage());
                                    if (password.length() < 6) {
                                        txtpassword.setError(getString(R.string.minimum_password));
                                    } else {
                                        Toast.makeText(Login_Form.this, getString(R.string.auth_failed), Toast.LENGTH_LONG).show();
                                    }
                                } else {
                                    if(email.equals("adiramadhan.admin@gmail.com")){
                                        Intent intent = new Intent(Login_Form.this, MainActivity.class);
                                        startActivity(intent);
                                        finish();

                                    }else{
                                        Intent intent = new Intent(Login_Form.this, home.class);
                                        startActivity(intent);
                                        finish();
                                    }

                                }
                            }
                        });
            }
        });

        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Sign_up.class));
            }
        });
    }


    }









