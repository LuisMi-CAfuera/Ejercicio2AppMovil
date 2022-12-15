package com.example.ejercicio2appmovil

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


//ViewBinding
import com.example.ejercicio2appmovil.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var cont = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        binding.button2.setOnClickListener {
            sumar()
            binding.editTextTextPersonName.clearFocus()
        }
        binding.button.setOnClickListener {
            restar()
            binding.editTextTextPersonName.clearFocus()
        }

        binding.editTextTextPersonName.setOnFocusChangeListener { _, hasFocus ->
           if (!hasFocus) {
               binding.textView.text = binding.editTextTextPersonName.text
            }
        }


        binding.editTextTextPersonName.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                binding.button.setBackgroundColor(Color.parseColor("#FF0000"))
                binding.button2.setBackgroundColor(Color.parseColor("#FF0000"))
            } else {
                binding.button.setBackgroundColor(Color.parseColor("#FF018786"))
                binding.button2.setBackgroundColor(Color.parseColor("#FF018786"))
            }
        }


    }




    fun sumar(){
        cont++
        binding.textView.text = cont.toString()
    }

    fun restar(){
        if (cont > 0){
            cont--
            binding.textView.text = cont.toString()
        }
    }












}