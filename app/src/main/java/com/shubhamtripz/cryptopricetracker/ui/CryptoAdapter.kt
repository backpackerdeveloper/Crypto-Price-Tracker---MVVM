package com.shubhamtripz.cryptopricetracker.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.shubhamtripz.cryptopricetracker.R
import com.shubhamtripz.cryptopricetracker.data.Crypto

class CryptoAdapter(private var cryptoList: List<Crypto>) : RecyclerView.Adapter<CryptoAdapter.CryptoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_crypto, parent, false)
        return CryptoViewHolder(view)
    }

    override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) {
        val crypto = cryptoList[position]
        holder.bind(crypto)
    }

    override fun getItemCount(): Int = cryptoList.size

    fun updateData(newCryptoList: List<Crypto>) {
        cryptoList = newCryptoList
        notifyDataSetChanged()
    }

    inner class CryptoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        private val priceTextView: TextView = itemView.findViewById(R.id.priceTextView)
        private val rankTextView: TextView = itemView.findViewById(R.id.rankTextView)
        private val viewMoreButton: Button = itemView.findViewById(R.id.viewMoreButton)

        fun bind(crypto: Crypto) {
            nameTextView.text = crypto.name
            priceTextView.text = crypto.priceUsd
            rankTextView.text = crypto.rank

            viewMoreButton.setOnClickListener {
                val context = itemView.context
                val intent = Intent(context, WebViewActivity::class.java).apply {
                    putExtra("url", crypto.explorer)
                }
                context.startActivity(intent)
                if (context is AppCompatActivity) {
                    context.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                }
            }
        }
    }
}
