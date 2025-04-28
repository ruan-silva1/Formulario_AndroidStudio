package com.orgs.nitro.ui.activity


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.orgs.nitro.R
import com.orgs.nitro.model.MotoCLubes
import com.orgs.nitro.ui.recyclerview.adapter.ListaMotoClubeRecycler

class MainActivity: AppCompatActivity(R.layout.lista_motoclube_activity) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val listaMotoClubesRecyclerView = findViewById<RecyclerView>(R.id.lista_motoclube)
        listaMotoClubesRecyclerView.adapter = ListaMotoClubeRecycler(this,
            listOf(
                MotoCLubes("holigan"),
                MotoCLubes("holigan"),
                MotoCLubes("holigan"),
                MotoCLubes("holigan"),
                MotoCLubes("holigan"),
                MotoCLubes("holigan")
            )
        )
        listaMotoClubesRecyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false)
    }

}