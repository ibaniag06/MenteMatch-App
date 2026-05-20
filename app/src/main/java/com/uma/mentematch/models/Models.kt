package com.uma.mentematch.models

data class Pregunta(
    val id: Int,
    val texto: String,
    val opcion1: String,
    val opcion2: String,
    var respuestaSeleccionada: Int = -1
)

data class ResultadoVocacional(
    val areaSeleccionada: String = "",
    val preguntas: List<String> = emptyList(),
    val respuestas: List<String> = emptyList(),
    val fecha: String = "",
    val timestamp: Long = 0,
    val resultadoTop1: String = "",
    val resultadoTop2: String = "",
    val resultadoTop3: String = "",
    val habilidades: Map<String, Float> = emptyMap()
)