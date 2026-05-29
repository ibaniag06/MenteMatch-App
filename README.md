# 🧠 **MenteMatch App - Documentación Completa**

## 📌 Descripción General

**MenteMatch** es una aplicación Android innovadora diseñada para ayudar a usuarios a descubrir su vocación profesional mediante cuestionarios psicométricos inteligentes. La aplicación evalúa intereses, habilidades y preferencias personales para proporcionar recomendaciones de carreras personalizadas y precisas.

---

## ✨ **Características Principales**

### 🔐 **1. Autenticación Segura**
- Login con correo electrónico y contraseña
- Integración con **Firebase Authentication**
- Validación de credenciales en tiempo real
- Mensajes de error descriptivos

### 📝 **2. Cuestionarios Vocacionales Dinámicos**
Seis áreas de especialización disponibles:
- **Ciencias** (Biología, Física, Química)
- **Artes** (Diseño, Música, Artes Visuales)
- **Negocios** (Administración, Marketing, Finanzas)
- **Tecnología** (Software, Hardware, IA)
- **Salud** (Medicina, Enfermería, Fisioterapia)
- **Idiomas** (Traducción, Interpretación, Relaciones Internacionales)

Cada área contiene **5 preguntas** cuidadosamente diseñadas con opciones binarias para evaluar aptitudes específicas.

### 📊 **3. Análisis Vocacional Avanzado**
- Algoritmo de evaluación inteligente
- Recomendación del **Top 3 de carreras** por área
- Evaluación de **3 habilidades profesionales** clave:
  - Comunicación (45%)
  - Adaptabilidad (30%)
  - Negociación (25%)
- Visualización con gráficos de pastel (Pie Charts) interactivos

### 💾 **4. Persistencia de Datos**
- Sincronización en tiempo real con **Firebase Firestore**
- Almacenamiento automático de resultados
- Historial de evaluaciones por usuario
- Información de fecha y timestamp de cada test

### 🎯 **5. Funcionalidades Adicionales**
- Búsqueda de universidades recomendadas
- Contacto con mentores profesionales
- Compartir resultados en redes sociales

---

## 🏗️ **Arquitectura y Estructura del Proyecto**

```
MenteMatch-App/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── AndroidManifest.xml
│   │   │   ├── java/com/uma/mentematch/
│   │   │   │   ├── MainActivity.kt              ← Login
│   │   │   │   ├── MenteMatch_Activity2.kt      ← Selección de área
│   │   │   │   ├── FormularioActivity.kt        ← Cuestionario
│   │   │   │   ├── ResultadosActivity.kt        ← Resultados
│   │   │   │   ├── models/
│   │   │   │   │   └── Models.kt                ← Modelos de datos
│   │   │   │   └── utils/
│   │   │   │       └── PreguntasData.kt         ← Datos y lógica
│   │   │   └── res/
│   │   │       ├── layout/
│   │   │       │   ├── activity_main.xml
│   │   │       │   ├── activity_formulario.xml
│   │   │       │   ├── activity_mente_match2.xml
│   │   │       │   ├── activity_resultados.xml
│   │   │       │   └── item_pregunta.xml
│   │   │       ├── drawable/
│   │   │       ├── values/
│   │   │       ├── mipmap-*/
│   │   │       └── xml/
│   │   ├── test/
│   │   └── androidTest/
│   ├── build.gradle.kts
│   ├── google-services.json
│   └── proguard-rules.pro
├── build.gradle.kts
├── settings.gradle.kts
└── gradle.properties
```

---

## 🛠️ **Tecnologías Utilizadas**

### **🏗️ Framework y Lenguaje**
| Tecnología | Versión | Descripción |
|-----------|---------|-------------|
| **Kotlin** | - | Lenguaje principal de programación |
| **Android SDK** | 36 | Target de compilación |
| **Android API** | 24+ | Compatibilidad mínima (Android 7.0+) |
| **Java** | 11 | Compatibilidad de código |

