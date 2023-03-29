package com.example.practica_labo03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import java.math.RoundingMode
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    //UI Variables
    private lateinit var imgFiveCents: ImageView
    private lateinit var imgTenCents: ImageView
    private lateinit var imgQuarter: ImageView
    private lateinit var imgOneDollar: ImageView
    private lateinit var textViewContador: TextView


    //Data elements
    var suma = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
        clickListeners()
    }

    private fun bind(){
        imgFiveCents = findViewById(R.id.imgFiveCents)
        imgTenCents = findViewById(R.id.imgTenCents)
        imgQuarter = findViewById(R.id.imgQuarter)
        imgOneDollar = findViewById(R.id.imgOneDollar)
        textViewContador = findViewById(R.id.txtViewContador)
    }

    private fun clickListeners(){
        imgFiveCents.setOnClickListener{
            val fiveCents = 0.05

            suma = suma + fiveCents

            val df = DecimalFormat("#.##")
            df.roundingMode = RoundingMode.UP
            val roundoff = df.format(suma).toDouble()

            textViewContador.text = roundoff.toString()

    }
        imgTenCents.setOnClickListener{
            val tenCents = 0.10

            suma  = suma + tenCents

            val df = DecimalFormat("#.##")
            df.roundingMode = RoundingMode.UP
            val roundoff = df.format(suma).toDouble()

            textViewContador.text = roundoff.toString()

        }
        imgQuarter.setOnClickListener{
            val quarter = 0.25

            suma = suma + quarter

            val df = DecimalFormat("#.##")
            df.roundingMode = RoundingMode.UP
            val roundoff = df.format(suma).toDouble()

            textViewContador.text = roundoff.toString()

        }
        imgOneDollar.setOnClickListener{
            val oneDollar = 1.00

            suma = suma + oneDollar

            val df = DecimalFormat("#.##")
            df.roundingMode = RoundingMode.UP
            val roundoff = df.format(suma).toDouble()

            textViewContador.text = roundoff.toString()

        }
    }
}