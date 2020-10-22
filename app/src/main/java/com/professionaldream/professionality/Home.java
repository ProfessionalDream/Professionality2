package com.professionaldream.professionality;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        if(DataHolder.Auth.getCurrentUser()==null){
            Intent i=new Intent(this,com.professionaldream.professionality.ui.login.login.class);
            startActivity(i);
        }
        new EasyGoto(this,R.id.button3,categorie.class);
    }
}