package com.example.smarreqassist

import android.content.Context
import android.text.Html
import androidx.appcompat.app.AlertDialog

fun mostrarDialogo(context: Context, title: String, htmlMessage: String, onAceptar: () -> Unit) {
    val builder = AlertDialog.Builder(context)
    builder.setTitle(title)
    builder.setMessage(Html.fromHtml(htmlMessage, Html.FROM_HTML_MODE_LEGACY))
    builder.setPositiveButton("Aceptar") { dialog, _ ->
        // Ejecutar acción personalizada al aceptar
        onAceptar()
        dialog.dismiss()
    }
    builder.setNegativeButton("Cancelar") { dialog, _ ->
        dialog.dismiss()
    }
    val dialog = builder.create()
    dialog.show()
}