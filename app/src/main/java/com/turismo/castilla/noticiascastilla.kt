package com.turismo.castilla

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient

class noticiascastilla : AppCompatActivity() {
    lateinit var visor: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_noticiascastilla)

        visor= findViewById<WebView>(R.id.webnoticias)

        visor.webChromeClient = object : WebChromeClient(){
        }
        visor.webViewClient = object  : WebViewClient(){
        }
        val settings:WebSettings = visor.settings
        settings.javaScriptEnabled = true
        settings.domStorageEnabled = true

        visor.loadUrl("https://aqptecnologias.com/blogcastilla/")


    }

    override fun onBackPressed() {
        if(visor.canGoBack()){
            visor.goBack()
        } else{
            super.onBackPressed()
        }


    }







}