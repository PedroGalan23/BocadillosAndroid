package com.example.bocadilloandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bocadilloandroid.modelos.TipoBocadillo

import androidx.recyclerview.widget.RecyclerView
import com.example.bocadilloandroid.R
import com.example.bocadilloandroid.modelos.Bocadillo
import com.example.bocadilloandroid.modelos.Pedido
import java.sql.Time
import java.util.Date

class PedidoFragment : Fragment() {

    private lateinit var btnConfirmar: Button
    private var bocadilloSeleccionado: Bocadillo? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pedido, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerBocadillos)
        btnConfirmar = view.findViewById(R.id.btnConfirmar)

        // Inicialmente ocultamos el botón
        btnConfirmar.visibility = View.GONE

        // Lista de bocadillos de prueba (esto vendría de una BD en la implementación real)
        val bocadillos = listOf(
            Bocadillo(1, "Pechuga", TipoBocadillo.CALIENTE, "Pollo a la plancha", "Gluten", 2.50,R.drawable.ic_pollo),
            Bocadillo(2, "Jamon York", TipoBocadillo.FRIO, "Jamón con queso", "Gluten", 2.00,R.drawable.ic_jamonyork),
        )

        val adapter = BocadilloAdapter(bocadillos) { bocadillo ->
            bocadilloSeleccionado = bocadillo
            btnConfirmar.visibility = View.VISIBLE // Mostramos el botón cuando se selecciona un bocadillo
        }

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        // Navegar al resumen cuando se presiona el botón
        btnConfirmar.setOnClickListener {
            if (bocadilloSeleccionado != null) {
                findNavController().navigate(R.id.action_fragment_pedido_to_resumenFragment)
            }
        }
    }
}