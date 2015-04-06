package br.com.minitagbrasil.exampleslayoutapi;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * Created by ggarcia on 04/04/15.
 */
public class ExampleWebView extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //create a WebView by passing the context
        WebView web = new WebView(this);

        //get the web configurations then configure it
        WebSettings webSettings = web.getSettings();
        webSettings.setSavePassword(false);
        webSettings.setSaveFormData(false);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportZoom(false);

        //after settings, defines the URL of Google
        web.loadUrl("https://www.google.com");

        //set the WebView that will be shown
        setContentView(web);
    }
}
