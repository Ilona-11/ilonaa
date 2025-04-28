package com.example.percobaan

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import android.graphics.Color
import android.widget.Button

class ResultActivity : AppCompatActivity() {
    private lateinit var textUcapan: TextView
    private lateinit var btnShare: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        textUcapan = findViewById(R.id.textUcapan)
        btnShare = findViewById(R.id.buttonShare)

        val nama = intent.getStringExtra("nama")
        val ucapan = intent.getStringExtra("ucapan")

        val ucapanLengkap = "$ucapan, $nama!"
        textUcapan.text = ucapanLengkap
        textUcapan.setTextColor(Color.BLACK)
        textUcapan.setShadowLayer(4f, 2f, 2f, Color.WHITE)

        when (ucapan) {
            "Selamat Ulang Tahun" -> textUcapan.setBackgroundResource(R.drawable.ultah)
            "Selamat Hari Ibu" -> textUcapan.setBackgroundResource(R.drawable.hari_ibu)
            "Selamat Wisuda" -> textUcapan.setBackgroundResource(R.drawable.wisuda)
            "Semoga Cepat Sembuh" -> textUcapan.setBackgroundResource(R.drawable.sakit)
            else -> textUcapan.setBackgroundResource(R.drawable.default_bg)
        }

        btnShare.setOnClickListener {
            val intentShare = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, ucapanLengkap)
                type = "text/plain"
            }
            startActivity(Intent.createChooser(intentShare, "Bagikan ucapan via"))
        }
    }
}
