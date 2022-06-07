package com.bitcode.customview3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var graphView : GraphView
    private lateinit var btnRefresh : Button
    private val marks = IntArray(5)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        marks[0] = 90
        marks[1] = 80
        marks[2] = 60
        marks[3] = 50
        marks[4] = 70

        setContentView(R.layout.activity_main)
        graphView = findViewById(R.id.graphView)
        btnRefresh = findViewById(R.id.btnRefresh)

        graphView.values = marks

        btnRefresh.setOnClickListener{
            var random = Random()

            var arraySize = Math.abs( random.nextInt() ) % 8 + 1
            var values = IntArray(arraySize, {index -> Math.abs(random.nextInt()) % 101})

            graphView.values = values
            graphView.invalidate()
        }
    }
}