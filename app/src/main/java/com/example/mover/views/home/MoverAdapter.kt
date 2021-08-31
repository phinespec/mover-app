package com.example.mover.views.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mover.R
import com.example.mover.databinding.ListItemMoverBinding
import com.example.mover.Network.Mover

class MoverAdapter (
    val viewModel: HomeViewModel
): ListAdapter<Mover, MoverAdapter.MoverViewHolder>(MoverListDiffCallback()) {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MoverAdapter.MoverViewHolder {
        val view =
            ListItemMoverBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoverViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: MoverAdapter.MoverViewHolder,
        position: Int
    ) {
        holder.bind(position)
    }

    inner class MoverViewHolder(val binding: ListItemMoverBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {

            var item = getItem(position)

            binding.mainLayout.setOnClickListener {
                viewModel.setMover(item)
            }

            var moverName = binding.moverName
            var avatar = binding.moverAvatar

            moverName.text = item.name
            avatar.setImageResource(R.drawable.placeholder)


        }
    }

}

class MoverListDiffCallback : DiffUtil.ItemCallback<Mover>() {

    override fun areItemsTheSame(oldItem: Mover, newItem: Mover): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Mover, newItem: Mover): Boolean {
        return oldItem.id == newItem.id
    }

}