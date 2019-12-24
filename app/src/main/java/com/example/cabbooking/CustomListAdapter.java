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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class CustomListAdapter extends ArrayAdapter<String> {


    private final Activity context;
    private final String[] place;
    private final  Integer[] placet;
    private final String[] dest;
    private final Integer[] destt;
    private final Integer[] img;
    private final String[] value;
    private final String[] currency;
    private final Integer[] time;




    public CustomListAdapter(Activity context, Integer[] img,String[] place,  Integer[] placet, String[] dest,  Integer[] destt, String[] value, String[] currency,Integer[] time) {
        super(context, R.layout.card_frutorials, place);


        // TODO Auto-generated constructor stub

        this.context= (Activity) context;
        this.place = place;
        this.placet = placet;
        this.dest = dest;
        this.destt = destt;
        this.img = img;
        this.value = value;
        this.currency = currency;
        this.time=time;


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
        TextView tim = (TextView) rowView.findViewById(R.id.timed);
        ImageView imageView=(ImageView) rowView.findViewById(R.id.youtubeThubnail);

        destin.setText(dest[position]);
        destintime.setText(getDate(destt[position]));
        plac.setText(place[position]);
        plact.setText(getDate(placet[position]));
        billl.setText(value[position]);
        curren.setText(currency[position]);
        tim.setText(formatHoursAndMinutes(time[position]));
        imageView.setImageResource(img[position]);



        return rowView;

    };
    public static String formatHoursAndMinutes(int totalMinutes) {
        String minutes = Integer.toString(totalMinutes % 60);
        minutes = minutes.length() == 1 ? "0" + minutes : minutes;
        if((totalMinutes / 60)==0)
            return minutes+"min";
        else
        return (totalMinutes / 60) +"h"+minutes+"min";
    }
    public  String getDate(int timestamp) {
        try{
            Calendar calendar = Calendar.getInstance();
            TimeZone tz = TimeZone.getDefault();
            calendar.setTimeInMillis(timestamp * 1000);
            calendar.add(Calendar.MILLISECOND, tz.getOffset(calendar.getTimeInMillis()));
            SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, HH:mm");
            Date currenTimeZone = (Date) calendar.getTime();
            return sdf.format(currenTimeZone);
        }catch (Exception e) {
        }
        return "";
    }


}