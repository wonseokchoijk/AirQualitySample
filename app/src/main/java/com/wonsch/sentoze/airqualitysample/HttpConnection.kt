package com.wonsch.sentoze.airqualitysample

import okhttp3.Callback
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request

class HttpConnection private constructor() {

    private val client: OkHttpClient

    init {
        this.client = OkHttpClient()
    }


    /** Web Server Requesting  */
    fun requestWebServer(url: String, token: String, callback: Callback) {
        val body = FormBody.Builder()
            .add("token", token)
            .build()
        val request = Request.Builder()
            .url(url)
            .post(body)
            .build()
        client.newCall(request).enqueue(callback)
    }

    // for Single Tone Pattern
    companion object {
        val instance = HttpConnection()
    }
}

