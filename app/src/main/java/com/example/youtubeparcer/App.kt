package com.example.youtubeparcer

import android.app.Application
import com.example.youtubeparcer.repository.Repository


class App: Application() {
    companion object{
        val repository: Repository by lazy {
            Repository()
        }
    }

}