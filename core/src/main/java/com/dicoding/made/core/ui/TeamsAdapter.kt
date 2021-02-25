package com.dicoding.made.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.made.core.R
import com.dicoding.made.core.databinding.ItemListTeamBinding
import com.dicoding.made.core.domain.model.Teams


class TeamsAdapter : RecyclerView.Adapter<TeamsAdapter.ListViewHolder>() {
    private var listData = ArrayList<Teams>()
    var onItemClick: ((Teams) -> Unit)? = null

    fun setData(newListData : List<Teams>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list_team, parent, false))

    override fun onBindViewHolder(holder: TeamsAdapter.ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = listData.size

    inner class ListViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListTeamBinding.bind(itemView)

        fun bind(data : Teams) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(data.strTeamBadge)
                    .into(ivItemBadge)
                tvTeamName.text = data.strTeam

            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }
}