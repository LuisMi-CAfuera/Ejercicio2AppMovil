package com.example.ejercicio2appmovil

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText


//ViewBinding
import com.example.ejercicio2appmovil.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var cont = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button2.setOnClickListener {

            cont++
            binding.textView.text = cont.toString()
            binding.editTextTextPersonName.clearFocus()
        }
        binding.button.setOnClickListener {
            if (cont > 0){
                cont--
                binding.textView.text = cont.toString()

            }
            binding.editTextTextPersonName.clearFocus()
        }

        binding.editTextTextPersonName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                try {
                    cont = s.toString().toInt()
                    binding.textView.text = cont.toString()
                } catch (e: NumberFormatException) {
                    binding.editTextTextPersonName.text.clear()
                    binding.textView.text = "0"
                }
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })




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


















}