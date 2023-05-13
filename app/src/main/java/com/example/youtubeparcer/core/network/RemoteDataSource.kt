package com.example.youtubeparcer.core.network

import com.example.yotubepracer.BuildConfig
import com.example.youtubeparcer.core.network.result.Resource
import com.example.youtubeparcer.data.ApiService
import com.example.youtubeparcer.data.model.PlayList
import com.example.youtubeparcer.utils.Const


class RemoteDataSource: BaseDataSource() {
    val apiService: ApiService = RetrofitClient.create()
    suspend fun getPlayList(): Resource<PlayList> {
        return getResult {
            apiService.getPLayLists(BuildConfig.API_KEY, Const.part, Const.channelId)
        }
    }
}