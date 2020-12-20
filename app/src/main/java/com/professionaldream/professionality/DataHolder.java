package com.professionaldream.professionality;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class DataHolder {
    public static FirebaseAuth Auth;
    public static FirebaseUser cUser;
    public static FirebaseDatabase database;
    public static String[] favorite_categories=new String[]{"operaio"};//TODO:Dynamically load/store
    public static boolean isGuest=false;
}
