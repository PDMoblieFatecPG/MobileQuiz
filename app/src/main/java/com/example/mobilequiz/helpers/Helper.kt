package com.example.mobilequiz.helpers
import android.content.Context
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader


fun getJsonDataFromAsset(context: Context, fileName: String): String? {
    return try {
        val json = context.assets.open(fileName)
        val reader = BufferedReader(InputStreamReader(json))
        reader.toString()
    } catch (ioException: IOException) {
        ioException.printStackTrace()
        null
    }
}