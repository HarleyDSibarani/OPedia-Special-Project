package com.example.newopedia;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Sign_up extends AppCompatActivity {
    EditText txt_fullname, txt_username, txt_email,txt_password;
    Button btn_register,btn_login;
    RadioButton radioGendermale,radioGenderfemale;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
    String gender ="";
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        txt_fullname = (EditText) findViewById(R.id.full);
        txt_username = (EditText) findViewById(R.id.user);
        txt_email = (EditText) findViewById(R.id.email_login);
        txt_password = (EditText) findViewById(R.id.pass);
        btn_register =  (Button) findViewById(R.id.register);
        radioGendermale = (RadioButton) findViewById(R.id.male);
        radioGenderfemale = (RadioButton) findViewById(R.id.female);

        databaseReference = FirebaseDatabase.getInstance().getReference("UserLogin");
        firebaseAuth = FirebaseAuth.getInstance();

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String fullName = txt_fullname.getText().toString();
                final String username = txt_username.getText().toString();
                final String email = txt_email.getText().toString();
                final Integer poin = 0;
                String password = txt_password.getText().toString();

               if(radioGendermale.isChecked()){
                    gender="Male";
                }
               if(radioGenderfemale.isChecked()){
                   gender="Female";
               }

               if(TextUtils.isEmpty(email)){
                   Toast.makeText(Sign_up.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
               }

                if(TextUtils.isEmpty(password)){
                    Toast.makeText(Sign_up.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                }

                if(TextUtils.isEmpty(fullName)){
                    Toast.makeText(Sign_up.this, "Please Enter Fullname", Toast.LENGTH_SHORT).show();
                }

                if(TextUtils.isEmpty(username)){
                    Toast.makeText(Sign_up.this, "Please Enter Username", Toast.LENGTH_SHORT).show();
                }

                firebaseAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Sign_up.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    user information = new user(
                                            fullName,username,email,gender,poin
                                    );
                                FirebaseDatabase.getInstance().getReference("UserLogin").child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                                                                              .setValue(information).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        Toast.makeText(Sign_up.this, "Registration Complete", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                    }
                                });


                                } else {
                                    Toast.makeText(Sign_up.this, "Gagal", Toast.LENGTH_SHORT).show();
                                }
                            }



                        });

            }

        });




    }
}
