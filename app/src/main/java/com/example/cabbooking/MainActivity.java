package com.example.cabbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.lang.*;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    List<Cabbook> uploadPDFS;
    TextView name,place,rides,free_rides,credits;
    ImageView imageView;
    ListView list;
    String[] from;
    String[] to;
    Integer[] from_time;
    Integer[] to_time;
    String[] value;
    String[] currency;
    Integer[] time;
    Integer[] imgid5;
    ArrayList<Cabbook> tennisModelArrayList;
    private CustomListAdapter adapter;
    Activity cc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(TextView) findViewById(R.id.name);
        place=(TextView) findViewById(R.id.place);
        //imageView=(ImageView) findViewById(R.id.img);
         imageView = (ImageView)findViewById(R.id.img);
        rides=(TextView) findViewById(R.id.rides);
        free_rides=(TextView) findViewById(R.id.free_rides);
        credits=(TextView) findViewById(R.id.credits);
        list=(ListView) findViewById(R.id.list);
        cc=this;
        String url = "https://gist.githubusercontent.com/iranjith4/522d5b466560e91b8ebab54743f2d0fc/raw/7b108e4aaac287c6c3fdf93c3343dd1c62d24faf/radius-mobile-intern.json";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        // textView.setText("Response: " + response.toString());
                        String s1="",s2="",s3="";
                        try {
                            JSONObject quesJson = response.getJSONObject("data").getJSONObject("profile");
                            s1=quesJson.getString("first_name");
                            s2=quesJson.getString("last_name");
                            s3=quesJson.getString("middle_name");
                            Picasso.get().load(s3).into(imageView);
                            name.setText(s1+" "+s2);
                            s1=quesJson.getString("city");
                            s2=quesJson.getString("Country");
                            place.setText(s1+", "+s2);

                            quesJson = response.getJSONObject("data").getJSONObject("stats");
                            s1=quesJson.getString("rides");
                            rides.setText(s1);
                            s1=quesJson.getString("free_rides");
                            free_rides.setText(s1);
                            quesJson = response.getJSONObject("data").getJSONObject("stats").getJSONObject("credits");
                            s1=quesJson.getString("value");
                            s2=quesJson.getString("currency_symbol");
                            credits.setText(s2+s1);
                            //  JSONArray trips=response.getJSONObject("data").getJSONArray("trips");

                       /*   int l=trips.length();
                            for (int i = 0; i <l ; i++) {


                                from[i] = trips.getJSONObject(i).getString("from");
                                to[i] = trips.getJSONObject(i).getString("to");
                                from_time[i] = trips.getJSONObject(i).getString("from_time");
                               to_time[i] = trips.getJSONObject(i).getString("to_time");

                            }
                            JSONObject costs = response.getJSONObject("data").getJSONObject("trips").getJSONObject("cost");
                            for (int i = 0; i < l; i++) {



                                value[i] = costs.getJSONObject(String.valueOf(i)).getString("value");
                                currency[i]=costs.getJSONObject(String.valueOf(i)).getString("currency");

                            }*/
                            JSONArray trips = response.getJSONObject("data").getJSONArray("trips");
                            from=new String[trips.length()];
                            to=new String[trips.length()];
                            from_time=new Integer[trips.length()];
                            to_time=new Integer[trips.length()];
                            time=new Integer[trips.length()];
                            value=new String[trips.length()];
                            currency=new String[trips.length()];
                            imgid5=new Integer[trips.length()];
                            JSONObject dataArray1;// = response.getJSONObject("data").getJSONObject("trips").getJSONArray("cost");
                            Cabbook playersModel = new Cabbook();
                            for (int i = 0; i < trips.length(); i++) {
                                dataArray1=trips.getJSONObject(i).getJSONObject("cost");
                                from[i] =trips.getJSONObject(i).getString("to");
                                to[i] = trips.getJSONObject(i).getString("from");
                                from_time[i] = trips.getJSONObject(i).getInt("from_time");
                                to_time[i] = trips.getJSONObject(i).getInt("to_time");
                                time[i] = trips.getJSONObject(i).getInt("trip_duration_in_mins");
                                value[i] = dataArray1.getString("value");
                                currency[i] =dataArray1.getString("currency_symbol");
                                imgid5[i] = R.drawable.road;
                              /*  JSONObject dataobj = dataArray.getJSONObject(i);
                                JSONObject dataobj1 = dataArray1.getJSONObject(i);
                                playersModel.setPlace(dataobj.getString("from"));
                                playersModel.setPlacet(dataobj.getString("from_time"));
                                playersModel.setDest(dataobj.getString("to"));
                                playersModel.setDestt(dataobj.getString("to_time"));
                                playersModel.setBill(dataobj1.getString("value"));
                                playersModel.setCurrency(dataobj1.getString("currency"));
                                tennisModelArrayList.add(playersModel);*/

                            }


                            CustomListAdapter adapter = new CustomListAdapter(cc,imgid5,from, from_time,to,to_time,value,currency,time);

                            list.setAdapter(adapter);


                            //  Toast.makeText(MainActivity.this, param.toString(), Toast.LENGTH_LONG).show();
                        }
                        catch (Exception e){
                            Toast.makeText(MainActivity.this, "Error: "+e, Toast.LENGTH_LONG).show();
                        }


                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                        Toast.makeText(MainActivity.this, "Error: "+error, Toast.LENGTH_LONG).show();

                    }
                });
        //Toast.makeText(MainActivity.this, "Hello", Toast.LENGTH_LONG).show();


// Access the RequestQueue through your singleton class.
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
    }
}