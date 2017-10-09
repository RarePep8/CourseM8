package com.rarepep8.coursem8;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class SearchedCourseList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Activity activity = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searched_course_list);
        String jArrayString = getIntent().getStringExtra("jArrayOfCourses");
        ArrayList<String> courseList = new ArrayList<>();
        try {
            final JSONArray jArrayOfCourses = new JSONArray(jArrayString);
            for (int i = 0; i < jArrayOfCourses.length(); i++) {
                JSONObject course = (JSONObject) jArrayOfCourses.get(i);
                String courseStringView = course.getString("name") + "\n" + course.getString("code");
                courseList.add(courseStringView);
            }
            final ListView simpleList = (ListView) findViewById(R.id.simpleListView);
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.course_list_view, courseList);
            simpleList.setAdapter(arrayAdapter);
            simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    try {
                        Intent intent = new Intent(activity, CourseDetailActivity.class);
                        startActivity(intent);
                        JSONObject c = (JSONObject) jArrayOfCourses.get(i);
                        Toast.makeText(activity, c.getString("name") , Toast.LENGTH_LONG).show();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
