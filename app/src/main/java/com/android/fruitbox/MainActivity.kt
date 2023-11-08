package com.android.fruitbox

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.fruitbox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var fruitAdapter = FruitAdapter(generateBuahData()) { fruit ->
            val intent = Intent(this@MainActivity, DetailActivity::class.java)
            intent.putExtra("fruit_name", fruit.name)
            intent.putExtra("fruit_description", fruit.description)
            intent.putExtra("fruit_price", fruit.price)
            intent.putExtra("fruit_pict", fruit.pict)
            startActivity(intent)
        }

        with(binding) {
            rycItem.apply {
                adapter = fruitAdapter
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }
    }
    fun generateBuahData(): List<Fruit> {
        return listOf(
            Fruit(name = "Stroberi", price = "10000", pict = R.drawable.stroberi, description = "Stroberi adalah buah kecil berwarna merah cerah yang sangat manis dan enak. Mereka sering digunakan dalam berbagai hidangan, seperti selai, kue, dan yogurt. Stroberi kaya akan vitamin C dan serat."),
            Fruit(name = "Pisang", price = "15000", pict = R.drawable.pisang, description = "Pisang adalah buah yang populer dengan kulit kuning yang mudah dikupas. Rasanya manis dan lezat. Pisang mengandung banyak kalium, vitamin C, dan serat, sehingga baik untuk kesehatan jantung dan pencernaan."),
            Fruit(name = "Apel", price = "9000", pict = R.drawable.apel, description = "Apel adalah buah yang sangat umum dan dikenal dengan kulitnya yang berwarna merah atau hijau. Mereka memiliki rasa manis dan segar. Apel kaya akan serat dan vitamin C, baik untuk kesehatan tubuh dan sistem kekebalan."),
            Fruit(name = "Kiwi", price = "12000", pict = R.drawable.kiwi, description = "Kiwi adalah buah kecil berkulit berambut dengan daging hijau dan biji kecil di dalamnya. Mereka memiliki rasa asam manis yang unik. Kiwi mengandung vitamin C yang sangat tinggi, serat, dan nutrisi penting lainnya."),
            Fruit(name = "Delima", price = "20000", pict = R.drawable.delima, description = "Delima adalah buah dengan biji kecil yang terbungkus dalam biji merah yang empuk. Buah ini memiliki rasa manis dengan sentuhan asam. Delima dikenal sebagai sumber antioksidan yang kuat dan memiliki manfaat kesehatan yang beragam."),
        )
    }


}