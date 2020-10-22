package com.professionaldream.professionality;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.professionaldream.professionality.ui.login.login;

public class register extends AppCompatActivity {
    public boolean success;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
    }

    public boolean newUser(String email,String password){

        DataHolder.Auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                success=task.isSuccessful();
                if(!success){
                    Toast toast = Toast.makeText(getBaseContext(), task.getException().toString(), Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

        return success;
    }

    public void doRegister(View v){
        String email=((EditText)findViewById(R.id.Email)).getText().toString();
        String password1=((EditText)findViewById(R.id.Password)).getText().toString();
        String password2=((EditText)findViewById(R.id.Password2)).getText().toString();

        if (password1.equals(password2)){
            if (newUser(email,password1)){
                Intent i=new Intent(this,login.class);
                startActivity(i);
                finish();
            }
        }
        else{
            Toast.makeText(this,"Le Password Non Corrispondono",Toast.LENGTH_LONG).show();
        }

    }
}