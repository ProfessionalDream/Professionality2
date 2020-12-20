package com.professionaldream.professionality;

import android.content.Intent;
import android.icu.text.Edits;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.professionaldream.professionality.AdapterAnnunci.Annuncio;
import com.professionaldream.professionality.ui.login.login;

import java.util.Iterator;


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
        DataHolder.database= FirebaseDatabase.getInstance();
        p.incrementProgressBy(p.getMax()/2);
        boolean res=load_feed();
        p.incrementProgressBy(p.getMax()/2);
        return res;
    }
    boolean load_feed(){
        final boolean[] error_oc = {false};
        DatabaseReference ref=DataHolder.database.getReference("/Annunci");
        for(String category:DataHolder.favorite_categories){
            //TODO:WORK OUT A BETTER ALGORITHM TO DETERMINE WHICH POST TO CHOSE
            Query q=ref.child(category).orderByChild("score").limitToFirst(OPTIONS.initial_feed_length/DataHolder.favorite_categories.length);
            q.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for(DataSnapshot dn:snapshot.getChildren()){
                        Iterator<DataSnapshot> i=dn.getChildren().iterator();
                        //int score=i.next().getValue(Integer.class);
                        Annuncio an=i.next().getValue(Annuncio.class);
                        if(an!=null) {
                            Home.feed.add(an);
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    error_oc[0] =true;
                }
            });
        }
        return !error_oc[0];//why is this necessary?
    }

}