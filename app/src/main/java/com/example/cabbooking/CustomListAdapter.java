package com.example.cabbooking;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Response;

import org.json.JSONObject;

public class CustomListAdapter extends ArrayAdapter<String> {


    private final Activity context;
    private final String[] place;
    private final String[] placet;
    private final String[] dest;
    private final String[] destt;
    private final Integer[] img;
    private final String[] value;
    private final String[] currency;




    public CustomListAdapter(Response.Listener<JSONObject> context, Integer[] img,String[] place, String[] placet, String[] dest, String[] destt, String[] value, String[] currency) {
        super((Context) context, R.layout.card_frutorials, place);


        // TODO Auto-generated constructor stub

        this.context= (Activity) context;
        this.place = place;
        this.placet = placet;
        this.dest = dest;
        this.destt = destt;
        this.img = img;
        this.value = value;
        this.currency = currency;


    }




    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.card_frutorials, null,true);

        TextView destin = (TextView) rowView.findViewById(R.id.dest);
        TextView destintime = (TextView) rowView.findViewById(R.id.dtime);
        TextView plac = (TextView) rowView.findViewById(R.id.place);
        TextView plact = (TextView) rowView.findViewById(R.id.placet);
        TextView billl = (TextView) rowView.findViewById(R.id.bill);
        TextView curren = (TextView) rowView.findViewById(R.id.sym);
        ImageView imageView=(ImageView) rowView.findViewById(R.id.youtubeThubnail);

        destin.setText(dest[position]);
        destintime.setText(destt[position]);
        plac.setText(place[position]);
        plact.setText(placet[position]);
        billl.setText(value[position]);
        curren.setText(currency[position]);
        imageView.setImageResource(img[position]);



        return rowView;

    };


}