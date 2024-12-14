package com.example.smarreqassist

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultadoPrediccionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado_prediccion)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        val btnGuardarPreSim = findViewById<Button>(R.id.btnGuardarPreSim)
        val btnMantenerPreSim = findViewById<Button>(R.id.btnMantenerPreSim)
        val btnRealizarOtraPreSim = findViewById<Button>(R.id.btnRealizarOtraPreSim)
        val btnCancelar = findViewById<Button>(R.id.btnCancelar)

        btnCancelar.setOnClickListener {
            // Animar aumento de tamaño
            val scaleUpX = ObjectAnimator.ofFloat(btnCancelar, "scaleX", 1f, 1.1f) // Escalar en X
            val scaleUpY = ObjectAnimator.ofFloat(btnCancelar, "scaleY", 1f, 1.1f) // Escalar en Y
            scaleUpX.duration = 100 // Duración de la animación
            scaleUpY.duration = 100

            // Restaurar al tamaño original
            val scaleDownX = ObjectAnimator.ofFloat(btnCancelar, "scaleX", 1.1f, 1f)
            val scaleDownY = ObjectAnimator.ofFloat(btnCancelar, "scaleY", 1.1f, 1f)
            scaleDownX.duration = 100
            scaleDownY.duration = 100

            // Ejecutar las animaciones secuencialmente
            val animatorSet = AnimatorSet()
            animatorSet.play(scaleUpX).with(scaleUpY)
            animatorSet.play(scaleDownX).with(scaleDownY).after(scaleUpX)
            animatorSet.start()

            val intent = Intent(this, Menu::class.java)
            startActivity(intent)
        }

        btnGuardarPreSim.setOnClickListener {
            // Animar aumento de tamaño
            val scaleUpX = ObjectAnimator.ofFloat(btnGuardarPreSim, "scaleX", 1f, 1.1f) // Escalar en X
            val scaleUpY = ObjectAnimator.ofFloat(btnGuardarPreSim, "scaleY", 1f, 1.1f) // Escalar en Y
            scaleUpX.duration = 100 // Duración de la animación
            scaleUpY.duration = 100

            // Restaurar al tamaño original
            val scaleDownX = ObjectAnimator.ofFloat(btnGuardarPreSim, "scaleX", 1.1f, 1f)
            val scaleDownY = ObjectAnimator.ofFloat(btnGuardarPreSim, "scaleY", 1.1f, 1f)
            scaleDownX.duration = 100
            scaleDownY.duration = 100

            // Ejecutar las animaciones secuencialmente
            val animatorSet = AnimatorSet()
            animatorSet.play(scaleUpX).with(scaleUpY)
            animatorSet.play(scaleDownX).with(scaleDownY).after(scaleUpX)
            animatorSet.start()

            val intent = Intent(this, PreSimGeneradaActivity::class.java)
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

        btnRealizarOtraPreSim.setOnClickListener {
            // Animar aumento de tamaño
            val scaleUpX = ObjectAnimator.ofFloat(btnRealizarOtraPreSim, "scaleX", 1f, 1.1f) // Escalar en X
            val scaleUpY = ObjectAnimator.ofFloat(btnRealizarOtraPreSim, "scaleY", 1f, 1.1f) // Escalar en Y
            scaleUpX.duration = 100 // Duración de la animación
            scaleUpY.duration = 100

            // Restaurar al tamaño original
            val scaleDownX = ObjectAnimator.ofFloat(btnRealizarOtraPreSim, "scaleX", 1.1f, 1f)
            val scaleDownY = ObjectAnimator.ofFloat(btnRealizarOtraPreSim, "scaleY", 1.1f, 1f)
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