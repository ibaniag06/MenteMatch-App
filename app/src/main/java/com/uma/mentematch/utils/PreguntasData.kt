package com.uma.mentematch.utils

import com.uma.mentematch.models.Pregunta

object PreguntasData {
    fun getPreguntasByArea(area: String): List<Pregunta> {
        return when (area) {
            "Ciencias" -> listOf(
                Pregunta(1, "¿Te interesa más el estudio de los seres vivos o de la materia inanimada?", "Seres vivos (Biología)", "Materia y energía (Física/Química)"),
                Pregunta(2, "¿Prefieres trabajar en un laboratorio o haciendo investigación de campo?", "Laboratorio", "Campo"),
                Pregunta(3, "¿Te gusta resolver problemas mediante el método científico?", "Sí, me apasiona", "Prefiero otros métodos"),
                Pregunta(4, "¿Te atrae más la investigación teórica o la aplicación práctica?", "Investigación teórica", "Aplicación práctica"),
                Pregunta(5, "¿Te gustaría contribuir a descubrimientos médicos o tecnológicos?", "Médicos", "Tecnológicos")
            )
            "Artes" -> listOf(
                Pregunta(1, "¿Prefieres expresarte a través de medios visuales o auditivos?", "Visuales (Dibujo, pintura)", "Auditivos (Música)"),
                Pregunta(2, "¿Te gusta más crear obras desde cero o interpretar obras existentes?", "Crear", "Interpretar"),
                Pregunta(3, "¿Te interesa el diseño digital o el arte tradicional?", "Digital", "Tradicional"),
                Pregunta(4, "¿Te gustaría trabajar de forma independiente o en proyectos colaborativos?", "Independiente", "Colaborativo"),
                Pregunta(5, "¿Qué te motiva más: la estética o el mensaje social?", "Estética", "Mensaje social")
            )
            "Negocios" -> listOf(
                Pregunta(1, "¿Te consideras una persona líder o prefieres trabajar en equipo?", "Líder", "Trabajo en equipo"),
                Pregunta(2, "¿Te interesa más el marketing o las finanzas?", "Marketing y ventas", "Finanzas y contabilidad"),
                Pregunta(3, "¿Prefieres planificar estrategias a largo plazo o gestionar operaciones diarias?", "Estrategias", "Gestión diaria"),
                Pregunta(4, "¿Te gusta la negociación y el trato con clientes?", "Sí, mucho", "No tanto"),
                Pregunta(5, "¿Te atrae el emprendimiento o trabajar en una gran corporación?", "Emprender", "Corporación")
            )
            "Tecnología" -> listOf(
                Pregunta(1, "¿Te interesa más el desarrollo de software o el hardware?", "Software (Programación)", "Hardware (Componentes)"),
                Pregunta(2, "¿Prefieres trabajar con datos y algoritmos o con interfaces de usuario?", "Datos y algoritmos", "Interfaces y UX"),
                Pregunta(3, "¿Te gusta resolver acertijos lógicos complejos?", "Sí, me encanta", "Prefiero tareas creativas"),
                Pregunta(4, "¿Te interesa la inteligencia artificial o la ciberseguridad?", "IA", "Ciberseguridad"),
                Pregunta(5, "¿Te ves trabajando en la nube o en redes locales?", "Nube", "Redes")
            )
            "Salud" -> listOf(
                Pregunta(1, "¿Te interesa más el cuidado directo del paciente o la investigación médica?", "Cuidado del paciente", "Investigación"),
                Pregunta(2, "¿Te gustaría trabajar en emergencias o en consultas programadas?", "Emergencias", "Consultas"),
                Pregunta(3, "¿Te atrae la odontología o la medicina general?", "Odontología", "Medicina"),
                Pregunta(4, "¿Te interesa la salud mental o la salud física?", "Salud mental", "Salud física"),
                Pregunta(5, "¿Te gustaría trabajar en un hospital público o en una clínica privada?", "Hospital público", "Clínica privada")
            )
            "Idiomas" -> listOf(
                Pregunta(1, "¿Qué te motiva más de aprender un nuevo idioma?", "Conocer la cultura y literatura", "Negocios y conexiones"),
                Pregunta(2, "¿Al enfrentarte a una palabra desconocida, qué prefieres?", "Analizar su raíz gramatical", "Intentar usarla en conversación"),
                Pregunta(3, "¿Cómo prefieres consumir contenido extranjero?", "Leer libros/artículos original", "Ver películas/podcasts"),
                Pregunta(4, "¿Qué tipo de trabajo te atrae más?", "Traducción de textos", "Intérprete en vivo"),
                Pregunta(5, "¿Qué te resulta más sencillo de dominar?", "Ortografía y gramática", "Pronunciación y acento")
            )
            else -> emptyList()
        }
    }

    fun getCarrerasByArea(area: String): Triple<String, String, String> {
        return when (area) {
            "Ciencias" -> Triple("Biología Molecular", "Química Farmacéutica", "Física Teórica")
            "Artes" -> Triple("Diseño Gráfico", "Artes Visuales", "Música")
            "Negocios" -> Triple("Administración de Empresas", "Marketing Digital", "Finanzas")
            "Tecnología" -> Triple("Ingeniería de Software", "Ciencia de Datos", "Ciberseguridad")
            "Salud" -> Triple("Medicina", "Enfermería", "Fisioterapia")
            "Idiomas" -> Triple("Relaciones Internacionales", "Traducción e Interpretación", "Turismo")
            else -> Triple("Carrera 1", "Carrera 2", "Carrera 3")
        }
    }
}
