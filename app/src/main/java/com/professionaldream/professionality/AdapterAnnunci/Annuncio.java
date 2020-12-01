package com.professionaldream.professionality.AdapterAnnunci;

import android.net.Uri;

public class Annuncio {
    String titolo;
    String provincia;
    int status;//1:vip,2:premium,every other number:base
    Uri imageUrl;

    public Annuncio(String titolo, String provincia, int status, String imageUrl) {
        this.titolo = titolo;
        this.provincia = provincia;
        this.status = status;
        this.imageUrl = Uri.parse(imageUrl);
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

    public Uri getImageUrl() {
        return imageUrl;
    }

}
