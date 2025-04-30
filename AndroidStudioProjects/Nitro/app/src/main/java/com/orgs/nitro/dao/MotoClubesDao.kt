package com.orgs.nitro.dao

import com.orgs.nitro.model.MotoCLubes

class MotoClubesDao {

    companion object {
        val listamotoclubes = mutableListOf<MotoCLubes>()
    }

    fun adiciona(motoclube: MotoCLubes){
        listamotoclubes.add(motoclube)
    }

    fun buscarTodos(): List<MotoCLubes> {
        return listamotoclubes.toList()
    }


}