package com.example.smarreqassist

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetalleSIMSeleccionadaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalle_simseleccionada)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnEnviarDesicion = findViewById<Button>(R.id.btnEnviarDesicion)
        val txtPendienteAprobacion = findViewById<TextView>(R.id.txtPendienteAprobacion)

        btnEnviarDesicion.setOnClickListener {
            // Animar aumento de tamaño
            val scaleUpX = ObjectAnimator.ofFloat(btnEnviarDesicion, "scaleX", 1f, 1.1f) // Escalar en X
            val scaleUpY = ObjectAnimator.ofFloat(btnEnviarDesicion, "scaleY", 1f, 1.1f) // Escalar en Y
            scaleUpX.duration = 100 // Duración de la animación
            scaleUpY.duration = 100

            // Restaurar al tamaño original
            val scaleDownX = ObjectAnimator.ofFloat(btnEnviarDesicion, "scaleX", 1.1f, 1f)
            val scaleDownY = ObjectAnimator.ofFloat(btnEnviarDesicion, "scaleY", 1.1f, 1f)
            scaleDownX.duration = 100
            scaleDownY.duration = 100

            // Ejecutar las animaciones secuencialmente
            val animatorSet = AnimatorSet()
            animatorSet.play(scaleUpX).with(scaleUpY)
            animatorSet.play(scaleDownX).with(scaleDownY).after(scaleUpX)
            animatorSet.start()

            //txtMensajeExitoso.visibility = View.VISIBLE

            var textHTML = """
                <p>¡Su desición fue procesada exitosamente N°0789!</p>
                <p style='color:blue'><b>Nota: </b>La SOLPED ha sido liberada en SmartReq Assist dado la conformidad de todos los aprobadores y está lista para su sincronización en SAP</p>
            """.trimIndent()

            mostrarDialogo(this,"Enviar Desición",textHTML) {
                txtPendienteAprobacion.text = "Aprobado"
            }

            //val intent = Intent(this, GenerarEnviarPreSimActivity::class.java)
            //startActivity(intent)
        }
    }
}