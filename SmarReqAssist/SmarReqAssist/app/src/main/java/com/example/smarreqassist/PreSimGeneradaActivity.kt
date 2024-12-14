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

class PreSimGeneradaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pre_sim_generada)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnIrModuloSim = findViewById<Button>(R.id.btnIrModuloSim)
        val btnInicio = findViewById<Button>(R.id.btnInicio)
        val btnGenerarNuevaPreSim = findViewById<Button>(R.id.btnGenerarNuevaPreSim)

        btnIrModuloSim.setOnClickListener {
            // Animar aumento de tamaño
            val scaleUpX = ObjectAnimator.ofFloat(btnIrModuloSim, "scaleX", 1f, 1.1f) // Escalar en X
            val scaleUpY = ObjectAnimator.ofFloat(btnIrModuloSim, "scaleY", 1f, 1.1f) // Escalar en Y
            scaleUpX.duration = 100 // Duración de la animación
            scaleUpY.duration = 100

            // Restaurar al tamaño original
            val scaleDownX = ObjectAnimator.ofFloat(btnIrModuloSim, "scaleX", 1.1f, 1f)
            val scaleDownY = ObjectAnimator.ofFloat(btnIrModuloSim, "scaleY", 1.1f, 1f)
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

        btnInicio.setOnClickListener {
            // Animar aumento de tamaño
            val scaleUpX = ObjectAnimator.ofFloat(btnInicio, "scaleX", 1f, 1.1f) // Escalar en X
            val scaleUpY = ObjectAnimator.ofFloat(btnInicio, "scaleY", 1f, 1.1f) // Escalar en Y
            scaleUpX.duration = 100 // Duración de la animación
            scaleUpY.duration = 100

            // Restaurar al tamaño original
            val scaleDownX = ObjectAnimator.ofFloat(btnInicio, "scaleX", 1.1f, 1f)
            val scaleDownY = ObjectAnimator.ofFloat(btnInicio, "scaleY", 1.1f, 1f)
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

        btnGenerarNuevaPreSim.setOnClickListener {
            // Animar aumento de tamaño
            val scaleUpX = ObjectAnimator.ofFloat(btnGenerarNuevaPreSim, "scaleX", 1f, 1.1f) // Escalar en X
            val scaleUpY = ObjectAnimator.ofFloat(btnGenerarNuevaPreSim, "scaleY", 1f, 1.1f) // Escalar en Y
            scaleUpX.duration = 100 // Duración de la animación
            scaleUpY.duration = 100

            // Restaurar al tamaño original
            val scaleDownX = ObjectAnimator.ofFloat(btnGenerarNuevaPreSim, "scaleX", 1.1f, 1f)
            val scaleDownY = ObjectAnimator.ofFloat(btnGenerarNuevaPreSim, "scaleY", 1.1f, 1f)
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