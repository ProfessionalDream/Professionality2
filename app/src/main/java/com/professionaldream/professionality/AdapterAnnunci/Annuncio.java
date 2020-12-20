package com.professionaldream.professionality.AdapterAnnunci;

import android.net.Uri;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Annuncio {
    public String titolo;
    public String provincia;
    public int status;//1:vip,2:premium,every other number:base
    public String imageUrl;

    public Annuncio(String titolo, String provincia, int status, String imageUrl) {
        this.titolo = titolo;
        this.provincia = provincia;
        this.status = status;
        this.imageUrl = imageUrl;
    }
    public Annuncio(){
        //Required for firebase
    }
    public String getTitolo() {
        return titolo;
    }

    public String getProvincia() {
        return provincia;
    }

    public int getStatus() {
        return status;
    }

    public String getImageUrl() {
        return imageUrl;
    }

}
