package com.example.xignzhefir.uilogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText email;
    EditText username;
    EditText password;
    Button daftar;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = (EditText) findViewById(R.id.etxEmail);
        password = (EditText) findViewById(R.id.etxPassword);
        daftar = (Button)findViewById(R.id.btnDaftar);

        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isValidEmaillId(username.getText().toString().trim())){
//            Toast.makeText(getApplicationContext(), "Valid Email Address.", Toast.LENGTH_SHORT).show();
                    username.setError("Invalid Email Address");
                }else if(password.getText().toString().length()==0){
                    //jika form Passwrod belum di isi / masih kosong
                    password.setError("Password Is Null !!");
                }else {
                    //jika form sudah terisi semua
                    Toast.makeText(getApplicationContext(), "Login Complete!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private boolean isValidEmaillId(String email){

        return Pattern.compile("[a-zA-Z0-9._-]+@[a-z]+\\\\.+[a-z]+").matcher(email).matches();
    }


    public void pindah(View view) {
        Intent intent = new Intent(MainActivity.this, register.class);
        startActivity(intent);
    }
    }

