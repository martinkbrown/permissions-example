package edu.fsu.cs.mobile.example.permissions;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class PermissionsActivity extends Activity {
    
	private final String HOME_PAGE = "http://www.google.com";
	
	EditText mUrl;
	Button mGoButton;
	WebView mWebView;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        mUrl = (EditText) findViewById(R.id.editText1);
        mGoButton = (Button) findViewById(R.id.button1);
        mWebView = (WebView) findViewById(R.id.webView1);
        
        // if we remove this, then the system will open URLs in the default browser
        // instead of our WebView
        mWebView.setWebViewClient(new WebViewClient() {
        
        	@Override
        	public boolean shouldOverrideUrlLoading(WebView view, String url)
        	{
        		return false;
        	}
        });
        
        mWebView.loadUrl(HOME_PAGE);
        
        mGoButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				
				// This will not load if the proper permissions are not set
				// in the Android Manifest file. Take a look at the XML behind
				// the manifest file
				mWebView.loadUrl("http://" +  mUrl.getText().toString());
				
			}
		});
    }
}