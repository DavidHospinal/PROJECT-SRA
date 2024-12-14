package com.example.smarreqassist

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

class GenerarSimActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_generar_sim)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        val editFecha = findViewById<EditText>(R.id.editFecha)
        val txtSolpedNroxd = findViewById<TextView>(R.id.txtSolpedNroxd)

        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        editFecha.setOnClickListener {
            val datePicker = DatePickerDialog(
                this,
                { _, selectedYear, selectedMonth, selectedDay ->
                    // Formatea la fecha seleccionada y ponla en el EditText
                    val formattedDate = "${selectedDay}/${selectedMonth + 1}/$selectedYear"
                    editFecha.setText(formattedDate)
                },
                year,
                month,
                day
            )
            datePicker.show()
        }

        val btnGenerarSim = findViewById<Button>(R.id.btnGenerarSim)
        val btnGestionarAprobacionSIM = findViewById<Button>(R.id.btnGestionarAprobacionSIM)
        val txtMensajeExitoso = findViewById<TextView>(R.id.txtMensajeExitoso)

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

            //txtMensajeExitoso.visibility = View.VISIBLE
            txtSolpedNroxd.text = "SAP0098"
            val messageTextHTML = """
                <p>¡SIM Generado Exitosamente y Enviada para Aprobación!</p>
                <p><span style="color: blue;"><b>Nota: </b>SAP0098 Generada Automáticamente, Pendiente de Liberación en SmartReq Assist, Hasta su Aprobación.</span></p>
            """.trimIndent()
            mostrarDialogo(this,"Generar SIM",messageTextHTML){

            }

            //val intent = Intent(this, GenerarEnviarPreSimActivity::class.java)
            //startActivity(intent)
        }

        btnGestionarAprobacionSIM.setOnClickListener {
            // Animar aumento de tamaño
            val scaleUpX = ObjectAnimator.ofFloat(btnGestionarAprobacionSIM, "scaleX", 1f, 1.1f) // Escalar en X
            val scaleUpY = ObjectAnimator.ofFloat(btnGestionarAprobacionSIM, "scaleY", 1f, 1.1f) // Escalar en Y
            scaleUpX.duration = 100 // Duración de la animación
            scaleUpY.duration = 100

            // Restaurar al tamaño original
            val scaleDownX = ObjectAnimator.ofFloat(btnGestionarAprobacionSIM, "scaleX", 1.1f, 1f)
            val scaleDownY = ObjectAnimator.ofFloat(btnGestionarAprobacionSIM, "scaleY", 1.1f, 1f)
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
    }
}