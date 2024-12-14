package com.example.smarreqassist

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class GenerarEnviarPreSimActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_generar_enviar_pre_sim)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnGenerarSIM = findViewById<Button>(R.id.btnGenerarSIM)
        val detalleContainer = findViewById<LinearLayout>(R.id.detalleContainer)
        val btnMostrarDetalle =  findViewById<Button>(R.id.btnMostrarDetalle)

        detalleContainer.visibility = View.GONE;
        btnGenerarSIM.setOnClickListener {
            val intent = Intent(this, GenerarSimActivity::class.java)
            startActivity(intent)
        }

        btnMostrarDetalle.setOnClickListener {
            detalleContainer.visibility = View.VISIBLE;
        }
    }
}