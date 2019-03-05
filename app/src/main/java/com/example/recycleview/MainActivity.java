package com.example.recycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.recycleview.adaptador.AdaptadorPersona;
import com.example.recycleview.model.Persona;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
RecyclerView rc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rc = findViewById(R.id.id_rv);



        List<Persona> lp = new ArrayList<Persona>();
        //lp.add(new Persona(1, "Cynthia", "Macias", 22));

        AdaptadorPersona adp = new AdaptadorPersona(lp);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rc.setLayoutManager(new LinearLayoutManager(this));

        rc.setAdapter(adp);
    }


    public void OnClick(View view) {

        JsonArrayRequest json = new JsonArrayRequest(
                Request.Method.GET,
                "http://nuevo.rnrsiilge-org.mx/lista",
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Gson g = new Gson();
                        Type t = new TypeToken<List<Persona>>(){}.getType();

                        List<Persona> lp = g.fromJson(response.toString(), t);
                        AdaptadorPersona ap = new AdaptadorPersona(lp);
                        rc.setAdapter(ap);
                        rc.setLayoutManager(new LinearLayoutManager(MainActivity.this));//getApplicationContext()
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();

            }
        });

        VolleyS.getInstance(this).getMyRequestQueue().add(json);
    }
}
