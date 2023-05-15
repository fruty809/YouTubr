package com.example.youtubeparcer.ui.details

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yotubepracer.databinding.VideosItemBinding
import com.example.youtubeparcer.core.ext.setImage


class DetailsAdapter: RecyclerView.Adapter<DetailsAdapter.DetailViewHolder> (){
    private val items = arrayListOf<com.example.youtubeparcer.data.model.Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        return DetailViewHolder(VideosItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<com.example.youtubeparcer.data.model.Item>){
        items.addAll(list as ArrayList<com.example.youtubeparcer.data.model.Item>)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class DetailViewHolder(private val binding:VideosItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(items:com.example.youtubeparcer.data.model.Item){
            binding.imageView.setImage(items.snippet.thumbnails.medium.url)
            binding.textView3.text = items.snippet.title
        }
    }

}