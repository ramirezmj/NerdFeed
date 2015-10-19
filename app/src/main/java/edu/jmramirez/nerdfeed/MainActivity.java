package edu.jmramirez.nerdfeed;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

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

        coursesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final TextView mTextView = (TextView)view;
                switch (position) {
                    case 0:
                        Intent newActivity0 = new Intent(MainActivity.this, WebViewActivity.class);
                        startActivity(newActivity0);
                        break;
                    case 1:
                        Intent newActivity1 = new Intent(MainActivity.this,WebViewActivity.class);
                        startActivity(newActivity1);
                        break;
                    case 2:
                        Intent newActivity2 = new Intent(MainActivity.this,WebViewActivity.class);
                        startActivity(newActivity2);
                        break;
                    case 3:
                        Intent newActivity3 = new Intent(MainActivity.this,WebViewActivity.class);
                        startActivity(newActivity3);
                        break;
                    default:
                        // Nothing do!
                }

            }
        });
    }


}
