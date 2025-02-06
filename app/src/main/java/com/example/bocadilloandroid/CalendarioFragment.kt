package com.example.bocadilloandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bocadilloandroid.modelos.Bocadillo
import com.example.bocadilloandroid.modelos.TipoBocadillo

class CalendarioFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var bocadilloAdapter: BocadilloAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar el layout del fragmento
        return inflater.inflate(R.layout.fragment_calendario, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerViewBocadillos)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        bocadilloAdapter = BocadilloAdapter(getBocadillosSemana()) { bocadillo ->
            println("Bocata Seleccionado")
        }

        recyclerView.adapter = bocadilloAdapter

        recyclerView.addItemDecoration(GridSpacingItemDecoration(16))

    }

    private fun getBocadillosSemana(): List<Bocadillo> {
        return listOf(
            Bocadillo(1, "Pechuga", TipoBocadillo.CALIENTE, "Pollo a la plancha", "Gluten", 2.50,R.drawable.ic_pollo),
            Bocadillo(2, "Jamon York", TipoBocadillo.FRIO, "Jamón con queso", "Gluten", 2.00,R.drawable.ic_jamonyork),
            Bocadillo(3, "Lomo", TipoBocadillo.CALIENTE, "Lomo adobado", "Gluten", 2.80,R.drawable.ic_lomo),
            Bocadillo(4, "Queso Fresco", TipoBocadillo.FRIO, "Queso de cabra", "Gluten", 2.30,R.drawable.ic_queso),
            Bocadillo(5, "Bacon", TipoBocadillo.CALIENTE, "Bacon con queso", "Gluten", 2.90,R.drawable.ic_bacon),
            Bocadillo(6, "Atún", TipoBocadillo.FRIO, "Atún con mayonesa", "Gluten", 2.40,R.drawable.ic_atun),
            Bocadillo(7, "Hamburguesa", TipoBocadillo.CALIENTE, "Carne de ternera", "Gluten", 3.50,R.drawable.ic_hamburguesa),
            Bocadillo(8, "Ensaladilla", TipoBocadillo.FRIO, "Patata y zanahoria", "Gluten", 2.20,R.drawable.ic_mahonesa),
            Bocadillo(9, "Chorizo", TipoBocadillo.CALIENTE, "Chorizo picante", "Gluten", 2.70,R.drawable.ic_chorizo),
            Bocadillo(10, "Pavo", TipoBocadillo.FRIO, "Pavo con queso", "Gluten", 2.60,R.drawable.ic_pavo),
            Bocadillo(11, "Salchichas", TipoBocadillo.CALIENTE, "Salchichas con ketchup", "Gluten", 2.50,R.drawable.ic_salchichas),
            Bocadillo(12, "Huevo Duro", TipoBocadillo.FRIO, "Huevo con tomate", "Gluten", 2.10,R.drawable.ic_huevo),
            Bocadillo(13, "Chistorra", TipoBocadillo.CALIENTE, "Chistorra a la plancha", "Gluten", 2.80,R.drawable.ic_chistorra),
            Bocadillo(14, "Vegetal", TipoBocadillo.FRIO, "Lechuga y tomate", "Gluten", 2.00,R.drawable.ic_vegeta)
        )
    }
}
