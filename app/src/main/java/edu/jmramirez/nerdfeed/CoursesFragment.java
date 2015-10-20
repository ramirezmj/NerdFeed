package edu.jmramirez.nerdfeed;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CoursesFragment extends Fragment {

    Activity parentActivity;

    public CoursesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_courses, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Reference to the parent activity
        parentActivity = getActivity();

        // Reference to the courses list ListView
        ListView coursesListView = (ListView) parentActivity.findViewById(R.id.coursesListView);

        // ArrayAdapter with the list of courses
        ArrayAdapter<CharSequence> coursesAdapter = ArrayAdapter
                .createFromResource(parentActivity, R.array.courses, R.layout.course_cell);
        coursesListView.setAdapter(coursesAdapter);

        coursesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(parentActivity, CoursesWebViewFragment.class);
                intent.putExtra("url", "www.google.es");
                startActivity(intent);
            }
        });
    }

}
