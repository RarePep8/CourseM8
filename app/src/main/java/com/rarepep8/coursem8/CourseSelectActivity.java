package com.rarepep8.coursem8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CourseSelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_select);
        onSearchRequested();
    }

    @Override
    public void onResume(){
        super.onResume();
        onSearchRequested();
    }
}
