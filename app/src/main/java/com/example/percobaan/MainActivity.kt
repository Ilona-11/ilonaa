package com.example.percobaan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.percobaan.ui.theme.PercobaanTheme
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.app.AlertDialog

import android.content.Intent
import android.widget.*
import android.graphics.Color


class MainActivity : ComponentActivity() {
    private lateinit var editName: EditText
    private lateinit var btnUcapan: Button
    private lateinit var buttonTampilkan: Button
    private lateinit var buttonShare: Button
    private lateinit var textUcapan: TextView

    private var selectedUcapan: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi komponen
        editName = findViewById(R.id.editName)
        btnUcapan = findViewById(R.id.btnUcapan)
        buttonTampilkan = findViewById(R.id.buttonTampilkan)
        buttonShare = findViewById(R.id.buttonShare)
        textUcapan = findViewById(R.id.textUcapan)

        val daftarUcapan = resources.getStringArray(R.array.daftar_ucapan)

        // Ketika tombol "Pilih Ucapan" diklik
        btnUcapan.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Pilih Ucapan")
            builder.setItems(daftarUcapan) { _, which ->
                selectedUcapan = daftarUcapan[which]
                btnUcapan.text = selectedUcapan
            }
            builder.create().show()
        }

        // Tampilkan ucapan + nama + ganti background
        buttonTampilkan.setOnClickListener {
            val nama = editName.text.toString().trim()

            if (nama.isEmpty() || selectedUcapan.isEmpty()) {
                Toast.makeText(this, "Harap isi nama dan pilih ucapan!", Toast.LENGTH_SHORT).show()
            } else {
                val ucapanLengkap = "$selectedUcapan, $nama!"
                textUcapan.text = ucapanLengkap

                // Ubah warna teks jadi putih dan tambahkan bayangan hitam
                textUcapan.setTextColor(Color.BLACK)
                textUcapan.setShadowLayer(4f, 2f, 2f, Color.WHITE)

                // Ganti background berdasarkan pilihan ucapan
                when (selectedUcapan) {
                    "Selamat Ulang Tahun" -> textUcapan.setBackgroundResource(R.drawable.ultah)
                    "Selamat Hari Ibu" -> textUcapan.setBackgroundResource(R.drawable.hari_ibu)
                    "Selamat Wisuda" -> textUcapan.setBackgroundResource(R.drawable.wisuda)
                    "Semoga Cepat Sembuh" -> textUcapan.setBackgroundResource(R.drawable.sakit)
                    else -> textUcapan.setBackgroundResource(R.drawable.default_bg)
                }
            }
        }

        // Bagikan ucapan
        buttonShare.setOnClickListener {
            val ucapan = textUcapan.text.toString()
            if (ucapan == "Ucapan akan muncul di sini") {
                Toast.makeText(this, "Belum ada ucapan yang ditampilkan!", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, ucapan)
                    type = "text/plain"
                }
                startActivity(Intent.createChooser(intent, "Bagikan ucapan via"))
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PercobaanTheme {
        Greeting("Android")
    }
}