package com.rarepep8.coursem8;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class SearchableActivity extends AppCompatActivity {

    Activity currentActivity = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchable);
        // Get the intent, verify the action and get the query
        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            new ApiFetchTask().search(query);
        }
    }


    public class ApiFetchTask extends AsyncTask<Void, Void, String> {
        private static final String API_URL = "https://cobalt.qas.im/api/1.0/courses/filter?q=campus:\"UTSC\"%20AND%20code:\"";
        private static final String API_KEY = "I6a7FaoWXC1VOgrWiilj4nbCQ1QZ5xZa";
        private String enteredCourseCode = "";
        protected String doInBackground(Void... urls) {
            // Do some validation here
            try {
                URL url = new URL(API_URL + enteredCourseCode + "\"&limit=100&key=" + API_KEY);

                HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
                System.out.println(urlConnection.getResponseCode());
                System.out.println(url.toString());
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    StringBuilder stringBuilder = new StringBuilder();
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line).append("\n");
                    }
                    bufferedReader.close();
                    return stringBuilder.toString();
                }
                finally{
                    urlConnection.disconnect();
                }
            }
            catch(Exception e) {
                return null;
            }
        }

        protected void onPostExecute(String response) {
            if(response == null) {

            } else {
                try {
                    JSONArray objects = (JSONArray) new JSONTokener(response).nextValue();
                    Intent intent = new Intent(SearchableActivity.this, SearchedCourseList.class);
                    intent.putExtra("jArrayOfCourses", objects.toString());
                    startActivity(intent);
                    finish();
                } catch (JSONException e) {

                }
            }
        }
        public void search(String query){
            this.enteredCourseCode = query;
            execute();
        }
    }
}
