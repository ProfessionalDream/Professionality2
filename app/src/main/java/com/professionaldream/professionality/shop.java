package com.professionaldream.professionality;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class shop extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        EasyGoto.connectBar(this);
    }
}