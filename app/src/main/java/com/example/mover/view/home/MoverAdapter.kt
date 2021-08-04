package com.example.mover.view.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mover.databinding.ListItemMoverBinding
import com.example.mover.model.database.Mover

class MoverAdapter (
): ListAdapter<Mover, MoverAdapter.ExampleViewHolder>(ExampleListDiffCallback()) {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MoverAdapter.ExampleViewHolder {
        val view =
            ListItemMoverBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ExampleViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: MoverAdapter.ExampleViewHolder,
        position: Int
    ) {
        holder.bind(position)
    }

    inner class ExampleViewHolder(val binding: ListItemMoverBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {

            val item = getItem(position)

            binding.mainLayout.setOnClickListener {

            }

        }
    }

}

class ExampleListDiffCallback : DiffUtil.ItemCallback<Mover>() {

    override fun areItemsTheSame(oldItem: Mover, newItem: Mover): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Mover, newItem: Mover): Boolean {
        return oldItem.id == newItem.id
    }

}