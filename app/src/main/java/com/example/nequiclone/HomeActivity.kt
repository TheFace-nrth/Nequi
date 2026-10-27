package com.example.nequiclone

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nequiclone.adapters.TransactionAdapter
import com.example.nequiclone.databinding.ActivityHomeBinding
import com.example.nequiclone.models.Transaction

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var adapter: TransactionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = getString(R.string.app_name)

        binding.btnSend.setOnClickListener {
            startActivity(Intent(this, SendActivity::class.java))
        }
        binding.btnReceive.setOnClickListener {
            Toast.makeText(this, "Función recibir en desarrollo", Toast.LENGTH_SHORT).show()
        }

        adapter = TransactionAdapter(mockTransactions())
        binding.rvTransactions.layoutManager = LinearLayoutManager(this)
        binding.rvTransactions.adapter = adapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun mockTransactions(): List<Transaction> {
        return listOf(
            Transaction("Recibido de", "María Gómez • +57 310 111 2222", 50000.0, "Hoy, 10:15", "receive"),
            Transaction("Enviado a", "Tienda del Barrio • +57 320 333 4444", -15000.0, "Ayer, 18:45", "send"),
            Transaction("Recibido de", "Carlos Ruiz • +57 315 555 6666", 100000.0, "Ayer, 12:00", "receive"),
            Transaction("Enviado a", "Netflix Suscripción", -16900.0, "2 días atrás, 09:00", "send"),
            Transaction("Recibido de", "Pago nómina • Empresa S.A.S.", 1200000.0, "3 días atrás, 08:00", "receive")
        )
    }
}
