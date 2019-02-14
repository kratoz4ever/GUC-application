package com.example.loginactivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    private Button etRegister1;
    private Button etSignIn;
    private EditText name;
    private EditText email;
    private EditText password;
    private EditText password2;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        firebaseAuth=FirebaseAuth.getInstance();
        name=(EditText) findViewById(R.id.etFullName);
        email=(EditText) findViewById(R.id.etEmail);
        password=(EditText) findViewById(R.id.etPassword1);
        password2=(EditText) findViewById(R.id.etPassword2);
        etSignIn=(Button) findViewById(R.id.etSignIn);
        etRegister1=(Button) findViewById(R.id.etRegister1);
        etRegister1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View r) {
                if (r == etRegister1) {
                    registerUser();

                }
            }});
        etSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(intent);

            }
        });
        progressDialog=new ProgressDialog(this);


    }
    private void registerUser(){
        String Name=name.getText().toString().trim();
        String Email=email.getText().toString().trim();
        String pass=password.getText().toString().trim();
        String pass2=password2.getText().toString().trim();
        if(TextUtils.isEmpty(Email)){
            Toast.makeText(this,"Please fill the empty fields!",Toast.LENGTH_SHORT).show();
            //stops the func from continuing
            return;
        }
        if(TextUtils.isEmpty(Name)){
            Toast.makeText(this,"Please fill the empty fields!",Toast.LENGTH_SHORT).show();
            //stops the func from continuing
            return;

        }
        if(TextUtils.isEmpty(pass)){
            Toast.makeText(this,"Please fill the empty fields!",Toast.LENGTH_SHORT).show();
            //stops the func from continuing
            return;

        }
        if(TextUtils.isEmpty(pass2)){
            Toast.makeText(this,"Please fill the empty fields!",Toast.LENGTH_SHORT).show();
            //stops the func from continuing
            return;

        }
        if(pass2.compareTo(pass)!=0){
            Toast.makeText(this,"Passwords are not the same!",Toast.LENGTH_SHORT).show();
            //stops the func from continuing
            return;

        }

        progressDialog.setMessage("Registration in progress ...");
        progressDialog.show();
        firebaseAuth.createUserWithEmailAndPassword(Email,pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>(){
            public void onComplete(Task<AuthResult> task){
                if(task.isSuccessful()){
                    Toast.makeText(RegisterActivity.this,"Registered Successfully!",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(RegisterActivity.this,"Failed to Register!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
