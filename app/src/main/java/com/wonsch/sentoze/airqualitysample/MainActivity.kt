package com.wonsch.sentoze.airqualitysample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val tag = "AirQualitySample"
    private val apiUrl = "https://api.waqi.info/feed/%s?token=%s"
    private val apiUrlGeoInfo = "geo:%s;%s/"
    private val apiToken = "1630cf5a23d06c32cb0aef1ef7cea3341108096d"

    var textOutput: TextView? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textOutput = findViewById<TextView>(R.id.text_output)

        execute_button.setOnClickListener {
            sendData()
        }
    }

    fun sendData() {
        val url = String.format(apiUrl, String.format(apiUrlGeoInfo, "35.6687808", "139.6626877"), apiToken)
        Log.d(tag, "url : $url")
        var httpConn = HttpConnection(this)
        httpConn.execute(url)
    }
}

