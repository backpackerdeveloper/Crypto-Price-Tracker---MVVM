package com.shubhamtripz.cryptopricetracker.ui

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.facebook.shimmer.ShimmerFrameLayout
import com.shubhamtripz.cryptopricetracker.databinding.ActivityMainBinding
import com.shubhamtripz.cryptopricetracker.viewmodel.CryptoViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var shimmerFrameLayout: ShimmerFrameLayout
    private val viewModel: CryptoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        shimmerFrameLayout = binding.shimmerViewContainer
        shimmerFrameLayout.startShimmer()

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.cryptos.observe(this, Observer { cryptos ->
            shimmerFrameLayout.stopShimmer()
            shimmerFrameLayout.hideShimmer()
            binding.recyclerView.adapter = CryptoAdapter(cryptos)
            binding.recyclerView.visibility = View.VISIBLE
        })
    }
}
