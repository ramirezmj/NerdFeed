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

public class CoursesFragment extends Fragment {

    OnCourseItemSelectedListener mCallback;

    public interface OnCourseItemSelectedListener {
        public void OnCourSeItemSelected(int position, String url);
    }

    Activity parentActivity;
    String[] urlsArray;

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
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception.
        try {
            mCallback = (OnCourseItemSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnCourseItemSelected");
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Reference to the parent activity
        parentActivity = getActivity();

        // Reference to the courses list ListView
        ListView coursesListView = (ListView) parentActivity.findViewById(R.id.coursesListView);
        urlsArray = getResources().getStringArray(R.array.urls);


        // ArrayAdapter with the list of courses
        ArrayAdapter<CharSequence> coursesAdapter = ArrayAdapter
                .createFromResource(parentActivity, R.array.courses, R.layout.course_cell);
        coursesListView.setAdapter(coursesAdapter);

        coursesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                mCallback.OnCourSeItemSelected(position, urlsArray[position]);
            }
        });
    }

}
