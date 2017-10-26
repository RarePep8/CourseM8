package com.rarepep8.coursem8;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /* set view to activity_main */
        setContentView(R.layout.activity_main);
        /* set up topbar */
        final Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        /* Get a support ActionBar corresponding to this toolbar */
        /* ActionBar upSupport = getSupportActionBar(); */

        /* Enable the Up button */
        /* upSupport.setDisplayHomeAsUpEnabled(true); */

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                Intent i = new Intent(this, CourseSelectActivity.class);
                startActivity(i);
            case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
                return true;
            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


}
