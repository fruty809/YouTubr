package com.example.youtubeparcer.data

import com.example.youtubeparcer.data.model.PlayList
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {
    @GET("playlists")
    suspend fun getPLayLists(
        @Query("key")key :String,
        @Query("part") part:String,
        @Query("channelId") channelId:String,

        ): Response<PlayList>

    @GET("playlistItems")
    fun getItem(
        @Query("key") key: String,
        @Query("part") part: String,
        @Query("maxResults") maxResults:Int,
        @Query("playlistId") playlistId: String,

        ): Call<PlayList>
}