package com.rodri.ejercicio4

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import com.rodri.ejercicio4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.introducirNumero.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                binding.bajar.setBackgroundColor(Color.parseColor("#FF0000"))
                binding.subir.setBackgroundColor(Color.parseColor("#1C4ED8"))
            } else {
                binding.bajar.setBackgroundColor(Color.parseColor("#000000"))
                binding.subir.setBackgroundColor(Color.parseColor("#000000"))
            }
        }

        binding.bajar.setOnClickListener {
            if (binding.marcador.text.toString().toInt() > 0)
                binding.marcador.text = (binding.marcador.text.toString().toInt() - 1).toString()
        }

        binding.subir.setOnClickListener {
            binding.marcador.text = (binding.marcador.text.toString().toInt() + 1).toString()
        }

        binding.introducirNumero.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (binding.introducirNumero.text.isEmpty())
                    binding.marcador.text = "0"
                else
                    if (binding.introducirNumero.text.toString().toInt() >= 0)
                        binding.marcador.text = binding.introducirNumero.text.toString()
            }
        })
    }
}