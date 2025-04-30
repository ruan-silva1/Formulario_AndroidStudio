package com.orgs.nitro.ui.activity


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.orgs.nitro.R
import com.orgs.nitro.dao.MotoClubesDao
import com.orgs.nitro.model.MotoCLubes
import com.orgs.nitro.ui.recyclerview.adapter.ListaMotoClubeRecycler

class ListaMotoClubesActivity: AppCompatActivity(R.layout.lista_motoclube_activity) {

    val motoClubesDao = MotoClubesDao()
    private val adapter = ListaMotoClubeRecycler(this,motoClubesDao.buscarTodos())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configurarFab()
        configurarRecyclerView()
    }

    override fun onResume() {
        super.onResume()
        adapter.atualizar(motoClubesDao.buscarTodos())
    }

    private fun configurarFab() {
        val fabFormulario =
            findViewById<FloatingActionButton>(R.id.floatingActionButton_for_formulario)
        fabFormulario.setOnClickListener {
            val intent = Intent(this, FormularioProdutoActivity::class.java)
            startActivity(intent)
        }
    }

    private fun configurarRecyclerView() {
        val listaMotoClubesRecyclerView = findViewById<RecyclerView>(R.id.lista_motoclube)
        listaMotoClubesRecyclerView.adapter = adapter
        listaMotoClubesRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }

}