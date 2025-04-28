package com.example.percobaan

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AlertDialog

class InputActivity : AppCompatActivity() {
    private lateinit var editName: EditText
    private lateinit var btnUcapan: Button
    private lateinit var btnNext: Button
    private var selectedUcapan: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)

        editName = findViewById(R.id.editName)
        btnUcapan = findViewById(R.id.btnUcapan)
        btnNext = findViewById(R.id.btnNext)

        val daftarUcapan = resources.getStringArray(R.array.daftar_ucapan)

        btnUcapan.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Pilih Ucapan")
            builder.setItems(daftarUcapan) { _, which ->
                selectedUcapan = daftarUcapan[which]
                btnUcapan.text = selectedUcapan
            }
            builder.create().show()
        }

        btnNext.setOnClickListener {
            val nama = editName.text.toString().trim()

            if (nama.isEmpty() || selectedUcapan.isEmpty()) {
                Toast.makeText(this, "Harap isi nama dan pilih ucapan!", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, ResultActivity::class.java).apply {
                    putExtra("nama", nama)
                    putExtra("ucapan", selectedUcapan)
                }
                startActivity(intent)
            }
        }
    }
}