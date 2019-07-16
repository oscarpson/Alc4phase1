package com.oscar.ke.andelaandroidchallenge

import android.net.http.SslError
import android.os.Bundle
import android.webkit.*
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;

import kotlinx.android.synthetic.main.activity_about_alc.*
import kotlinx.android.synthetic.main.content_about_alc.*

class AboutAlc : AppCompatActivity() {
lateinit var webView: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_alc)
        setSupportActionBar(toolbar)
        webView=findViewById(R.id.webview)
        webView.settings.domStorageEnabled=true
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        webView!!.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }

            override fun onReceivedError(view: WebView?, request: WebResourceRequest?, error: WebResourceError?) {
                super.onReceivedError(view, request, error)
                Toast.makeText(applicationContext,"error occured",Toast.LENGTH_SHORT)
            }

            override fun onReceivedSslError(view: WebView?, handler: SslErrorHandler?, error: SslError?) {
                super.onReceivedSslError(view, handler, error)
                handler?.proceed()
            }
        }
        webView.settings.javaScriptEnabled=true
        webView.loadUrl("https://andela.com/alc/")//http://www.google.com"

    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

}
