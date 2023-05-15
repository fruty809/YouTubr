package com.example.youtubeparcer.ui

import androidx.lifecycle.LiveData
import com.example.youtubeparcer.App
import com.example.youtubeparcer.base.BaseViewModel
import com.example.youtubeparcer.core.network.result.Resource
import com.example.youtubeparcer.data.model.PlayList


class PlayListViewModel: BaseViewModel() {
    fun playList(): LiveData<Resource<PlayList>> {
        return App.repository.getPlayList()
    }
}