package com.example.prueba_labo02

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.pow


class MainActivity : AppCompatActivity() {
    private lateinit var weightEditTextview: EditText
    private lateinit var heightEditTextview: EditText
    private lateinit var bmiTextview: TextView
    private lateinit var resultTextView: TextView
    private lateinit var descriptionTextView: TextView
    private lateinit var btnCalculate: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()

        btnCalculate.setOnClickListener{
            it.hideKeyboard()
            if (!validar()){
                Toast.makeText(this, "Ingresar datos", Toast.LENGTH_SHORT).show()
            }else if(validar()){
                bmiCalcular()
            }
        }

    }

    private fun bind(){
        weightEditTextview = findViewById(R.id.weightEditText)
        heightEditTextview = findViewById(R.id.heightEditText)
        bmiTextview = findViewById(R.id.bmiTextview)
        btnCalculate = findViewById(R.id.btnCalcular)
        resultTextView = findViewById(R.id.resultTextview)
        descriptionTextView = findViewById(R.id.descriptionTextview)
    }

    @SuppressLint("SetTextI18n")
    private fun bmiCalcular(){
        val weight = weightEditTextview.text.toString().toFloat()
        val height = heightEditTextview.text.toString().toFloat() / 100
        val bmi = weight / height.pow(2)

        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.UP
        val roundoff = df.format(bmi).toFloat()

        if(roundoff < 18.5 ){
            bmiTextview.text = roundoff.toString()
            resultTextView.setTextColor(getColor(R.color.underweight))
            resultTextView.text = "Underweight"
            descriptionTextView.text = "Less than 18.5"
        }else if(bmi in 18.5..24.99){
            bmiTextview.text = roundoff.toString()
            resultTextView.setTextColor(getColor(R.color.normalweight))
            resultTextView.text = "Healthy"
            descriptionTextView.text = "Normal range 18.5 - 24.99"

        } else if(bmi in 25.0..29.99){
            bmiTextview.text = roundoff.toString()
            resultTextView.setTextColor(getColor(R.color.overweight))
            resultTextView.text = "Overweight"
            descriptionTextView.text = "range 25 - 29.99"
        }else{
            bmiTextview.text = roundoff.toString()
            resultTextView.setTextColor(getColor(R.color.obese))
            resultTextView.text = "Obese"
            descriptionTextView.text = "More than 30"
        }
    }

    fun validar(): Boolean{
        var retorno = true
        val weight = weightEditTextview.text.toString()
        val height = heightEditTextview.text.toString()

        if(weight.isEmpty()){
            weightEditTextview.setError("Los campos no deben quedar vacios")
            retorno = false
        }
        if (height.isEmpty()){
            heightEditTextview.setError("Los campos no deben quedar vacios")
            retorno = false
        }

        return retorno
    }

    fun View.hideKeyboard(){
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }
}
