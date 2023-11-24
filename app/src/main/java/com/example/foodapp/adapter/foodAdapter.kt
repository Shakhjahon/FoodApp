package com.example.foodapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodapp.interfaces.FoodItemClickLisner
import com.example.foodapp.R
import com.example.foodapp.databinding.FoodItemBinding
import com.example.foodapp.model.foodModel


class foodAdapter(
    private val foodItemClickLisner: FoodItemClickLisner
)
    : RecyclerView.Adapter<foodAdapter.FoodViewHolder>() {

    var foodList = mutableListOf<foodModel>()

    fun upfoodList(movieList: List<foodModel>) {
        foodList.clear()
        foodList.addAll(movieList)
        notifyDataSetChanged()
    }

    inner class FoodViewHolder(private val binding: FoodItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(foodModel: foodModel) {
            binding.cardView.setOnClickListener{
                foodItemClickLisner.foodItemClick()
            }
            binding.text.text = foodModel.imgUrl
            binding.price.text = foodModel.price
            Glide.with(binding.root)
                .load(foodModel.Food)
                .into(binding.foodVegSalat)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int,
    ): FoodViewHolder {
        val binding = FoodItemBinding.bind(
            LayoutInflater.from(parent.context).inflate(R.layout.food_item, parent, false)
        )
        return FoodViewHolder(binding)
    }

    override fun getItemCount(): Int = foodList.size


    override fun onBindViewHolder(
        holder: foodAdapter.FoodViewHolder,
        position: Int,
    ){
        holder.bind(foodList[position])
    }
}
