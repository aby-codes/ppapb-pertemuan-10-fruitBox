package com.android.fruitbox

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.fruitbox.databinding.ItemListBinding

typealias OnClickBuah = (Fruit) -> Unit

class FruitAdapter(private val listBuah: List<Fruit>, private val onClickFruit: (Fruit) -> Unit) :
    RecyclerView.Adapter<FruitAdapter.FruitItemViewHolder>() {

    inner class FruitItemViewHolder(val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Fruit) {
            with(binding) {
                itemName.text = data.name
                itemPrice.text = data.price

                itemView.setOnClickListener {
                    onClickFruit(data)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitItemViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FruitItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listBuah.size
    }

    override fun onBindViewHolder(holder: FruitItemViewHolder, position: Int) {
        val fruit = listBuah[position]
        holder.bind(fruit)
        holder.binding.itemPict.setImageResource(fruit.pict)

        holder.itemView.setOnClickListener {
            onClickFruit(fruit)
        }
    }

}