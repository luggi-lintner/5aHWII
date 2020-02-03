package com.example.spritpreisapp2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter<String> arrayAdapter = null;
    StringRequest request;
    private RequestQueue mRequestQueue;
    private ArrayList<String> list = new ArrayList<>();
    private JSONObject data;
    private ListView lv;
    private Button b;
    AsyncTaskRunner runner = new AsyncTaskRunner();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arrayAdapter = new ArrayAdapter<String>(this, R.layout.standing_item, R.id.textView);
        lv = findViewById(R.id.text_view_result);
        lv.setAdapter(arrayAdapter);
    }

    public void onClick_fetch(View view)
    {
        runner.execute();
    }

    private class AsyncTaskRunner extends AsyncTask<String, String, ArrayList<String>> {




        @Override
        protected ArrayList<String> doInBackground(String... Params)
        {
                request = new StringRequest("https://creativecommons.tankerkoenig.de/json/list.php?lat=52.521&lng=13.438&rad=1.5&sort=dist&type=all&apikey=5f6f107f-bfbb-7180-6246-2cb88ed9a769", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response)
                    {

                        try
                        {
                            data = new JSONObject(response);
                            //initList(data);
                            JSONArray arr = data.getJSONArray("Stations");
                            Log.d("Tag:","JSON Daten abgefragt");

                            for (int i = 0; i < arr.length(); i++)
                            {
                                String id = arr.getJSONObject(i).get("id").toString();
                                String name = arr.getJSONObject(i).get("name").toString();
                                String brand = arr.getJSONObject(i).get("brand").toString();
                                Log.d("Tag", "Erreicht");
                                //String street = arr.getJSONObject(i).get("street").toString();
                                String place = arr.getJSONObject(i).get("place").toString();
                                String dist = arr.getJSONObject(i).get("dist").toString();
                                String diesel =arr.getJSONObject(i).get("diesel").toString();
                                String e5 = arr.getJSONObject(i).get("e5").toString();
                                String e10 = arr.getJSONObject(i).get("e10").toString();
                                //String isOpen = arr.getJSONObject(i).get("isOpen").toString();
                                String plz = arr.getJSONObject(i).get("postCode").toString();


                                String tmp = id + " " + name + " "+ brand+" "+ plz +" "+place +" Distanz: "+dist+" Diesel: "+ diesel +" Super: "+ e10;
                                list.add(tmp);
                                Log.d("Tag:","zur Liste hinzugefügt");
                            }
                        } catch (JSONException e) {
                            Log.d("Tag:","catch Exception");
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                         //ERROR!!!!!!! RUN AWAY
                    }
                });

                return list;

        }






        @Override
        protected void onPostExecute(ArrayList<String> list)
        {

          mRequestQueue = Volley.newRequestQueue(getApplication());
          arrayAdapter.addAll(list);
          Log.d("Tag:","on Post Execute Methode wird ausgefuehrt");
          b= findViewById(R.id.button_uk);

          mRequestQueue.add(request);
        }



    }
}



