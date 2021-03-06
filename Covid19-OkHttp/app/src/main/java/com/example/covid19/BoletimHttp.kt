package com.example.covid19

import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONArray
import org.json.JSONObject
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.InputStream
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL
import java.nio.charset.Charset
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.concurrent.TimeUnit

object BoletimHttp {
  val Json_URL="https://raw.githubusercontent.com/ramonsl/ws-covid/master/db.json"

  fun hasConnection(ctx: Context): Boolean{
    val cm= ctx.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val info = cm.activeNetworkInfo
    return info != null && info.isConnected
  }


  fun readBoletins(json: JSONArray): List<Boletim>?{
    val boletins = mutableListOf<Boletim>()
    try {
      //var jsonArray = JSONArray(json)
      for (i in 0 .. json.length() -1){
        var js = json.getJSONObject(i)
        val dia = formatarData(js.getString("boletim").substring(0,10))
        val hora = js.getString("boletim").substring(11,18)
        val boletim = Boletim(
          js.getInt("Suspeitos"),
          js.getInt("Confirmados"),
          js.getInt("Descartados"),
          js.getInt("Monitoramento"),
          js.getInt("Descartados"),
          js.getInt("Sdomiciliar"),
          js.getInt("Shopitalar"),
          js.getInt("mortes"),
          dia,
          hora
        )
        boletins.add(boletim)
      }
    }
    catch (e : IOException){
      Log.e("Erro", "Impossivel ler JSON")
    }

    return boletins
  }

  fun formatarData(data: String): String {
    val diaString =data
    var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    var date = LocalDate.parse(diaString)
    var formattedDate = date.format(formatter)
    return formattedDate

  }

  fun loadBoletim(): List<Boletim>?{
    val client = OkHttpClient.Builder()
      .readTimeout(5,TimeUnit.SECONDS)
      .connectTimeout(10, TimeUnit.SECONDS)
      .build()
    val request = Request.Builder()
      .url(Json_URL)
      .build()
    val response = client.newCall(request).execute()
    val jsonString = response.body?.string()
    val json = JSONArray(jsonString)

    return readBoletins(json)
  }
}
