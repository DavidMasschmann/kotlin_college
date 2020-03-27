package com.example.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        send.setOnClickListener(View.OnClickListener {
            var height = height.text.toString().toDouble()
            var weight = weight.text.toString().toDouble()
            var bmi = (height * height) / weight

            Toast.makeText(this, bmi.toString(), Toast.LENGTH_LONG) .show()

            var a: Int
        })

    }
}
