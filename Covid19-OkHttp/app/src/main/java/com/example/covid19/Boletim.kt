package com.example.covid19

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

data class Boletim (
  var suspeitos: Int=0,
  var confirmados: Int=0,
  var descartados: Int=0,
  var monitoramento: Int=0,
  var curados: Int=0,
  var sDomiciliar: Int=0,
  var sHospitalar: Int=0,
  var mortes: Int=0,
  var dia: String,
  var hora: String
) {
  override fun toString(): String {
    return dia
  }

  fun getData(data: String): String {
    val diaString =data
    var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    var date = LocalDate.parse(diaString)
    var formattedDate = date.format(formatter)
    return formattedDate
  }
}