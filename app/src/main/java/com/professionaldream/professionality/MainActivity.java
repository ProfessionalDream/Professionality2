package com.professionaldream.professionality;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.professionaldream.professionality.ui.login.login;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public void onAttachedToWindow(){
        Intent i=new Intent(this,login.class);
        boolean ok=load();
        if (ok){
            startActivity(i);
            finish();
        }
        else{
            Toast.makeText(this,"Error",Toast.LENGTH_LONG).show();
        }
    }

    boolean load(){
        ProgressBar p=findViewById(R.id.progressBar);
        for(int x=0;x<=(p.getMax()*10000);x++){
            for(int y=0;x<10000;x++){
                y=(y*987)/987;
            }
            p.incrementProgressBy(1);
        }
        return true;
    }
}