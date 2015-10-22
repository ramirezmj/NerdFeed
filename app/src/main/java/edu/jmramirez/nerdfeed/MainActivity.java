package edu.jmramirez.nerdfeed;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;


public class MainActivity extends FragmentActivity
        implements CoursesFragment.OnCourseItemSelectedListener {


    FragmentManager fragmentManager;
    CoursesFragment coursesFragment = new CoursesFragment();
    CoursesWebViewFragment coursesWebViewFragment = new CoursesWebViewFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Reference to the fragmentManager
        fragmentManager = getFragmentManager();

        // Start a new FragmentTransaction
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        // Add the CoursesFragment to the layout
        transaction.add(R.id.fragment_container, coursesFragment);

        if (findViewById(R.id.fragment_detail) != null) {
            transaction.add(R.id.fragment_detail, coursesWebViewFragment);
        }

        // Commit the FragmentTransaction
        transaction.commit();
    }


    @Override
    public void OnCourSeItemSelected(int position, String url) {

        if (findViewById(R.id.fragment_detail) != null) {

            coursesWebViewFragment.updateURL(url);
        } else {

            Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
            intent.putExtra("url", url);
            startActivity(intent);
        }
    }
}
