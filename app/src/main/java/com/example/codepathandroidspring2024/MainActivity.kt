package com.example.codepathandroidspring2024

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.RequestParams
import com.codepath.asynchttpclient.callback.TextHttpResponseHandler
import okhttp3.Headers

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getMovies()
    }

    private fun getMovies(){
        val client = AsyncHttpClient()
        val params = RequestParams()
        //params["limit"] = "5"
        //params["page"] = "0"
        client["https://api.themoviedb.org/3/movie/now_playing?&api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed", params, object :
            TextHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Headers, response: String) {
                // called when response HTTP status is "200 OK"
                println(response)
            }

            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                errorResponse: String,
                t: Throwable?
            ) {
                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
                println(errorResponse)
            }
        }]
    }
}