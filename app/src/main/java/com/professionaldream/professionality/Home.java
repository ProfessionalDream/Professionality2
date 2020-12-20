package com.professionaldream.professionality;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.professionaldream.professionality.AdapterAnnunci.Adapter_annunci;
import com.professionaldream.professionality.AdapterAnnunci.Annuncio;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {
    static List<Annuncio> feed=new ArrayList<Annuncio>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        if(DataHolder.Auth.getCurrentUser()==null){
            Intent i=new Intent(this,com.professionaldream.professionality.ui.login.login.class);
            startActivity(i);
        }
        EasyGoto.connectBar(this);

        ListView annunci=(ListView)findViewById(R.id.listView);
        Annuncio[] tfeed=new Annuncio[Home.feed.size()];
        tfeed=Home.feed.toArray(tfeed);

        Adapter_annunci madapter=new Adapter_annunci(getApplicationContext(),tfeed);
        annunci.setAdapter(madapter);

    }
}