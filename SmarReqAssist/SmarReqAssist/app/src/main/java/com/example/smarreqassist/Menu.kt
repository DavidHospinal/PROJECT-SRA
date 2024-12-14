package com.example.smarreqassist

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnGenerarPreSim = findViewById<Button>(R.id.btnGenerarPreSim)
        val btnMantenerPreSim = findViewById<Button>(R.id.btnMantenerPreSim)
        val btnGenerarSim = findViewById<Button>(R.id.btnGenerarSim)
        val btnGestionarAprobacion = findViewById<Button>(R.id.btnGestionarAprobacion)
        val btnReporteria = findViewById<Button>(R.id.btnReporteria)
        val btnSeguridad = findViewById<Button>(R.id.btnSeguridad)
        val textView2 = findViewById<TextView>(R.id.textView2)

        val txtUsername = intent.getStringExtra("txtUsername")

        textView2.text = "Bienvenido " + txtUsername

        btnSeguridad.setOnClickListener {
            // Animar aumento de tamaño
            val scaleUpX = ObjectAnimator.ofFloat(btnSeguridad, "scaleX", 1f, 1.1f) // Escalar en X
            val scaleUpY = ObjectAnimator.ofFloat(btnSeguridad, "scaleY", 1f, 1.1f) // Escalar en Y
            scaleUpX.duration = 100 // Duración de la animación
            scaleUpY.duration = 100

            // Restaurar al tamaño original
            val scaleDownX = ObjectAnimator.ofFloat(btnSeguridad, "scaleX", 1.1f, 1f)
            val scaleDownY = ObjectAnimator.ofFloat(btnSeguridad, "scaleY", 1.1f, 1f)
            scaleDownX.duration = 100
            scaleDownY.duration = 100

            // Ejecutar las animaciones secuencialmente
            val animatorSet = AnimatorSet()
            animatorSet.play(scaleUpX).with(scaleUpY)
            animatorSet.play(scaleDownX).with(scaleDownY).after(scaleUpX)
            animatorSet.start()

        }


        btnReporteria.setOnClickListener {
            // Animar aumento de tamaño
            val scaleUpX = ObjectAnimator.ofFloat(btnReporteria, "scaleX", 1f, 1.1f) // Escalar en X
            val scaleUpY = ObjectAnimator.ofFloat(btnReporteria, "scaleY", 1f, 1.1f) // Escalar en Y
            scaleUpX.duration = 100 // Duración de la animación
            scaleUpY.duration = 100

            // Restaurar al tamaño original
            val scaleDownX = ObjectAnimator.ofFloat(btnReporteria, "scaleX", 1.1f, 1f)
            val scaleDownY = ObjectAnimator.ofFloat(btnReporteria, "scaleY", 1.1f, 1f)
            scaleDownX.duration = 100
            scaleDownY.duration = 100

            // Ejecutar las animaciones secuencialmente
            val animatorSet = AnimatorSet()
            animatorSet.play(scaleUpX).with(scaleUpY)
            animatorSet.play(scaleDownX).with(scaleDownY).after(scaleUpX)
            animatorSet.start()

        }

        btnGestionarAprobacion.setOnClickListener {
            // Animar aumento de tamaño
            val scaleUpX = ObjectAnimator.ofFloat(btnGestionarAprobacion, "scaleX", 1f, 1.1f) // Escalar en X
            val scaleUpY = ObjectAnimator.ofFloat(btnGestionarAprobacion, "scaleY", 1f, 1.1f) // Escalar en Y
            scaleUpX.duration = 100 // Duración de la animación
            scaleUpY.duration = 100

            // Restaurar al tamaño original
            val scaleDownX = ObjectAnimator.ofFloat(btnGestionarAprobacion, "scaleX", 1.1f, 1f)
            val scaleDownY = ObjectAnimator.ofFloat(btnGestionarAprobacion, "scaleY", 1.1f, 1f)
            scaleDownX.duration = 100
            scaleDownY.duration = 100

            // Ejecutar las animaciones secuencialmente
            val animatorSet = AnimatorSet()
            animatorSet.play(scaleUpX).with(scaleUpY)
            animatorSet.play(scaleDownX).with(scaleDownY).after(scaleUpX)
            animatorSet.start()

            val intent = Intent(this, GestionarAprobacionSIMActivity::class.java)
            startActivity(intent)

        }

        btnGenerarSim.setOnClickListener {
            // Animar aumento de tamaño
            val scaleUpX = ObjectAnimator.ofFloat(btnGenerarSim, "scaleX", 1f, 1.1f) // Escalar en X
            val scaleUpY = ObjectAnimator.ofFloat(btnGenerarSim, "scaleY", 1f, 1.1f) // Escalar en Y
            scaleUpX.duration = 100 // Duración de la animación
            scaleUpY.duration = 100

            // Restaurar al tamaño original
            val scaleDownX = ObjectAnimator.ofFloat(btnGenerarSim, "scaleX", 1.1f, 1f)
            val scaleDownY = ObjectAnimator.ofFloat(btnGenerarSim, "scaleY", 1.1f, 1f)
            scaleDownX.duration = 100
            scaleDownY.duration = 100

            // Ejecutar las animaciones secuencialmente
            val animatorSet = AnimatorSet()
            animatorSet.play(scaleUpX).with(scaleUpY)
            animatorSet.play(scaleDownX).with(scaleDownY).after(scaleUpX)
            animatorSet.start()

            val intent = Intent(this, GenerarEnviarPreSimActivity::class.java)
            startActivity(intent)

        }

        btnMantenerPreSim.setOnClickListener {
            // Animar aumento de tamaño
            val scaleUpX = ObjectAnimator.ofFloat(btnMantenerPreSim, "scaleX", 1f, 1.1f) // Escalar en X
            val scaleUpY = ObjectAnimator.ofFloat(btnMantenerPreSim, "scaleY", 1f, 1.1f) // Escalar en Y
            scaleUpX.duration = 100 // Duración de la animación
            scaleUpY.duration = 100

            // Restaurar al tamaño original
            val scaleDownX = ObjectAnimator.ofFloat(btnMantenerPreSim, "scaleX", 1.1f, 1f)
            val scaleDownY = ObjectAnimator.ofFloat(btnMantenerPreSim, "scaleY", 1.1f, 1f)
            scaleDownX.duration = 100
            scaleDownY.duration = 100

            // Ejecutar las animaciones secuencialmente
            val animatorSet = AnimatorSet()
            animatorSet.play(scaleUpX).with(scaleUpY)
            animatorSet.play(scaleDownX).with(scaleDownY).after(scaleUpX)
            animatorSet.start()

            val intent = Intent(this, MantenerPreSIMActivity::class.java)
            startActivity(intent)

        }

        btnGenerarPreSim.setOnClickListener {
            // Animar aumento de tamaño
            val scaleUpX = ObjectAnimator.ofFloat(btnGenerarPreSim, "scaleX", 1f, 1.1f) // Escalar en X
            val scaleUpY = ObjectAnimator.ofFloat(btnGenerarPreSim, "scaleY", 1f, 1.1f) // Escalar en Y
            scaleUpX.duration = 100 // Duración de la animación
            scaleUpY.duration = 100

            // Restaurar al tamaño original
            val scaleDownX = ObjectAnimator.ofFloat(btnGenerarPreSim, "scaleX", 1.1f, 1f)
            val scaleDownY = ObjectAnimator.ofFloat(btnGenerarPreSim, "scaleY", 1.1f, 1f)
            scaleDownX.duration = 100
            scaleDownY.duration = 100

            // Ejecutar las animaciones secuencialmente
            val animatorSet = AnimatorSet()
            animatorSet.play(scaleUpX).with(scaleUpY)
            animatorSet.play(scaleDownX).with(scaleDownY).after(scaleUpX)
            animatorSet.start()

            val intent = Intent(this, GenerarPreSIM::class.java)
            startActivity(intent)
        }

    }
}