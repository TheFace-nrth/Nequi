package com.example.nequiclone

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.nequiclone.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnContinue.setOnClickListener {
            val phone = binding.etPhone.text?.toString().trim()
            if (phone.isNotEmpty() && phone.length == 10) {
                startActivity(Intent(this, HomeActivity::class.java))
            } else {
                Toast.makeText(this, "Ingresa un número válido de 10 dígitos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
