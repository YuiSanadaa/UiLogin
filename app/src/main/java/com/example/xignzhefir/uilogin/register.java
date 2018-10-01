package com.example.xignzhefir.uilogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity {

    EditText email;
    EditText username;
    EditText password;
    EditText Retype;
    Button daftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = (EditText) findViewById(R.id.etxEmail);
        password = (EditText) findViewById(R.id.etxPassword);
        Retype = (EditText) findViewById(R.id.etxRetype);
        daftar = (Button)findViewById(R.id.btnDaftar);

        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email.getText().toString().length()==0){
                    //jika form Email belum di isi / masih kosong
                    email.setError("Email is Null!");
                }else if(password.getText().toString().length()==0) {
                    //jika form Passwrod belum di isi / masih kosong
                    password.setError("Password is Null!");
                }else if (!isMatch(password.getText().toString(),Retype.getText().toString())){
                    Retype.setError("Password Not match");
                }else{
                    //jika form sudah terisi semua
                    Toast.makeText(getApplicationContext(), "Registrasi Complete!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void pindah2(View view) {
        Intent intent = new Intent(register.this, MainActivity.class);
        startActivity(intent);
    }

    private boolean isMatch(String password, String retypePassword){
        return password.equals(retypePassword);
    }
}