### **🔥 Backend y Base de Datos**
| Tecnología | Versión | Descripción |
|-----------|---------|-------------|
| **Firebase Authentication** | 33.1.0+ | Autenticación segura de usuarios |
| **Firebase Firestore** | 33.1.0+ | Base de datos NoSQL en tiempo real |
| **Google Cloud Services** | 4.4.1 | Servicios de Google Cloud |

### **📱 Librerías de Interfaz de Usuario**
| Librería | Versión | Uso |
|----------|---------|-----|
| **AndroidX AppCompat** | Latest | Compatibilidad retroactiva |
| **Material Design** | 1.11+ | Componentes visuales Material |
| **ConstraintLayout** | Latest | Sistema de layouts avanzado |
| **View Binding** | - | Vinculación type-safe de vistas |

### **📊 Visualización de Datos**
| Librería | Versión | Descripción |
|----------|---------|-------------|
| **MPAndroidChart** | 3.1.0 | Gráficos profesionales (Pie, Bar, Line) |

### **🧪 Testing**
| Herramienta | Descripción |
|-----------|-------------|
| **JUnit 4** | Tests unitarios |
| **AndroidJUnit** | Tests en Android |
| **Espresso** | Testing de UI |

### **🔨 Build System**
| Herramienta | Descripción |
|-----------|-------------|
| **Gradle Kotlin DSL** | Build automation |
| **Google Repositories** | Plugins y librerías de Google |
| **JitPack** | Repositorio para dependencias externas |

---

## 📋 **Modelos de Datos**

### **Pregunta**
```kotlin
data class Pregunta(
    val id: Int,                              // Identificador único
    val texto: String,                        // Enunciado de la pregunta
    val opcion1: String,                      // Primera opción de respuesta
    val opcion2: String,                      // Segunda opción de respuesta
    var respuestaSeleccionada: Int = -1       // Respuesta del usuario (-1: sin respuesta)
)
```

### **ResultadoVocacional**
```kotlin
data class ResultadoVocacional(
    val areaSeleccionada: String = "",        // Área vocacional elegida
    val preguntas: List<String> = emptyList(),// Lista de preguntas respondidas
    val respuestas: List<String> = emptyList(),// Respuestas seleccionadas
    val fecha: String = "",                   // Fecha del test (dd/MM/yyyy)
    val timestamp: Long = 0,                  // Timestamp del test
    val resultadoTop1: String = "",           // Carrera recomendada #1
    val resultadoTop2: String = "",           // Carrera recomendada #2
    val resultadoTop3: String = "",           // Carrera recomendada #3
    val habilidades: Map<String, Float> = emptyMap() // Mapa de habilidades evaluadas
)
```

---

## 🔄 **Flujo de la Aplicación**

```
┌─────────────────────┐
│   MainActivity      │  ← Login con Firebase
│   (activity_main)   │
└──────────┬──────────┘
           │
           ▼
┌─────────────────────────────────────┐
│  MenteMatch_Activity2               │  ← Seleccionar área vocacional
│  (activity_mente_match2)            │
│  - Ciencias, Artes, Negocios, etc. │
└──────────┬──────────────────────────┘
           │
           ▼
┌────────────────────────────────────┐
│  FormularioActivity                │  ← Responder cuestionario
│  (activity_formulario)             │
│  - 5 preguntas por área            │
│  - Barra de progreso               │
│  - Validación de respuestas        │
│  - Almacena en Firestore           │
└──────────┬─────────────────────────┘
           │
           ▼
┌────────────────────────────────────┐
│  ResultadosActivity                │  ← Ver resultados
│  (activity_resultados)             │
│  - Top 3 carreras                  │
│  - Gráfico de habilidades          │
│  - Opciones: Universidades, Mentor │
│  - Compartir en redes              │
└────────────────────────────────────┘
```

---

## 📝 **Descripción de Actividades**

### **1. MainActivity** 🔑
**Archivo:** `MainActivity.kt`

