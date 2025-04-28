package com.orgs.nitro.ui.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.orgs.nitro.R
import com.orgs.nitro.dao.MotoClubesDao
import com.orgs.nitro.model.MotoCLubes

class FormularioProdutoActivity: AppCompatActivity(R.layout.formulario_produto_activity) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val botaoSalvar = findViewById<Button>(R.id.Enviar)
        botaoSalvar.setOnClickListener (object: View.OnClickListener {
            override fun onClick (v: View?) {
                val campoNome = findViewById<EditText>(R.id.campo_nome)
                val nomeMotoClube =campoNome.text.toString()
                val novoMotoCLube = MotoCLubes(nomeMotoClube)
                Log.i("Formulario Produto", "retorno dado do motoclube: $novoMotoCLube")
                MotoClubesDao().adiciona(novoMotoCLube)
                Log.i("Formulario Produto","Lista de motoClube: ${MotoClubesDao().buscarTodos()}")
            }
        }
        )
    }
}