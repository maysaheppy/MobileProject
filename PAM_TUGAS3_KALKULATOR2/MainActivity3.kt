package com.example.kalkulator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity3 : AppCompatActivity() {
    private var currentNumber = ""
    private var firstNumber = ""
    private var operator = ""
    private var textMasuk = ""

    private lateinit var outputnya: TextView
    private lateinit var inputan: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //inisialisasi button dan textview
        outputnya = findViewById(R.id.outputnya)
        inputan = findViewById(R.id.inputan)
        val satu = findViewById<Button>(R.id.satu)
        val dua = findViewById<Button>(R.id.dua)
        val tiga = findViewById<Button>(R.id.tiga)
        val empat = findViewById<Button>(R.id.empat)
        val lima = findViewById<Button>(R.id.lima)
        val enam = findViewById<Button>(R.id.enam)
        val tujuh = findViewById<Button>(R.id.tujuh)
        val delapan = findViewById<Button>(R.id.delapan)
        val sembilan = findViewById<Button>(R.id.sembilan)
        val nool = findViewById<Button>(R.id.nol)
        val tambah = findViewById<Button>(R.id.tambah)
        val kali = findViewById<Button>(R.id.kali)
        val bagi = findViewById<Button>(R.id.bagi)
        val kurang = findViewById<Button>(R.id.kurang)
        val koma = findViewById<Button>(R.id.koma)
        val samaDengan = findViewById<Button>(R.id.samaDengan)
        val clear = findViewById<Button>(R.id.clear)

        //listener untuk tombol angka
        satu.setOnClickListener {
            currentNumber += "1"
            outputnya.text = currentNumber
            textMasuk += "1"
        }
        dua.setOnClickListener {
            currentNumber += "2"
            outputnya.text = currentNumber
            textMasuk += "2"
        }
        tiga.setOnClickListener {
            currentNumber += "3"
            outputnya.text = currentNumber
            textMasuk += "3"
        }
        empat.setOnClickListener {
            currentNumber += "4"
            outputnya.text = currentNumber
            textMasuk += "4"
        }
        lima.setOnClickListener {
            currentNumber += "5"
            outputnya.text = currentNumber
            textMasuk += "5"
        }
        enam.setOnClickListener {
            currentNumber += "6"
            outputnya.text = currentNumber
            textMasuk += "6"
        }
        tujuh.setOnClickListener {
            currentNumber += "7"
            outputnya.text = currentNumber
            textMasuk += "7"
        }
        delapan.setOnClickListener {
            currentNumber += "8"
            outputnya.text = currentNumber
            textMasuk += "8"
        }
        sembilan.setOnClickListener {
            currentNumber += "9"
            outputnya.text = currentNumber
            textMasuk += "9"
        }
        nool.setOnClickListener {
            currentNumber += "0"
            outputnya.text = currentNumber
            textMasuk += "0"
        }
        koma.setOnClickListener {
            currentNumber += "."
            outputnya.text = currentNumber
            textMasuk += "."
        }

        //listener untuk operator
        tambah.setOnClickListener {
            operator = "+"
            firstNumber = currentNumber
            textMasuk += "+"
            currentNumber = ""
        }
        kurang.setOnClickListener {
            operator = "-"
            firstNumber = currentNumber
            textMasuk += "-"
            currentNumber = ""
        }
        kali.setOnClickListener {
            operator = "*"
            firstNumber = currentNumber
            textMasuk += "x"
            currentNumber = ""
        }
        bagi.setOnClickListener {
            operator = "/"
            firstNumber = currentNumber
            textMasuk += "/"
            currentNumber = ""
        }

        //listener untuk tombol sama dengan

        samaDengan.setOnClickListener {
            val num1 = firstNumber.toDouble()
            val num2 = currentNumber.toDouble()
            inputan.text = textMasuk
            var result = 0.0
            when (operator) {
                "+" -> result = num1 + num2
                "-" -> result = num1 - num2
                "*" -> result = num1 * num2
                "/" -> {
                    if (num2 == 0.0) {
                        result = 0.0
                    } else {
                        result = num1 / num2
                    }
                }
            }
            outputnya.text = result.toString()
            currentNumber = result.toString()
        }

        //listener untuk clear
        clear.setOnClickListener {
            currentNumber = ""
            operator = ""
            outputnya.text = ""
            textMasuk = ""
            inputan.text = ""
        }
    }
}