package com.uma.mentematch

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.uma.mentematch.databinding.ActivityMenteMatch2Binding

class MenteMatch_Activity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMenteMatch2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenteMatch2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
    }

    private fun setupListeners() {
        binding.btnStart.setOnClickListener {
            val selectedChipId = binding.cgInterests.checkedChipId
            if (selectedChipId != -1) {
                val chip = findViewById<com.google.android.material.chip.Chip>(selectedChipId)
                val area = chip.text.toString()
                
                val intent = Intent(this, FormularioActivity::class.java)
                intent.putExtra("AREA", area)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Por favor selecciona un área", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
