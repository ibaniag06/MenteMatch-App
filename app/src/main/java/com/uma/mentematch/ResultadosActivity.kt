package com.uma.mentematch

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.uma.mentematch.databinding.ActivityResultadosBinding
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry

class ResultadosActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultadosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultadosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val top1 = intent.getStringExtra("TOP1") ?: "Carrera 1"
        val top2 = intent.getStringExtra("TOP2") ?: "Carrera 2"
        val top3 = intent.getStringExtra("TOP3") ?: "Carrera 3"

        binding.tvMatch1.text = top1
        binding.tvMatch2.text = top2
        binding.tvMatch3.text = top3

        setupChart()

        binding.btnBackResultados.setOnClickListener { finish() }
        
        binding.btnVerUniversidades.setOnClickListener { 
            // Placeholder: Abrir navegador con búsqueda de universidades
            val query = "universidades para estudiar $top1"
            val intent = Intent(Intent.ACTION_VIEW, android.net.Uri.parse("https://www.google.com/search?q=$query"))
            startActivity(intent)
        }

        binding.btnHablarMentor.setOnClickListener {
            // Placeholder: Abrir WhatsApp o Mail
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = android.net.Uri.parse("mailto:mentores@mentematch.com")
                putExtra(Intent.EXTRA_SUBJECT, "Consulta sobre $top1")
            }
            startActivity(intent)
        }

        binding.btnCompartir.setOnClickListener {
            val shareText = "¡He descubierto mi vocación en MenteMatch! Mi carrera ideal es: $top1. ¿Cuál es la tuya?"
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, shareText)
            }
            startActivity(Intent.createChooser(intent, "Compartir resultados"))
        }
    }

    private fun setupChart() {
        val entries = listOf(
            PieEntry(45f, "Comunicación"),
            PieEntry(30f, "Adaptabilidad"),
            PieEntry(25f, "Negociación")
        )

        val dataSet = PieDataSet(entries, "")
        dataSet.colors = listOf(
            Color.parseColor("#1A525C"),
            Color.parseColor("#4CB5AB"),
            Color.parseColor("#E8744F")
        )
        dataSet.valueTextColor = Color.WHITE
        dataSet.valueTextSize = 12f

        val data = PieData(dataSet)
        binding.chartHabilidades.apply {
            this.data = data
            centerText = "Top Skills"
            setCenterTextSize(16f)
            description.isEnabled = false
            legend.isEnabled = false
            animateY(1000)
            invalidate()
        }
    }
}
