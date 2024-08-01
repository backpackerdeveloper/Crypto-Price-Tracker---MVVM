package com.shubhamtripz.cryptopricetracker.ui

import android.os.Bundle
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.shubhamtripz.cryptopricetracker.R
import com.shubhamtripz.cryptopricetracker.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWebViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // -------- TOOLBAR CODE START -------
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        // Enable the back button


        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        // Handle back button click
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
        // -------- TOOLBAR CODE END ---------

        val url = intent.getStringExtra("url")
        if (url != null) {
            binding.webView.webViewClient = WebViewClient()
            binding.webView.loadUrl(url)
        } else {

            finish() // Close the activity if URL is null
        }
    }
}
