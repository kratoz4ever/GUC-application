package com.example.loginactivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;

public class MainActivity extends AppCompatActivity {
    private EditText Name;
    private EditText Password;
    private Button Login;
    private Button Register;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseApp.initializeApp(this);
        firebaseAuth=FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() != null){
            Intent intent=new Intent(MainActivity.this,ListActivity.class);
            startActivity(intent);
        }
        progressDialog=new ProgressDialog(this);
        Name=(EditText) findViewById(R.id.etName);
        Password=(EditText) findViewById(R.id.etPassword);
        Login=(Button) findViewById(R.id.etLogin);
        Register=(Button) findViewById(R.id.etRegister);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLogin();
            }
        });




    }
    private void userLogin(){
        String email=Name.getText().toString().trim();
        String pass=Password.getText().toString().trim();
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Please fill the empty fields!",Toast.LENGTH_SHORT).show();
            //stops the func from continuing
            return;
        }
        if(TextUtils.isEmpty(pass)){
            Toast.makeText(this,"Please fill the empty fields!",Toast.LENGTH_SHORT).show();
            //stops the func from continuing
            return;

        }

        progressDialog.setMessage("Signing in ...");
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();
                if(task.isSuccessful()){
                        Intent intent=new Intent(MainActivity.this,ListActivity.class);
                        startActivity(intent);
                    }
                    else {
                    Toast.makeText(MainActivity.this,"Invalid Credentials!",Toast.LENGTH_SHORT).show();

                    }
                }
            }
        );
    }

}
