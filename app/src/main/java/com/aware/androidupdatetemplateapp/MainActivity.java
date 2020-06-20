package com.aware.androidupdatetemplateapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.content.Intent;
import android.content.pm.LauncherApps;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
Button bopen;

    private RequestQueue queue;
    private Object UpdatePage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        queue = Volley.newRequestQueue(this);

        bopen = findViewById(R.id.button);
        bopen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getPackageManager().getLaunchIntentForPackage("com.AutoUpdateApp.UpdateRecycleList");
            }

        });
    }

    public void checkForUpdates(View view) {
        final TextView textView = (TextView) findViewById(R.id.text);
        String localhost = "http://10.0.2.2:5000/";
        JsonObjectRequest stringRequest =
                new JsonObjectRequest(Request.Method.GET, localhost, null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                textView.setText(response.toString());
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        textView.setText("There's no new updates. You're up to date! 👍");
                    }
                });
        queue.add(stringRequest);


        //SYSTEM FOR NEW VERSIONS
        //WHENEVER THERE IS A NEW VERSION ADDED TO THIS LIST FROM THE COMPANY THAT IS COMPATIBLE TO UPDATE WITH
        //THE USERS DEVICE, IT WILL NOTIFY THE USER.(even if it is just security fixes or small updates)

        //OTHERWISE IF THERE IS A VERSION ADDED THAT IS NOT COMPATAIBLE THEN IT WILL NOT NOTIFY THE USER
        //ONCE CLICKED ON THE NOTIFICATION, IT WILL LEAD THE USER TO THE APP VERSIONS CLASS/BUTTON

    }
    //THE MASTER WHILE LOOP

    //double currentVersion = 0.0;
    //double NewVersion = 1.0;

        //if(currentVersion<NewVersion)


}
