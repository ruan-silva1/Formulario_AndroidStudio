package com.orgs.nitro.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.orgs.nitro.R
import com.orgs.nitro.databinding.ListaMotoclubeActivityBinding
import com.orgs.nitro.databinding.MotoclubesActivityBinding
import com.orgs.nitro.model.MotoCLubes
import kotlinx.coroutines.NonDisposableHandle.parent

class ListaMotoClubeRecycler(
    private val context: Context,
    motoclubes: List<MotoCLubes>
) : RecyclerView.Adapter<ListaMotoClubeRecycler.ViewHolder>() {

    private val motoclubes = motoclubes.toMutableList()

    class ViewHolder(
        private val binding: MotoclubesActivityBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun vincula(motoclube: MotoCLubes) {
            binding.nomeMotoclube.text = motoclube.nome
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = MotoclubesActivityBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.vincula(motoclubes[position])
    }

    override fun getItemCount(): Int = motoclubes.size

    fun atualizar(novosMotoclubes: List<MotoCLubes>) {
        motoclubes.clear()
        motoclubes.addAll(novosMotoclubes)
        notifyDataSetChanged()
    }
}
