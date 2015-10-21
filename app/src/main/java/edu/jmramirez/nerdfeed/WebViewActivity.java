package edu.jmramirez.nerdfeed;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class WebViewActivity extends Activity {

    FragmentManager fragmentManager;
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
        transaction.add(R.id.fragment_container, coursesWebViewFragment);

        // Commit the FragmentTransaction
        transaction.commit();
    }
}
