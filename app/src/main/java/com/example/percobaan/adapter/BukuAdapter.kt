package com.example.percobaan.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.percobaan.DetailActivity
import com.example.percobaan.R
import com.example.percobaan.model.Buku

class BukuAdapter(
    private val listBuku: List<Buku>
) : RecyclerView.Adapter<BukuAdapter.BukuViewHolder>() {

    inner class BukuViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgBuku: ImageView = view.findViewById(R.id.imgBuku)
        val txtJudul: TextView = view.findViewById(R.id.txtJudul)
        val txtHarga: TextView = view.findViewById(R.id.txtHarga)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BukuViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_buku, parent, false)
        return BukuViewHolder(view)
    }

    override fun onBindViewHolder(holder: BukuViewHolder, position: Int) {
        val buku = listBuku[position]
        holder.txtJudul.text = buku.judul
        holder.imgBuku.setImageResource(buku.gambarResId)
        holder.txtHarga.text = buku.harga

        holder.imgBuku.contentDescription = "Gambar buku: ${buku.judul}"
        holder.txtJudul.contentDescription = buku.judul

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("gambarResId", buku.gambarResId)
            intent.putExtra("judul", buku.judul)
            intent.putExtra("penulis", buku.penulis)
            intent.putExtra("harga", buku.harga)
            intent.putExtra("deskripsi", buku.deskripsi)
            context.startActivity(intent)
        }

    }

    override fun getItemCount() = listBuku.size
}
