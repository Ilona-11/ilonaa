package com.example.percobaan.model

import java.io.Serializable

data class Buku(
    val judul: String,
    val penulis: String,
    val harga: String,
    val deskripsi: String,
    val gambarResId: Int
) : Serializable
