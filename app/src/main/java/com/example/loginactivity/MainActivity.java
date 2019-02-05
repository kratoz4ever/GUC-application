package com.example.loginactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText Name;
    private EditText Password;
    private Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name=(EditText) findViewById(R.id.etName);
        Password=(EditText) findViewById(R.id.etPassword);
        Login=(Button) findViewById(R.id.etLogin);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(),Password.getText().toString());
            }
        });




    }
    private void validate( String user, String pass){
        if((user.equals("hii")&&(pass.equals("bye")))){
            Intent intent=new Intent(MainActivity.this,ListActivity.class);
            startActivity(intent);


        }
    }
}
