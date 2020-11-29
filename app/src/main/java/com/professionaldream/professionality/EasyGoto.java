package com.professionaldream.professionality;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;

public class EasyGoto {
    public boolean finish=false;
    public View v;
    private Class<?> destination;
    public Activity A;

    public static boolean connectBar(Activity A,boolean finish){
        EasyGoto[] t=new EasyGoto[4];
        try {
            t[0]=new EasyGoto(A, R.id.profile_button, profilo.class);
            t[1]=new EasyGoto(A, R.id.home_button, Home.class);
            t[2]=new EasyGoto(A, R.id.shop_button, shop.class);
            t[3]=new EasyGoto(A, R.id.search_button, categorie.class);
            t[0].finish=finish;
            t[1].finish=finish;
            t[2].finish=finish;
            t[3].finish=finish;

            return true;
        }catch(Exception e){
            Log.e("Error: ",e.toString());
            return false;
        }
    }
    public static boolean connectBar(Activity A){
        try {
            new EasyGoto(A, R.id.profile_button, profilo.class);
            new EasyGoto(A, R.id.search_button, categorie.class);
            new EasyGoto(A, R.id.shop_button, shop.class);
            new EasyGoto(A, R.id.home_button, Home.class);
            return true;
        }catch(Exception e){
            Log.e("Error: ",e.toString());
            return false;
        }
    }
    public EasyGoto(Activity A,int id, Class<?> destination){
        this.v=A.findViewById(id);
        if(v==null){
            return;
        }
        this.destination=destination;
        this.A=A;
        this.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jump();
            }
        });
    }
    void jump(){
        Intent i=new Intent(this.A,this.destination);
        A.startActivity(i);
        if (this.finish){
            this.A.finish();
        }
    }
}
