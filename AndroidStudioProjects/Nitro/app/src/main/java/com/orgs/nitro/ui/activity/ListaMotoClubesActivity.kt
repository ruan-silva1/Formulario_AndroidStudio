package com.orgs.nitro.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.orgs.nitro.dao.MotoClubesDao
import com.orgs.nitro.ui.recyclerview.adapter.ListaMotoClubeRecycler

class ListaMotoClubesActivity : AppCompatActivity() {

    private val binding by lazy {
        ListaMotoClubesActivity.Binding.inflate(layoutInflater)
    }

    private val motoClubesDao = MotoClubesDao()
    private val adapter = ListaMotoClubeRecycler(this, motoClubesDao.buscarTodos())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        configurarFab()
        configurarRecyclerView()
    }

    override fun onResume() {
        super.onResume()
        adapter.atualizar(motoClubesDao.buscarTodos())
    }

    private fun configurarFab() {
        binding.floatingActionButtonForFormulario.setOnClickListener {
            val intent = Intent(this, FormularioMotoClubeActivity::class.java)
            startActivity(intent)
        }
    }

    private fun configurarRecyclerView() {
        binding.listaMotoclube.adapter = adapter
        binding.listaMotoclube.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }
}
