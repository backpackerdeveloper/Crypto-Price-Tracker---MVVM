package com.shubhamtripz.cryptopricetracker.ui

import android.os.Bundle
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.shubhamtripz.cryptopricetracker.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWebViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val url = intent.getStringExtra("url")
        if (url != null) {
            binding.webView.webViewClient = WebViewClient()
            binding.webView.loadUrl(url)
        } else {
            // Handle the case where the URL is null
            // You can show an error message or close the activity
            finish() // Close the activity if URL is null
        }
    }
}
