package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText editTextTextEmailAddress2,editTextTextPassword2;
    Button button3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextTextEmailAddress2=findViewById(R.id.editTextTextEmailAddress2);
        editTextTextPassword2=findViewById(R.id.editTextTextPassword2);
        button3=findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextTextEmailAddress2.getText().toString();
                String password = editTextTextPassword2.getText().toString();
                if (!isValidPassword(password)) {
                    Toast.makeText(MainActivity.this, "password doesn't match rules", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(MainActivity.this, signIN.class);
                intent.putExtra("email", email);
                intent.putExtra("password", password);
                startActivity(intent);


            }
        });
    }
    Pattern lowercase=Pattern.compile("^.*[a-z].*$");
    Pattern uppercase=Pattern.compile("^.*[A-Z].*$");
    Pattern number=Pattern.compile("^.*[0-9].*$");
    Pattern specialCharacter=Pattern.compile("^,*[a-zA-Z0-9].*$");
    private Boolean isValidPassword(String password){
        if(password.length()<8){
            return false;
        }
        if(!uppercase.matcher(password).matches()){
            return false;

        }
        if(!number.matcher(password).matches()){
            return false;

        }
        if(!specialCharacter.matcher(password).matches()){
            return false;

        }
        return true;
    }
}