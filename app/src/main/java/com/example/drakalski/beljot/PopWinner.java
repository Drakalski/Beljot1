package com.example.drakalski.beljot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;




public class PopWinner extends AppCompatActivity {
    public int point = 0;

    RequestQueue queue;

    Button btnNewMatch;
    Button btnGoToMenu;
    TextView textViewWinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_win);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        btnNewMatch = (Button) findViewById(R.id.btnNewMatch);
        btnGoToMenu = (Button) findViewById(R.id.btnGoToMenu);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * .9), (int) (height * 0.9));

        String winner = getIntent().getStringExtra("Winner Name");
          point = getIntent().getIntExtra("Point", 0);
        textViewWinner = (TextView) findViewById(R.id.textViewWinner);


        sendNotifications();

        btnNewMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(PopWinner.this, NewGame.class);
                startActivity(intent);

            }
        });
        btnGoToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PopWinner.this, Menu.class);
                startActivity(intent);
            }
        });


        textViewWinner.setText(winner);

    }

    public static int messageID = -1;


        public void sendNotifications () {

            if(point == 1) {
                try {

                    queue = Volley.newRequestQueue(PopWinner.this);
                    JsonObject notificationData = new JsonObject();
                    notificationData.addProperty("body", "You have won the game.");
                    notificationData.addProperty("title", "Won");
                    notificationData.addProperty("sound", "off");
                    notificationData.addProperty("priority", "high");
                    JsonObject params = new JsonObject();
                    params.add("notification", notificationData);
                    params.addProperty("to", "/topics/Winner");
                    JsonObjectRequest req = new JsonObjectRequest("https://fcm.googleapis.com/fcm/send", new JSONObject(params.toString()),
                            new Response.Listener<JSONObject>() {
                                @Override
                                public void onResponse(JSONObject response) {
                                    try {
                                        messageID = response.getInt("message_id");
                                        Log.d("Response", response.toString(4));
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
//                    Log.d("Error: ", error.getMessage());
                        }
                    }) {
                        @Override
                        public Map<String, String> getHeaders() throws AuthFailureError {
                            Map<String, String> params = new HashMap();
                            params.put("Content-Type", "application/json");
                            params.put("authorization", "key=" + "AAAAXemUtmk:APA91bFMqXjztY-wEdTkIkh4Ba63LeMml5laOT6yPrE-wmE4UXHOgDR08TYbKnEoU4Yf8gqbCkNySxRPfqv6E6mPoVEkhod39LZjhaKz6-ib14eUA-Gega9KVPjnIiUa6yUmOZovSzER");
                            return params;
                        }
                    };
                    queue.add(req);
                } catch (Exception e) {
                    Log.d("Notification Error", e.getMessage());
                }

            }

            else if(point == 2){
                try {

                    queue = Volley.newRequestQueue(PopWinner.this);
                    JsonObject notificationData = new JsonObject();
                    notificationData.addProperty("body", "You have lost the game.");
                    notificationData.addProperty("title", "Lost");
                    notificationData.addProperty("sound", "off");
                    notificationData.addProperty("priority", "high");
                    JsonObject params = new JsonObject();
                    params.add("notification", notificationData);
                    params.addProperty("to", "/topics/Winner");
                    JsonObjectRequest req = new JsonObjectRequest("https://fcm.googleapis.com/fcm/send", new JSONObject(params.toString()),
                            new Response.Listener<JSONObject>() {
                                @Override
                                public void onResponse(JSONObject response) {
                                    try {
                                        messageID = response.getInt("message_id");
                                        Log.d("Response", response.toString(4));
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
//                    Log.d("Error: ", error.getMessage());
                        }
                    }) {
                        @Override
                        public Map<String, String> getHeaders() throws AuthFailureError {
                            Map<String, String> params = new HashMap();
                            params.put("Content-Type", "application/json");
                            params.put("authorization", "key=" + "AAAAXemUtmk:APA91bFMqXjztY-wEdTkIkh4Ba63LeMml5laOT6yPrE-wmE4UXHOgDR08TYbKnEoU4Yf8gqbCkNySxRPfqv6E6mPoVEkhod39LZjhaKz6-ib14eUA-Gega9KVPjnIiUa6yUmOZovSzER");
                            return params;
                        }
                    };
                    queue.add(req);
                } catch (Exception e) {
                    Log.d("Notification Error", e.getMessage());
                }

            }


            }
    }



