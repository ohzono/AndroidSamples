package com.example.coroutinestudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), CoroutineScope {

    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textview = findViewById<TextView>(R.id.text)

        val mockApi = MockApi()

        launch {
            textview.text = "updated"

            val text = async (context = Dispatchers.IO) {
               mockApi.request()
            }.await()

            textview.text = text
        }
    }

    override fun onDestroy() {
        job.cancel()
        super.onDestroy()
    }
}
