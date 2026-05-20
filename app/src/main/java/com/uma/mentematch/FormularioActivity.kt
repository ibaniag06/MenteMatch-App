package com.uma.mentematch

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.uma.mentematch.databinding.ActivityFormularioBinding
import com.uma.mentematch.databinding.ItemPreguntaBinding
import com.uma.mentematch.models.Pregunta
import com.uma.mentematch.models.ResultadoVocacional
import com.uma.mentematch.utils.PreguntasData
import com.google.firebase.firestore.FirebaseFirestore
import java.text.SimpleDateFormat
import java.util.*

class FormularioActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFormularioBinding
    private var area: String = ""
    private lateinit var listaPreguntas: List<Pregunta>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormularioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        area = intent.getStringExtra("AREA") ?: ""
        binding.tvTituloCuestionario.text = getString(R.string.cuestionario_formato, area)

        listaPreguntas = PreguntasData.getPreguntasByArea(area)
        cargarPreguntas()

        binding.btnBack.setOnClickListener { finish() }
        binding.btnGuardarSalir.setOnClickListener { finish() }

        binding.btnSiguiente.setOnClickListener {
            if (validarRespuestas()) {
                guardarYProcesar()
            } else {
                Toast.makeText(this, "Responde todas las preguntas", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun cargarPreguntas() {
        binding.containerPreguntas.removeAllViews()
        listaPreguntas.forEach { pregunta ->
            val itemBinding = ItemPreguntaBinding.inflate(LayoutInflater.from(this), binding.containerPreguntas, false)
            
            val id1 = View.generateViewId()
            val id2 = View.generateViewId()
            itemBinding.rbOpcion1.id = id1
            itemBinding.rbOpcion2.id = id2
            
            itemBinding.tvPregunta.text = pregunta.texto
            itemBinding.rbOpcion1.text = pregunta.opcion1
            itemBinding.rbOpcion2.text = pregunta.opcion2

            itemBinding.rgOpciones.setOnCheckedChangeListener { _, checkedId ->
                pregunta.respuestaSeleccionada = if (checkedId == id1) 1 else 2
                actualizarProgreso()
            }

            binding.containerPreguntas.addView(itemBinding.root)
        }
        actualizarProgreso()
    }

    private fun actualizarProgreso() {
        val respondidas = listaPreguntas.count { it.respuestaSeleccionada != -1 }
        val progreso = (respondidas.toFloat() / listaPreguntas.size * 100).toInt()
        binding.progressBar.progress = progreso
    }

    private fun validarRespuestas(): Boolean {
        return listaPreguntas.all { it.respuestaSeleccionada != -1 }
    }

    private fun guardarYProcesar() {
        val db = FirebaseFirestore.getInstance()
        val (top1, top2, top3) = PreguntasData.getCarrerasByArea(area)
        
        val res = ResultadoVocacional(
            areaSeleccionada = area,
            preguntas = listaPreguntas.map { it.texto },
            respuestas = listaPreguntas.map { if (it.respuestaSeleccionada == 1) it.opcion1 else it.opcion2 },
            fecha = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date()),
            timestamp = System.currentTimeMillis(),
            resultadoTop1 = top1,
            resultadoTop2 = top2,
            resultadoTop3 = top3,
            habilidades = mapOf("Comunicación" to 45f, "Adaptabilidad" to 30f, "Negociación" to 25f)
        )

        db.collection("TestResultados").add(res)
            .addOnSuccessListener {
                Toast.makeText(this, "Resultados guardados exitosamente", Toast.LENGTH_SHORT).show()
                val intentResultados = Intent(this, ResultadosActivity::class.java).apply {
                    putExtra("AREA", area)
                    putExtra("TOP1", top1)
                    putExtra("TOP2", top2)
                    putExtra("TOP3", top3)
                }
                startActivity(intentResultados)
                finish()
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Error al guardar: ${e.message}", Toast.LENGTH_LONG).show()
            }
    }
}