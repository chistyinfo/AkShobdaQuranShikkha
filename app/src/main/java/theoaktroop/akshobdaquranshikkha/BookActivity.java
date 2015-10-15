package theoaktroop.akshobdaquranshikkha;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class BookActivity extends AppCompatActivity {

    String bookName;
    String titleString;
    String curURL;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        bookName = intent.getStringExtra("book_name");

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        toolbar.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                System.out.println("Toolbar onTouch()");
//                finish();
//                return false;
//            }
//        });

        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Toolbar onClick()");
            }
        });



        initialize();
    }

    private void initialize() {


        if(bookName.equals("ekShobdaQuranShikkha")){
            curURL = "file:///android_asset/ekshobdaQuranSikkha.html";
            titleString = "একশব্দে কুরআন শিক্ষা";
        }
        else if(bookName.equals("shundorKoushol")){
            curURL = "file:///android_asset/ekshobdaQuranSikkha.html";
            titleString = "একশব্দে কুরআন শিখানোর সুন্দর কৌশল";
        }
        else if(bookName.equals("talimulQuran")){
            curURL = "file:///android_asset/ekshobdaQuranSikkha.html";
            titleString = "শব্দার্থে তা'লীমুল কুরআন";
        }
        else if(bookName.equals("duaOZikr")){
            curURL = "file:///android_asset/ekshobdaQuranSikkha.html";
            titleString = "দুয়া ও যিকর";
        }

        toolbar.setTitle(titleString);

        WebView webview = (WebView) findViewById(R.id.bookWebViewFromActivity);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.setWebViewClient(new webClient());
        webview.loadUrl(curURL);

    }

    private class webClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            return false;

        }

    }
}