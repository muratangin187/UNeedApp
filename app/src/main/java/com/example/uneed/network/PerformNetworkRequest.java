package com.example.uneed.network;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class PerformNetworkRequest extends AsyncTask<Void, Void, String>
{

    //the url where we need to send the request
    String url;
    //the parameters
    HashMap<String, String> params;
    JSONObject result;
    //the request code to define whether it is a GET or POST
    public static final int CODE_GET_REQUEST = 1024;
    public static final int CODE_POST_REQUEST = 1025;
    int requestCode;

    //constructor to initialize values
    public PerformNetworkRequest(String url, HashMap<String, String> params, int requestCode) {
        this.url = url;
        this.params = params;
        this.requestCode = requestCode;
    }

    //when the task started displaying a progressbar
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //MainActivity.progressBar.setVisibility(View.VISIBLE);
    }


    //this method will give the response from the request
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        //MainActivity.progressBar.setVisibility(GONE);
        try {
            result = new JSONObject(s);
            //if (!object.getBoolean("error")) {
            //refreshing the herolist after every operation
            //so we get an updated list
            //we will create this method right now it is commented
            //because we haven't created it yet
            //refreshHeroList(object.getJSONArray("heroes"));
            //}
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    //the network operation will be performed in background
    @Override
    protected String doInBackground(Void... voids) {
        RequestHandler requestHandler = new RequestHandler();

        if (requestCode == CODE_POST_REQUEST)
            return requestHandler.sendPostRequest(url, params);


        if (requestCode == CODE_GET_REQUEST)
            return requestHandler.sendGetRequest(url);

        return null;
    }


}

