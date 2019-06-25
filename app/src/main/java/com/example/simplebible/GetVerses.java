package com.example.simplebible;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class GetVerses extends AsyncTask<Void,Void,Void> {

    private String verseData="";
    private String verseSingle="";
    private String verseAll="";
    private String text;
    private String verse;
    private String title;


    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("https://bible-api.com/matthew6");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader
                    (inputStream));
            String line = "";
            while (line!= null){
                line = bufferedReader.readLine();
                verseData = verseData + line;
            }
            /*JSONObject versesJSON=null;
            try{
                versesJSON = new JSONObject(verses);
            }catch(JSONException e){
                e.printStackTrace();
            }
            System.out.println(versesJSON);*/



            Log.i("verses",verseData);

            JSONObject versesJO = new JSONObject(verseData);
            title = versesJO.get("reference").toString();
            JSONArray versesJA = versesJO.getJSONArray("verses");

            for(int i = 0;i < versesJA.length();i++) {
                JSONObject verseJO = (JSONObject) versesJA.get(i);
                verse = verseJO.get("verse").toString();
                text = verseJO.get("text").toString();
                verseSingle = verse+ text;
                verseAll = verseAll+verseSingle;
            }
            httpURLConnection.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        MainActivity.textView.setText(verseAll);
        MainActivity.titleView.setText(title);
    }
}
