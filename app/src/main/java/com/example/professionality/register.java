package com.example.professionality;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.professionality.ui.login.login;

public class register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sched3);
    }
    public void doRegister(View v){
        Intent i=new Intent(this,login.class);
        startActivity(i);
    }
}