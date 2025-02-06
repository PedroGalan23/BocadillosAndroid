package com.example.bocadilloandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bocadilloandroid.BocadilloAdapter.BocadilloViewHolder
import com.example.bocadilloandroid.modelos.Pedido

//Representa la vista de cada pedido en la lista, identificando cuales son sus id
class PedidoAdapter (private val pedidos:List<Pedido>): RecyclerView.Adapter<PedidoAdapter.PedidoViewHolder>(){

    class PedidoViewHolder(view: View) :RecyclerView.ViewHolder(view){

        val tvId:TextView =view.findViewById(R.id.tvId)
        val tvNombreBocadillo:TextView=view.findViewById(R.id.tvNombreBocadillo)
        val tvFecha:TextView=view.findViewById(R.id.tvFecha)
        //val imageView:ImageView=view.findViewById(R.id.imageView)
        val tvCoste:TextView=view.findViewById(R.id.tvCoste)

    }
    //Crea una vista nueva en nuestro RecyclerView, se llama cuando esto sea necesario
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PedidoViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pedido, parent, false)
    return PedidoViewHolder(view)
    }

    override fun getItemCount(): Int = pedidos.size

    /* Vincula los datos con la vista
    (se llama cada vez que un elemento debe ser mostrado)*/

    override fun onBindViewHolder(holder: PedidoViewHolder, position: Int) {
       val pedido=pedidos[position]

        holder.tvId.text="${pedido.id}"
        holder.tvCoste.text="${pedido.precio}"
        holder.tvFecha.text="${pedido.fecha}"
        holder.tvNombreBocadillo.text=pedido.bocadillo.nombre

    }
}




