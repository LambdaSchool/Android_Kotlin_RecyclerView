package com.lambdaschool.android_kotlin_recyclerview

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.annotation.WorkerThread
import android.util.Log
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL

object HisNetworkAdapter {

    interface NetworkHttpCallback {
        fun returnResult(success: Boolean?, result: String)
    }

    @WorkerThread
    fun httpGetRequest(urlString: String, httpCallback: NetworkHttpCallback) {
        var result = ""
        var success = false
        var connection: HttpURLConnection? = null
        var stream: InputStream? = null
        try {
            val url = URL(urlString)
            connection = url.openConnection() as HttpURLConnection
            connection.connect()

            val responseCode = connection.responseCode
            if (responseCode == HttpURLConnection.HTTP_OK) {
                stream = connection.inputStream
                if (stream != null) {
                    val reader = BufferedReader(InputStreamReader(stream))
                    val builder = StringBuilder()
                    var line: String? = reader.readLine()
                    while (line != null) {
                        builder.append(line)
                        line = reader.readLine()
                    }
                    result = builder.toString()
                    success = true
                }
            } else {
                result = responseCode.toString()
            }
        } catch (e: MalformedURLException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            connection?.disconnect()

            if (stream != null) {
                try {
                    stream.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }

            }

            httpCallback.returnResult(success, result)
        }
    }

    interface NetworkBitmapCallback {
        fun returnResult(success: Boolean?, result: Bitmap?, requestUrl: String)
    }

    @WorkerThread
    fun getBitmapFromURL(urlString: String, callback: NetworkBitmapCallback) {
        var result: Bitmap? = null
        var success = false
        var connection: HttpURLConnection? = null
        try {

            val url = URL(urlString)
            connection = url.openConnection() as HttpURLConnection
            connection.doInput = true
            connection.connect()
            val input = connection.inputStream

            result = BitmapFactory.decodeStream(input)
            Log.i("Bitmaps", String.format("thumb %d", result.byteCount))
            success = true

        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            connection?.disconnect()
        }
        callback.returnResult(success, result, urlString)
    }
}