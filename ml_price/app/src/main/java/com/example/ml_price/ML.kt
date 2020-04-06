package com.example.ml_price

class ML {

    companion object {
        fun calculate (price: Double, ml: Double): String {
            val final = price / ml;
            return String.format("%.4f", final);
        }
    }
}