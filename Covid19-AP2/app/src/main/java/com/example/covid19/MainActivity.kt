package com.example.covid19

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import java.io.IOException
import java.io.InputStream
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {

  private var lista = arrayListOf<Boletim>()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    readJson(this)

    var adapter = BoletimAdapter(lista)
    list.adapter = adapter
    readJson(this)
  }


  fun readJson(context: Context){
    var json: String? = null
    val listaBoletins = mutableListOf<Boletim>()

    try {
      val inputStream: InputStream= context.assets.open("data.json")
      json = inputStream.bufferedReader().use { it.readText() }
      var jsonArray = JSONArray(json)

      for (i in 0 until jsonArray.length()){
        val js = jsonArray.getJSONObject(i)
        val dia = formatarData(js.getString("boletim").substring(0,10))
        val hora = js.getString("boletim").substring(12,17)
        val confirmados = js.getString("Confirmados")
        val mortes = js.getString("mortes")

        var item = Boletim(data = dia, hora = hora, confirmados = confirmados.toString().toInt(), mortes = mortes.toString().toInt())
        lista.add(item)
      }
    }
    catch (e : IOException){
    Log.e("Erro", "Impossivel ler JSON")
    }

  }
  fun formatarData(data: String): String {
    var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    var date = LocalDate.parse(data)
    return date.format(formatter)
  }

}
