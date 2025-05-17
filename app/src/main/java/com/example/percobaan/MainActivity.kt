package com.example.percobaan

import android.os.Bundle
import android.widget.TextView
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.percobaan.adapter.BukuAdapter
import com.example.percobaan.model.Buku

class MainActivity : AppCompatActivity() {
    private lateinit var rvBuku: RecyclerView
    private lateinit var bukuAdapter: BukuAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val email = intent.getStringExtra("EMAIL")
        findViewById<TextView>(R.id.tvEmail).text = "Hay:) $email"

        val listBuku = listOf(
            Buku(
                "Morfologi:\n" +
                        "Kajian Proses Pembentukan Kata",
                "Prof. Dr. Drs. I Wayan Simpen, M. Hum",
                "RP. 200.000",
                "Morfologi atau ilmu bentuk kata adalah cabang linguistik yang mengidentifikasi satuan-satuan pembentuk kata sebagai satuan gramatikal. Morfologi mempelajari seluk-beluk bentuk kata serta pengaruh perubahan-perubahan bentuk kata terhadap golongan dan arti kata. Dapat pula dikatakan bahwa morfologi mempelajari seluk-beluk bentuk kata serta fungsi perubahan-perubahan bentuk kata itu, baik fungsi gramatikal maupun fungsi semantik. Dalam ilmu morfologi, terdapat morfem yaitu bagian terkecil dari sebuah kata.\n\n" +
                "Pembagiannya bisa digambarkan sebagaimana berikut ini:\n" +
                        "1. Sebuah wacana dapat dipecah menjadi kalimat.\n" +
                        "2. Kalimat dapat dipecah menjadi bagian makna terkecil, yaitu kata.\n" +
                        "3. Kata dapat terdiri atas beberapa morfem, contohnya menanamkan = me-tanam-kan, bisa juga hanya terdiri atas satu morfem, misalnya rumah, kursi, selamat, eksekusi.",
                R.drawable.buku1
            ),
            Buku(
                "Sejarah Dunia \n" +
                        "Abad Pertengahan",
                "Susan Wise Bauer",
                "RP. 100.000",
                "SEJARAH DUNIA ABAD PERTENGAHAN, adalah sekuel dari best seller mahakarya Susan Wise Bauser, Sejarah Dunia Kuno, yang menyuguhkan kepada kita apa yang telah terjadi di seluruh dunia sejak runtuhnya Imperium Romawai. Bergesernya konstelasi kekuasaan sebagai akibat jatuhnya kekaisaran Romawi, kelahiran Islam di Timur Tengah, hingga awal Perang Salib yang berkepanjangan adalah beberapa esensi perubahan global dunia selam abad pertengahan, yang membawa konsekuensi berubahnya tatanan peradaban dan budaya. \n\n" +
                        "Buku ini juga akan mengantar kita ke buku berikutnya dari seri sejarah dunia Bauer, yakni The History of the Rennaissancwe World. Tradisi naratif Bauer yang ringan, lugas dan memikat, selain juga analisisnya yang tajam dan objektif, terus dipertahankan dalam karya ini, dan membantu kita untuk membaca cerita sejarah denagn sangat menyenangkan.",
                R.drawable.buku2
            ),
            Buku(
                "Jingga Untuk Sandyakala",
                "Esti Kinasih",
                "RP. 90.000",
                "Darah lebih kental daripada air. Tapi, apa benar begitu? Walaupun Ari dan Ata saudara kembar, Ata memilih berpihak pada Angga, anak SMA Brawijaya, musuh bebuyutan Ari. Di mata Ata, Ari adalah orang lain. Di mata Ata, Ari adalah cowok borju, sok berkuasa, terbiasa enak sama Papa. Ata kebalikannya, mesti hidup susah sama Mama. Jadi, Ata bertekad-acak hidup Ari. Sementara itu, Ari nggak nyangka Tari minta putus. Dan ketika Ari menanyakan alasan putus, Tari nggak bisa menjelaskannya. \n\n" +
                        "Baru kali ini, cowok pentolan SMA Airlangga itu merasa kehilangan orang yang dia suka, dan itu bikin Tari. Tapi saat Ari akhirnya punya kesempatan jujur soal perasaannya, apakah Tari masih mau menerima hatinya?",
                R.drawable.buku3
            ),
            Buku(
                "LiT: Planet Luna",
                "Ray Antariksa Yasmine",
                "RP. 120.000",
                "Nawang itu paduan sempurna atas apa yang tidak Luna miliki. Tidak hanya pintar dan baik hati, tetapi juga berprestasi dan punya banyak teman. Sementara Luna tak pernah berhasil meskipun setengah mati ingin bisa bergaul dan punya sahabat. Dia justru dirundung dan dijauhi orang-orang yang dia kira akan menjadi temannya. \n\n" +
                        "Mendengarkan Nawang tertawa-tawa bersama teman-temannya di sebelah rumah hanya mengingatkan Luna pada kesendirian. Luna merasa planetnya akan selalu kosong dan hampa. Dia akan selalu tersisih dari pergaulan dan kesepian sampai tua. Sementara Luna ibarat enigma. Nawang hanya tahu kalau tetangganya itu tertutup dan pemalu. \n\n" +
                        "Gadis itu pernah mengalami perundungan cukup parah yang membuatnya pindah kota saat kecil. Nawang tidak sadar bahwa eksistensinya sebagai anak berprestasi dan punya banyak temanlah yang membuat Luna tak pernah mau didekati. Kendati begitu, Nawang tidak menyerah. Baginya, sosok penyendiri seperti Luna harus ditemani dan dimengerti, bukan dijauhi, apalagi dikerjai. Namun kenyataannya, mendekati Luna tak segampang yang pernah Nawang bayangkan.",
                R.drawable.buku4
            ),
            Buku(
                "Kerajaan Majapahit",
                "Kurnia Alif Fahmi",
                "RP.85.000",
                "Cerita mengenai kejayaan Kerajaan Majapahit telah tertanam dalam catatan sejarah yang megah bagi bangsa Indonesia. Turun-temurun, epik kejayaannya diceritakan sebagai pengingat bahwa di Indonesia pernah berdiri sebuah kerajaan besar yang tidak hanya berhasil menyatukan Nusantara, tetapi juga menguasai wilayah yang meluas hingga ke Asia.",
                R.drawable.buku5
            ) ,
            Buku(
                "Bu Aku Ingin Pelukmu",
                "Reza Mustopa",
                "RP.79.000",
                "Bu, selamat hari Ibu, ya!\n" +
                        "Kalau Ibu lihat aku hari ini pasti Ibu sedih,\n" +
                        "Sebab saat semua anak merayakan hari Ibu melalui pelukan,\n" +
                        "Aku hanya bisa merayakan hari Ibu di atas nisan.  \n" +
                        "Bu, jangan sedih di sana, ya! \n" +
                        "Sebab semakin dewasa, aku semakin kuat, kok.\n" +
                        "Aku sudah besar dan sudah bisa berlayar, meskipun kapalku retak separuh. \n" +
                        "Di hari Ibu ini, bohong kalau aku tidak iri dengan mereka.\n" +
                        "Bu, aku ingin pelukmu, di saat dunia begitu keras menempaku.",
                R.drawable.buku6
            )
        )

        // Setup RecyclerView
        rvBuku = findViewById(R.id.rvBuku)
        rvBuku.layoutManager = LinearLayoutManager(this)
        bukuAdapter = BukuAdapter(listBuku)
        rvBuku.adapter = bukuAdapter

    }
    override fun onBackPressed() {
        val intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()

        super.onBackPressed()
    }
}
