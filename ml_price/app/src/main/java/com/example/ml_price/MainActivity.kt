package com.example.ml_price

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculate.setOnClickListener(View.OnClickListener {
            val p1 = price1.text.toString().toDouble()
            val p2 = price2.text.toString().toDouble()
            val p3 = price3.text.toString().toDouble()
            val mL1 = ml1.text.toString().toDouble()
            val mL2 = ml2.text.toString().toDouble()
            val mL3 = ml3.text.toString().toDouble()

            final1.text = ML.calculate(p1, mL1)
            final2.text = ML.calculate(p2, mL2)
            final3.text = ML.calculate(p3, mL3)
        })
    }
}
