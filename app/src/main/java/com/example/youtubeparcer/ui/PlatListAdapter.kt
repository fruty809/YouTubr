package com.example.youtubeparcer.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yotubepracer.databinding.PlaylistItemBinding
import com.example.youtubeparcer.core.ext.setImage
import com.example.youtubeparcer.data.model.Item


class PlayListsAdapter(private val onClick: (Item) -> Unit): RecyclerView.Adapter<PlayListsAdapter.PlayListViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun setData(lists:List<Item>){
        this.myDataList = lists as ArrayList<Item>
        notifyDataSetChanged()
    }

    private var myDataList = arrayListOf<Item>()

    inner class PlayListViewHolder(private val binding: PlaylistItemBinding): RecyclerView.ViewHolder(binding.root){
        @SuppressLint("SetTextI18n")
        fun bind(item: Item){
            binding.namePlaylist.text = item.snippet.title
            binding.videos.text = "${item.contentDetails.itemCount} video series"
            binding.playlist.setImage(item.snippet.thumbnails.default.url)
            binding.container.setOnClickListener{
                onClick.invoke(item)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayListViewHolder {
        return PlayListViewHolder(PlaylistItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return  myDataList.size
    }

    override fun onBindViewHolder(holder: PlayListViewHolder, position: Int) {
        holder.bind(myDataList[position] )
    }
}