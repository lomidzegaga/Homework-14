package com.example.homework_14.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_14.databinding.CustomItemBinding
import com.example.homework_14.model.MainDataClass

class MainAdapter :
    ListAdapter<MainDataClass.Content, MainAdapter.MainViewHolder>(
        ItemCallBack
    ) {

    inner class MainViewHolder(private val binding: CustomItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val items = getItem(adapterPosition)
            binding.apply {
                tvData.text = items.publishDate
                tvTitle.text = items.titleKA
                tvBody.text = items.descriptionKA
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            CustomItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind()
    }

}

object ItemCallBack : DiffUtil.ItemCallback<MainDataClass.Content>() {
    override fun areItemsTheSame(
        oldItem: MainDataClass.Content,
        newItem: MainDataClass.Content
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: MainDataClass.Content,
        newItem: MainDataClass.Content
    ): Boolean {
        return oldItem == newItem
    }

}
