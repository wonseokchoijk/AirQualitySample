package com.wonsch.sentoze.airqualitysample
import android.os.AsyncTask
import android.util.Log
import com.google.gson.Gson
import com.wonsch.sentoze.airqualitysample.dto.Model
import okhttp3.OkHttpClient
import okhttp3.Request

class HttpConnection(activity: MainActivity): AsyncTask<String, String, Model>() {

    var activity: MainActivity? = null

    init {
        this.activity = activity
    }

    var client = OkHttpClient()
    var gson = Gson()

    override fun doInBackground(vararg params: String): Model? {
        val request = Request.Builder()
            .url(params[0])
            .get()
            .build()

        try {
            val response = client.newCall(request).execute()
            val responseStr = response.body()!!.string()

            Log.d("AirQualitySample", responseStr)

            return gson.fromJson<Model>(responseStr, Model::class.java)

        } catch (e: Exception) {
            e.printStackTrace()
        }

        return null
    }

    override fun onPostExecute(result: Model?) {
        super.onPostExecute(result)

        activity!!.textOutput!!.text = gson.toJson(result)
    }
}