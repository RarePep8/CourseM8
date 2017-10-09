package com.rarepep8.coursem8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CourseDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        this.finish();
    }
}
