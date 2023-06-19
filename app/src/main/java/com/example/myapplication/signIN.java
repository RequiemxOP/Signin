package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signIN extends AppCompatActivity {
    EditText editmailAddress,editTextPassword;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        editmailAddress=findViewById(R.id.editmailAddress);
        editTextPassword=findViewById(R.id.editTextPassword);
        editTextPassword=findViewById(R.id.editTextPassword);
        button=findViewById(R.id.button);
        String registeredEmail=getIntent().getStringExtra("email");
        String registeredpassword=getIntent().getStringExtra("password");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String email=editmailAddress.getText().toString();
                String password=editTextPassword.getText().toString();
                if (registeredEmail.equals(email) && registeredpassword.equals(password)) {

                    Intent intent=new Intent(signIN.this,LOGGEDIN.class);
                    startActivity(intent);
                    }
                else{
                    Toast.makeText(signIN.this,"invalid credentials",Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
}