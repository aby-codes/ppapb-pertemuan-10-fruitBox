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

        val buahName = intent.getStringExtra("fruit_name").toString()
        val buahDescription = intent.getStringExtra("fruit_description").toString()
        val buahPrice = intent.getStringExtra("fruit_price").toString()
        val buahPict = intent.getIntExtra("fruit_pict", 0)

        with(binding){
            txtNamaBuah.text = buahName
            txtDescBuah.text = buahDescription
            txtBuahPrice.text = buahPrice
            imgBuahImg.setImageResource(buahPict)

        }

    }
}