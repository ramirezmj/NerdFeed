package edu.jmramirez.nerdfeed;


import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
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

        url = parentActivity.getIntent().getStringExtra("url");

        if (url == null || url.length() == 0) {
            url = "www.apple.com";
        }


        WebView coursesWebView = (WebView) parentActivity.findViewById(R.id.coursesWebView);

        if(coursesWebView != null){
            coursesWebView.loadUrl(url);
            coursesWebView.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return true;
                }
            });
        }
        Toast.makeText(parentActivity, "Opening: " + url,
                Toast.LENGTH_LONG).show();
    }
}
