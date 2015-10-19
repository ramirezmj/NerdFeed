package edu.jmramirez.nerdfeed;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView coursesListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coursesListView = (ListView) findViewById(R.id.coursesListView);

        ArrayAdapter<CharSequence> coursesAdapter = ArrayAdapter
                .createFromResource(this, R.array.courses, R.layout.course_cell);
        coursesListView.setAdapter(coursesAdapter);

    }
}
