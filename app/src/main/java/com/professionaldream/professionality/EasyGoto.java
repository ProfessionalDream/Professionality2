package com.professionaldream.professionality;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

public class EasyGoto {
    public boolean finish=false;
    public View v;
    private Class<?> destination;
    public Activity A;
    public EasyGoto(Activity A,int id, Class<?> destination){
        this.v=A.findViewById(id);
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
