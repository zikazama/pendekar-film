package com.dicoding.tourismapp.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.tourismapp.core.R
import com.dicoding.tourismapp.core.databinding.ItemListTourismBinding
import com.dicoding.tourismapp.core.domain.model.Tourism

class TourismAdapter : RecyclerView.Adapter<TourismAdapter.ListViewHolder>() {

    private var listData = ArrayList<Tourism>()
    var onItemClick: ((Tourism) -> Unit)? = null

    fun setData(newListData: List<Tourism>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list_tourism, parent, false))

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListTourismBinding.bind(itemView)
        fun bind(data: Tourism) {
            with(binding) {
                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w500" +data.poster_path)
                    .into(ivItemImage)
                tvItemTitle.text = data.original_title
                tvItemSubtitle.text = data.release_date
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }
}