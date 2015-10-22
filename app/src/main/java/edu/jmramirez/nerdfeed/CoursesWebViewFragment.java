package edu.jmramirez.nerdfeed;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class CoursesWebViewFragment extends Fragment {

    Activity parentActivity;
    String url;
    WebView coursesWebView;


    public CoursesWebViewFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_courses_web_view, container, false);
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        parentActivity = getActivity();


        if (parentActivity.findViewById(R.id.fragment_detail) != null) {
//            String argument = getArguments().getString("url");

        } else {
            url = parentActivity.getIntent().getStringExtra("url");
        }

        if (url == null || url.length() == 0) {
            url = "http://d.android.com";
        }

        coursesWebView = (WebView) parentActivity.findViewById(R.id.coursesWebView);

        if(coursesWebView != null){
            updateURL(url);
        }
        Toast.makeText(parentActivity, "Opening: " + url,
                Toast.LENGTH_LONG).show();
    }

    protected void loadURL (Context context){
        coursesWebView.loadUrl(url);
        coursesWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }

    public void updateURL(String url){
        this.url = url;
        loadURL(parentActivity);
    }

}