**Funciones principales:**
- Interfaz de login con correo y contraseña
- Autenticación con Firebase Authentication
- Validación de campos vacíos
- Manejo de errores de autenticación
- Navegación a MenteMatch_Activity2 al iniciar sesión

**Flujo:**
1. Usuario ingresa correo y contraseña
2. Click en "Iniciar Sesión"
3. Validación de campos
4. Autenticación en Firebase
5. Si es exitoso → Navega a MenteMatch_Activity2
6. Si falla → Muestra mensaje de error

---

### **2. MenteMatch_Activity2** 🎯
**Archivo:** `MenteMatch_Activity2.kt`

**Funciones principales:**
- Visualización de 6 áreas vocacionales
- Selección mediante ChipGroup (Material Design)
- Validación de selección antes de continuar
- Lanzamiento de FormularioActivity con área seleccionada

**Áreas disponibles:**
1. Ciencias
2. Artes
3. Negocios
4. Tecnología
5. Salud
6. Idiomas

---

### **3. FormularioActivity** ✍️
**Archivo:** `FormularioActivity.kt`

**Funciones principales:**
- Renderizado dinámico de 5 preguntas por área
- RadioButton para seleccionar opciones
- Barra de progreso actualizable
- Validación de respuestas completas
- Almacenamiento en Firebase Firestore
- Cálculo y procesamiento de resultados

**Características:**
- Generación de IDs únicos para RadioButtons
- LayoutInflater para crear items dinámicos
- Data binding con View Binding
- Timestamp y fecha en los resultados
- Habilidades evaluadas predefinidas

---

### **4. ResultadosActivity** 📊
**Archivo:** `ResultadosActivity.kt`

**Funciones principales:**
- Visualización de Top 3 carreras recomendadas
- Gráfico de Pie Chart con habilidades profesionales
- Búsqueda de universidades en Google
- Contacto con mentores por email
- Compartir resultados en redes sociales

**Componentes visuales:**
- Pie Chart de MPAndroidChart
- Tres campos de texto para carreras
- Botones de acción (Universidades, Mentor, Compartir)

**Colores del gráfico:**
- Comunicación: `#1A525C` (Azul oscuro)
- Adaptabilidad: `#4CB5AB` (Verde agua)
- Negociación: `#E8744F` (Naranja)

---

## 💾 **Base de Datos - Firestore**

### **Estructura de Colecciones**

#### **Colección: `TestResultados`**
Almacena todos los resultados de evaluaciones vocacionales de los usuarios.

**Documento ejemplo:**
```json
{
  "areaSeleccionada": "Tecnología",
  "preguntas": [
    "¿Te interesa más el desarrollo de software o el hardware?",
    "¿Prefieres trabajar con datos y algoritmos o con interfaces de usuario?",
    "..."
  ],
  "respuestas": [
    "Software (Programación)",
    "Datos y algoritmos",
    "..."
  ],
  "fecha": "29/05/2026",
  "timestamp": 1748600000000,
  "resultadoTop1": "Ingeniería de Software",
  "resultadoTop2": "Ciencia de Datos",
  "resultadoTop3": "Ciberseguridad",
  "habilidades": {
    "Comunicación": 45.0,
    "Adaptabilidad": 30.0,
    "Negociación": 25.0
  }
}
```

---

## 📊 **Preguntas por Área**

### **Ciencias** 🔬
1. ¿Te interesa más el estudio de los seres vivos o de la materia inanimada?
2. ¿Prefieres trabajar en un laboratorio o haciendo investigación de campo?
3. ¿Te gusta resolver problemas mediante el método científico?
4. ¿Te atrae más la investigación teórica o la aplicación práctica?
5. ¿Te gustaría contribuir a descubrimientos médicos o tecnológicos?

**Carreras recomendadas:** Biología Molecular, Química Farmacéutica, Física Teórica

---

