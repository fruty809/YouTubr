package com.example.youtubeparcer.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.example.yotubepracer.BuildConfig
import com.example.youtubeparcer.core.network.RemoteDataSource
import com.example.youtubeparcer.core.network.RetrofitClient
import com.example.youtubeparcer.core.network.result.Resource
import com.example.youtubeparcer.data.ApiService
import com.example.youtubeparcer.data.model.PlayList
import com.example.youtubeparcer.utils.Const
import kotlinx.coroutines.Dispatchers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Repository {
    private val dataSource: RemoteDataSource by lazy {
        RemoteDataSource()
    }
    private val apiService: ApiService by lazy {
        RetrofitClient.create()
    }

    fun getPlayList(): LiveData<Resource<PlayList>> {
        return liveData (Dispatchers.IO ){
            val data = MutableLiveData<Resource<PlayList>>()
            data.postValue(Resource.loading())
            emit(Resource.loading())
            val response =  dataSource.getPlayList()
            emit(response)
        }


    }
    fun getListItem(id:String):LiveData<PlayList>{

        val data = MutableLiveData<PlayList>()
        apiService.getItem(BuildConfig.API_KEY, Const.part,Const.maxResults,id).enqueue(object :
            Callback<PlayList> {
            override fun onResponse(call: Call<PlayList>, response: Response<PlayList>) {
                if (response.isSuccessful){
                    data.value = response.body()
                }
            }

            override fun onFailure(call: Call<PlayList>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
        return data
    }
}