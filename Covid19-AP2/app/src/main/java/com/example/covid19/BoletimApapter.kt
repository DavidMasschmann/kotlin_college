package com.example.covid19

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*


class BoletimAdapter (private val boletins: List<Boletim>): RecyclerView.Adapter<BoletimAdapter.VH>()  {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        val vh = VH(v)
        
        vh.itemView.setOnClickListener {
            val boletim = boletins[vh.adapterPosition]
            Toast.makeText(v.context,boletim.toString(),Toast.LENGTH_LONG).show()
        }

        vh.txtData.setOnClickListener{
            val boletim = boletins[vh.adapterPosition]
            Toast.makeText(v.context,boletim.monitoramento.toString(),Toast.LENGTH_LONG).show()

        }
        return vh

    }

    override fun getItemCount(): Int {
        return  boletins.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val boletim =  boletins[position]

        holder.txtData.text = boletim.data
        holder.txtHora.text = boletim.hora
        holder.txtMortes.text = boletim.mortes.toString()
        holder.txtNconfirmados.text = boletim.confirmados.toString()
    }

    class VH(itenView: View):RecyclerView.ViewHolder(itenView){
        var txtData:TextView = itenView.text_data
        var txtHora:TextView = itenView.text_hora
        var txtMortes:TextView = itenView.text_mortes
        var txtNconfirmados:TextView = itenView.text_confirmados
    }


}
