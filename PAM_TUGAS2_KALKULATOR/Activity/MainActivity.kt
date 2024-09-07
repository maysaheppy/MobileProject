package com.example.kalkulator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var operasi: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val radioTambah = findViewById<RadioButton>(R.id.radioTambah)
        val radioKurang = findViewById<RadioButton>(R.id.radioKurang)
        val radioKali = findViewById<RadioButton>(R.id.radioKali)
        val radioBagi = findViewById<RadioButton>(R.id.radioBagi)
        val buttonHitung = findViewById<Button>(R.id.buttonHitung)
        val bilangan1 = findViewById<EditText>(R.id.editBil1)
        val bilangan2 = findViewById<EditText>(R.id.editBil2)

        radioTambah.setOnClickListener {
            operasi = "+"
        }

        radioKurang.setOnClickListener {
            operasi = "-"
        }

        radioKali.setOnClickListener {
            operasi = "*"
        }

        radioBagi.setOnClickListener {
            operasi = "/"
        }

        buttonHitung.setOnClickListener {
            val bil1 = bilangan1.text.toString().toDoubleOrNull()
            val bil2 = bilangan2.text.toString().toDoubleOrNull()

            if (bil1 != null && bil2 != null) {
                val hasil = hitung(operasi, bil1, bil2)
                val intent = Intent(this, MainActivity2::class.java)
                intent.putExtra("hasil", hasil.toString())
                startActivity(intent)
            } else {
            }
        }

    }

    private fun hitung(operasi: String, bilangan1: Double, bilangan2: Double): Double {
        return when (operasi) {
            "+" -> bilangan1 + bilangan2
            "-" -> bilangan1 - bilangan2
            "*" -> bilangan1 * bilangan2
            "/" -> {
                if (bilangan2 == 0.0) {
                    0.0
                } else {
                    bilangan1 / bilangan2
                }
            }
            else -> 0.0
        }
    }
}