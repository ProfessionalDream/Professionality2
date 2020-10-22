package com.professionaldream.professionality;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.professionaldream.professionality.ui.login.login;


public class MainActivity extends AppCompatActivity {

    Class next=login.class;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public void onAttachedToWindow(){
        Intent i=new Intent(this,this.next);
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
        DataHolder.Auth =FirebaseAuth.getInstance();
        p.incrementProgressBy(p.getMax());
        return true;
    }
}