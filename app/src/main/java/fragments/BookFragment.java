package fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import theoaktroop.akshobdaquranshikkha.R;


public class BookFragment extends Fragment{

    public BookFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        String curURL = "file:///android_asset/ekshobdaQuranSikkha.html";


        View view = inflater.inflate(R.layout.fragment_book, container, false);


        if (curURL != null) {

            WebView webview = (WebView) view.findViewById(R.id.bookWebView);

            webview.getSettings().setJavaScriptEnabled(true);

            webview.setWebViewClient(new webClient());

            webview.loadUrl(curURL);

        }


        return view;
    }

    private class webClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            return false;

        }

    }

}
