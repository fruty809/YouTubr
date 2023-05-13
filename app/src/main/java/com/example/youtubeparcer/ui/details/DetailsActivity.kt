package com.example.youtubeparcer.ui.details

import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yotubepracer.databinding.ActivityVideosBinding
import com.example.youtubeparcer.base.BaseActivity
import com.example.youtubeparcer.core.network.connection.Connection
import com.example.youtubeparcer.data.model.Item


class DetailsActivity : BaseActivity<ActivityVideosBinding, DetailsVIewModel>() {
    private lateinit var adapter: DetailsAdapter
    private val data = arrayListOf<Item>()
    private val id:String?
        get() = intent.getStringExtra(ID)



    override val viewModel: DetailsVIewModel by lazy {
        ViewModelProvider(this)[DetailsVIewModel::class.java]
    }
    override fun isConnection() {
        super.isConnection()
        val connection = Connection(application)
        connection.observe(this){isConnected->
            if (isConnected){

                binding.noInet.visibility = View.GONE
            }
            else{
                binding.noInet.visibility = View.VISIBLE
            }
        }

    }

    override fun initViews() {
        super.initViews()
        binding.btnBack.setOnClickListener {
            finish()
        }

    }

    override fun initViewModel() {
        super.initViewModel()
        setItemList()

    }
    private fun setItemList(){
        id?.let { id->
            viewModel.itemList(id).observe(this){
                binding.videosRv.layoutManager = LinearLayoutManager(this)
                adapter = DetailsAdapter()
                adapter.setList(it.items)
                binding.videosRv.adapter = adapter

            }
        }
    }

    override fun initListener() {
        super.initListener()
        val title = intent.getStringExtra(TITLE)
        val desc = intent.getStringExtra(DESC)
        val count = intent.getStringExtra(COUNT)
        binding.tvTitle.text = title
        binding.tvDesc.text = desc

    }

    override fun inflateViewBinding(): ActivityVideosBinding {
        return ActivityVideosBinding.inflate(layoutInflater)
    }
    companion object{
        const val ID = "id"
        const val TITLE = "title"
        const val DESC = "desc"
        const val COUNT = "count"
    }
}
