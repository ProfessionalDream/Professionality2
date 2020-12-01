package com.professionaldream.professionality;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.professionaldream.professionality.AdapterAnnunci.Adapter_annunci;
import com.professionaldream.professionality.AdapterAnnunci.Annuncio;

public class Home extends AppCompatActivity {
    Annuncio[] test_annunci=new Annuncio[]{new Annuncio("Test1","Sardegna",0, "https://www.mrhandyman.it/public/image/miglior-falegname-milano.jpg"),
                                           new Annuncio("Test2","Emilia Romagna",1,"https://lirp-cdn.multiscreensite.com/620b0afe/dms3rep/multi/opt/FG-FABBRO-TAVAZZANO-CON-VILLAVESCO-004-640w.jpg"),
                                           new Annuncio("Test 3","abruzzo",2,"https://www.braciamiancora.com/wp-content/uploads/2020/04/WhatsApp-Image-2020-04-14-at-16.40.201.jpeg")
    };

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
        Adapter_annunci madapter=new Adapter_annunci(getApplicationContext(),test_annunci);
        annunci.setAdapter(madapter);

    }
}