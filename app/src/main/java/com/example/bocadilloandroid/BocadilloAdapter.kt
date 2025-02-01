package com.example.bocadilloandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.bocadilloandroid.modelos.Bocadillo
import com.example.bocadilloandroid.modelos.TipoBocadillo

class BocadilloAdapter(private val bocadillos: List<Bocadillo>) :
    RecyclerView.Adapter<BocadilloAdapter.BocadilloViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BocadilloViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_bocadillo, parent, false)
        return BocadilloViewHolder(view)
    }

    override fun onBindViewHolder(holder: BocadilloViewHolder, position: Int) {
        val bocadillo = bocadillos[position]
        holder.txtNombre.text = bocadillo.nombre
        holder.txtDescripcion.text = bocadillo.descripcion
        holder.txtAlergenos.text = "Alergenos: ${bocadillo.alergenos}"
        holder.txtCoste.text = "€ ${bocadillo.coste}"
        holder.img.setImageResource(bocadillo.logo)

    }

    override fun getItemCount(): Int = bocadillos.size

    class BocadilloViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtNombre: TextView = view.findViewById(R.id.txtNombre)
        val txtDescripcion: TextView = view.findViewById(R.id.txtDescripcion)
        val txtAlergenos: TextView = view.findViewById(R.id.txtAlergenos)
        val txtCoste: TextView = view.findViewById(R.id.txtCoste)
        val img:ImageView=view.findViewById(R.id.img_logo)
    }
}