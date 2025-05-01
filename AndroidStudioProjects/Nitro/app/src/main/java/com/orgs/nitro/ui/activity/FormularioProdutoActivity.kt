package com.orgs.nitro.ui.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.orgs.nitro.R
import com.orgs.nitro.dao.MotoClubesDao
import com.orgs.nitro.databinding.FormularioProdutoActivityBinding
import com.orgs.nitro.model.MotoCLubes

class FormularioProdutoActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = FormularioProdutoActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.Enviar.setOnClickListener {
            val nomeMotoClube = binding.campoNome.text.toString()
            val novoMotoCLube = MotoCLubes(nomeMotoClube)
            Log.i("Formulario Produto", "retorno dado do motoclube: $novoMotoCLube")
            MotoClubesDao().adiciona(novoMotoCLube)
            Log.i("Formulario Produto", "Lista de motoClube: ${MotoClubesDao().buscarTodos()}")
            finish()
        }
    }
}
