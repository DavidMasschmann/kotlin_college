package com.example.currencyconverter

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    fun convertonclick(view: View) {
        val real_text = editText.text.toString().toDouble();
        var dollar_text = real_text * 5;

        editText2.text = dollar_text.toString();

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