### **Artes** 🎨
1. ¿Prefieres expresarte a través de medios visuales o auditivos?
2. ¿Te gusta más crear obras desde cero o interpretar obras existentes?
3. ¿Te interesa el diseño digital o el arte tradicional?
4. ¿Te gustaría trabajar de forma independiente o en proyectos colaborativos?
5. ¿Qué te motiva más: la estética o el mensaje social?

**Carreras recomendadas:** Diseño Gráfico, Artes Visuales, Música

---

### **Negocios** 💼
1. ¿Te consideras una persona líder o prefieres trabajar en equipo?
2. ¿Te interesa más el marketing o las finanzas?
3. ¿Prefieres planificar estrategias a largo plazo o gestionar operaciones diarias?
4. ¿Te gusta la negociación y el trato con clientes?
5. ¿Te atrae el emprendimiento o trabajar en una gran corporación?

**Carreras recomendadas:** Administración de Empresas, Marketing Digital, Finanzas

---

### **Tecnología** 💻
1. ¿Te interesa más el desarrollo de software o el hardware?
2. ¿Prefieres trabajar con datos y algoritmos o con interfaces de usuario?
3. ¿Te gusta resolver acertijos lógicos complejos?
4. ¿Te interesa la inteligencia artificial o la ciberseguridad?
5. ¿Te ves trabajando en la nube o en redes locales?

**Carreras recomendadas:** Ingeniería de Software, Ciencia de Datos, Ciberseguridad

---

### **Salud** ⚕️
1. ¿Te interesa más el cuidado directo del paciente o la investigación médica?
2. ¿Te gustaría trabajar en emergencias o en consultas programadas?
3. ¿Te atrae la odontología o la medicina general?
4. ¿Te interesa la salud mental o la salud física?
5. ¿Te gustaría trabajar en un hospital público o en una clínica privada?

**Carreras recomendadas:** Medicina, Enfermería, Fisioterapia

---

### **Idiomas** 🌍
1. ¿Qué te motiva más de aprender un nuevo idioma?
2. ¿Al enfrentarte a una palabra desconocida, qué prefieres?
3. ¿Cómo prefieres consumir contenido extranjero?
4. ¿Qué tipo de trabajo te atrae más?
5. ¿Qué te resulta más sencillo de dominar?

**Carreras recomendadas:** Relaciones Internacionales, Traducción e Interpretación, Turismo

---

## 📦 **Dependencias principales**

```gradle
// Firebase
implementation(platform("com.google.firebase:firebase-bom:33.1.0"))
implementation("com.google.firebase:firebase-auth")
implementation("com.google.firebase:firebase-firestore-ktx")

// Android & AndroidX
implementation(libs.androidx.core.ktx)
implementation(libs.androidx.appcompat)
implementation(libs.material)
implementation(libs.androidx.activity)
implementation(libs.androidx.constraintlayout)

// MPAndroidChart
implementation("com.github.PhilJay:MPAndroidChart:v3.1.0")

// Testing
testImplementation(libs.junit)
androidTestImplementation(libs.androidx.junit)
androidTestImplementation(libs.androidx.espresso.core)
```

---

## ⚙️ **Configuración de Compilación**

- **compileSdk:** 36 (Android 15)
- **targetSdk:** 36
- **minSdk:** 24 (Android 7.0)
- **Java Version:** 11
- **View Binding:** Habilitado
- **Proguard:** Habilitado (release)

---

## 🎯 **Próximas Mejoras Potenciales**

- [ ] Soporte para múltiples idiomas
- [ ] Machine Learning para recomendaciones personalizadas
- [ ] Integración con redes sociales
- [ ] Exportación de resultados en PDF
- [ ] Dashboard de progreso del usuario
- [ ] Notificaciones push personalizadas
- [ ] Historial de tests con comparativas
- [ ] Recomendaciones de becas y ayudas

---

## 📞 Contacto y Soporte

Para reportar bugs, solicitar features o hacer preguntas:
- Abre un **Issue** en GitHub
- Envía un **Pull Request** con tu contribución

---

**Versión:** 1.0  
**Autor:** ibaniag06  
**Última actualización:** 29 de Mayo, 2026
