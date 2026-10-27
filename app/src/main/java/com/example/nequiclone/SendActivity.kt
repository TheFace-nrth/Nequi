package com.example.nequiclone

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.nequiclone.databinding.ActivitySendBinding

class SendActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySendBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySendBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = getString(R.string.send_title)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.btnSendMoney.setOnClickListener {
            val amount = binding.etAmount.text?.toString().trim()
            val recipient = binding.etRecipient.text?.toString().trim()
            if (amount.isEmpty() || recipient.isEmpty()) {
                Toast.makeText(this, "Completa monto y destinatario", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            Toast.makeText(this, "Enviado $amount COP a $recipient", Toast.LENGTH_SHORT).show()
            setResult(RESULT_OK)
            finish()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
