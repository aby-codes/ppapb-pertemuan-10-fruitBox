package com.android.fruitbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.fruitbox.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val buahName = intent.getStringExtra("buah_name").toString()
        val buahDescription = intent.getStringExtra("buah_description").toString()
        val buahPrice = intent.getStringExtra("buah_price").toString()
        val buahPict = intent.getIntExtra("buah_pict", 0)

        with(binding){
            txtNamaBuah.text = buahName
            txtDescBuah.text = buahDescription
            txtBuahPrice.text = buahPrice
            imgBuahImg.setImageResource(buahPict)

        }

    }
}