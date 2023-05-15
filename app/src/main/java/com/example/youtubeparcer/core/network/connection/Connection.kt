package com.example.youtubeparcer.core.network.connection

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkRequest
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData


class Connection(private val manager: ConnectivityManager): LiveData<Boolean>() {
    constructor(application: Application):this(
        application.getSystemService(Context.CONNECTIVITY_SERVICE)as ConnectivityManager
    )
    private val networkCallback = @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    object: ConnectivityManager.NetworkCallback(){
        override fun onAvailable(network: Network) {
            super.onAvailable(network)
            postValue(true)
        }

        override fun onLost(network: Network) {
            super.onLost(network)
            postValue(false)
        }
    }
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onActive() {
        val builder = NetworkRequest.Builder()
        manager.registerNetworkCallback(builder.build(), networkCallback)

    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onInactive() {
        super.onInactive()
        manager.unregisterNetworkCallback(networkCallback)
    }
}