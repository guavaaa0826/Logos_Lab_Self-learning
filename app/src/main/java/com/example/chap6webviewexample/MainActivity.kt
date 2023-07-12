package com.example.chap6webviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {

    private lateinit var myWebView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myWebView = findViewById(R.id.webView)

        // To get Internet permission, you need to do the following changes in AndroidManifest.xml:
        // 1. add uses-permission of Internet and Wi-Fi connection.
        // 2. set the property "android:usesCleartextTraffic" of the application to true if the Android OS is after 9.0.

//        myWebView.loadUrl("https://www.youtube.com/watch?v=miD_TWmdGIY&t=80s")
        myWebView.loadUrl("https://www.google.com")
        myWebView.webViewClient = WebViewClient()
    }

    // This function tell us how the app work if the "Back" button if System is pressed.
    override fun onBackPressed() {
        if (myWebView.canGoBack()) {
            myWebView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}