package com.orgs.nitro.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.orgs.nitro.R
import com.orgs.nitro.model.MotoCLubes

class ListaMotoClubeRecycler(
    private val context: Context,
    motoclubes: List<MotoCLubes>
) : RecyclerView.Adapter<ListaMotoClubeRecycler.ViewHolder>() {

    val motoclubes = motoclubes.toMutableList()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun vincula(motoclube: MotoCLubes) {
            val campoNomeMotoClube = itemView.findViewById<TextView>(R.id.nome_motoclube)
            campoNomeMotoClube.text = motoclube.nome
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.motoclubes_activity, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val motoclube = motoclubes[position]
        holder.vincula(motoclube)
    }

    override fun getItemCount(): Int = motoclubes.size

    fun atualizar(motoclubes: List<MotoCLubes>) {
        this.motoclubes.clear()
        this.motoclubes.addAll(motoclubes)
        notifyDataSetChanged()
    }

}
