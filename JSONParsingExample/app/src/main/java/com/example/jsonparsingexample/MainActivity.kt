package com.example.jsonparsingexample

//import android.R
import android.os.Bundle
//import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    var JSON_STRING = "{\"employee\":{\"name\":\"Abhishek Saini\",\"salary\":65000}}"
    var name: String? = null
    var salary: String? = null
    var employeeName: TextView? = null
    var employeeSalary: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // get the reference of TextView's
        employeeName = findViewById<View>(R.id.name) as TextView
        employeeSalary = findViewById<View>(R.id.salary) as TextView

        try {
            // get JSONObject from JSON file
            val obj = JSONObject(JSON_STRING)

            // fetch JSONObject named employee
            val employee = obj.getJSONObject("employee")

            // get employee name and salary
            name = employee.getString("name")
            salary = employee.getString("salary")

            // set employee name and salary in TextView's
            employeeName!!.text = "Name: $name"
            employeeSalary!!.text = "Salary: $salary"

        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }
}