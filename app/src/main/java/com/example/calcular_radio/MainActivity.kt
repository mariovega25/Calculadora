package com.example.calcular_radio

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var ed1:EditText;
    lateinit var ed2:EditText;
    lateinit var r1:RadioButton;
    lateinit var r2:RadioButton;
    lateinit var tvRes:TextView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        ed1 = findViewById<EditText>(R.id.EdNum1);
        ed2 = findViewById<EditText>(R.id.EdNum2);
        r1 = findViewById<RadioButton>(R.id.idRBtnSum);
        r2 = findViewById<RadioButton>(R.id.idRBtnRes);
        tvRes = findViewById<TextView>(R.id.IdTxtV);

    }

    fun calcular(view: View){
        var strN1= ed1.text.toString()
        var strN2=ed2.text.toString()

        // Validar que los EditText no estén vacíos
        if (strN1.isEmpty() || strN2.isEmpty()) {
            tvRes.text = "Por favor, ingresa ambos números"
            return
        }

        val num1 = strN1.toDouble()
        val num2 = strN2.toDouble()

        // Realizar la operación según el RadioButton seleccionado
        val resultado = when {
            r1.isChecked -> num1 + num2  // Si el RadioButton de suma está seleccionado
            r2.isChecked -> num1 - num2  // Si el RadioButton de resta está seleccionado
            else -> {
                tvRes.text = "Selecciona una operación"
                return
            }
        }

        // Mostrar el resultado en el TextView
        tvRes.text = "Resultado: $resultado"
    }


    fun limpiar(view: View){
        ed1.text.clear();
        ed2.text.clear();
        r1.isChecked = false;
        r2.isChecked = false;
        tvRes.text=" 0 ";

    }

}