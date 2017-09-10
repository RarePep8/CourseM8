package com.rarepep8.coursem8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button = (Button) findViewById(R.id.add_course_id);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                selectCourse();
            }
        });
    }
    protected void selectCourse() {
        Intent i = new Intent(this, CourseSelectActivity.class);
        startActivity(i);
    }

}
