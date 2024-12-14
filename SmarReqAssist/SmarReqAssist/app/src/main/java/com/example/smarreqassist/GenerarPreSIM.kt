package com.example.smarreqassist

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar
import android.os.Handler
import android.os.Looper

class GenerarPreSIM : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_generar_pre_sim)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editFecha = findViewById<EditText>(R.id.editFecha)
        val button = findViewById<Button>(R.id.btnIngresar)

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

        button.setOnClickListener {
            // Animar aumento de tamaño
            val scaleUpX = ObjectAnimator.ofFloat(button, "scaleX", 1f, 1.1f) // Escalar en X
            val scaleUpY = ObjectAnimator.ofFloat(button, "scaleY", 1f, 1.1f) // Escalar en Y
            scaleUpX.duration = 100 // Duración de la animación
            scaleUpY.duration = 100

            // Restaurar al tamaño original
            val scaleDownX = ObjectAnimator.ofFloat(button, "scaleX", 1.1f, 1f)
            val scaleDownY = ObjectAnimator.ofFloat(button, "scaleY", 1.1f, 1f)
            scaleDownX.duration = 100
            scaleDownY.duration = 100

            // Ejecutar las animaciones secuencialmente
            val animatorSet = AnimatorSet()
            animatorSet.play(scaleUpX).with(scaleUpY)
            animatorSet.play(scaleDownX).with(scaleDownY).after(scaleUpX)
            animatorSet.start()

            // Para mostrar el diálogo
            val progressDialog = ProgressDialogFragment()
            progressDialog.isCancelable = false // Opcional: para evitar que el usuario cierre el modal
            progressDialog.show(supportFragmentManager, "progressDialog")


            Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(this, ResultadoPrediccionActivity   ::class.java)
                startActivity(intent)
            }, 1000)
        }

        this.setItemsSpinnerActividad()
        this.setItemsSpinnerEspecialidad()
        this.setItemsSpinnerNivel()
        this.setItemsSpinnerArea()
        this.setItemsSpinnerPlano()
        this.setItemsSpinnerFamilia()
        this.setItemsSpinnerRegion()
        this.setItemsSpinnerFase()
        this.setItemsSpinnerEpoca()
        this.setItemsSpinnerDuracion()
    }


    fun setItemsSpinnerActividad(){
        val spinner = findViewById<Spinner>(R.id.spnActividad)
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.items_actividad,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
    }

    fun setItemsSpinnerEspecialidad(){
        val spinner = findViewById<Spinner>(R.id.spnEspecialidad)
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.items_especialidad,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
    }

    fun setItemsSpinnerNivel(){
        val spinner = findViewById<Spinner>(R.id.spnNivel)
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.items_nivel,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
    }

    fun setItemsSpinnerArea(){
        val spinner = findViewById<Spinner>(R.id.spnArea)
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.items_area,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
    }

    fun setItemsSpinnerPlano(){
        val spinner = findViewById<Spinner>(R.id.spnPlano)
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.items_plano,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
    }

    fun setItemsSpinnerFamilia(){
        val spinner = findViewById<Spinner>(R.id.spnFamilia)
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.items_familia,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
    }

    fun setItemsSpinnerRegion(){
        val spinner = findViewById<Spinner>(R.id.spnRegion)
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.items_region,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
    }

    fun setItemsSpinnerFase(){
        val spinner = findViewById<Spinner>(R.id.spnFase)
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.items_fase,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
    }

    fun setItemsSpinnerEpoca(){
        val spinner = findViewById<Spinner>(R.id.spnEpoca)
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.items_epoca,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
    }

    fun setItemsSpinnerDuracion(){
        val spinner = findViewById<Spinner>(R.id.spnDuracion)
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.items_duracion,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
    }
}