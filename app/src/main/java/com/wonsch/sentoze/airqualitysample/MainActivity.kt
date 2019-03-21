package com.wonsch.sentoze.airqualitysample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private val tag = "AirQualitySample"

    private var httpConn: HttpConnection = HttpConnection.instance

    private val apiUrl = "http://api.waqi.info/feed/%s"
    private val apiUrlGeoInfo = "geo:$1;$2/"
    private val apiToken = "1630cf5a23d06c32cb0aef1ef7cea3341108096d"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        execute_button.setOnClickListener {
            sendData()
        }
    }

    fun sendData() {
        Thread() {
            fun run() {

                val url = String.format(apiUrl, String.format(apiUrlGeoInfo, "geo:35.6687808", "139.6626877"))

                httpConn.requestWebServer(url, apiToken, callBack)
            }
        }.start()
    }

    var callBack = object: Callback {
        override fun onFailure(call: Call, e: IOException) {
            Log.d(tag, "Callback error: ${e.message}")
        }

        override fun onResponse(call: Call, response: Response) {
            var body = response.body().toString()
            text_output.text = body
            Log.d(tag, "response body: $body")
        }
    }
}
