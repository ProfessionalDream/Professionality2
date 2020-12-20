package com.professionaldream.professionality.AdapterAnnunci;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.professionaldream.professionality.R;
import com.squareup.picasso.Picasso;

public class Adapter_annunci extends BaseAdapter {
    Context context;
    Annuncio[] annunci;
    LayoutInflater inflater;

    public Adapter_annunci(Context context, Annuncio[] annunci){
        this.context = context;
        this.annunci = annunci;
        this.inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return annunci.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if(position>=this.getCount()){
            return null;
        }

        view=inflater.inflate(R.layout.annuncio_element,null);
        Annuncio questo_annuncio=this.annunci[position];//This shouldn't be a problem because of getCount

        TextView Title=(TextView)view.findViewById(R.id.Titolo_annuncio);
        TextView Provincia=(TextView)view.findViewById(R.id.Provincia_Annuncio);
        ImageView Foto=(ImageView)view.findViewById(R.id.Foto_Annuncio);
        ImageView premium_logo=(ImageView)view.findViewById(R.id.premium_logo);
        ImageView vip_logo=(ImageView)view.findViewById(R.id.vip_logo);

        Title.setText(questo_annuncio.titolo);
        Provincia.setText(questo_annuncio.provincia);

        Picasso.get().load(Uri.parse(questo_annuncio.imageUrl)).resize(102,102).into(Foto);

        if(questo_annuncio.status==1){
            vip_logo.setVisibility(View.VISIBLE);
        }
        if(questo_annuncio.status==2){
            premium_logo.setVisibility(View.VISIBLE);
        }
        return view;
    }
}
