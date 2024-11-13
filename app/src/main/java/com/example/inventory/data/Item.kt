package com.example.inventory.data

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
Kelas Item ini adalah entitas dalam Room Database yang merepresentasikan satu baris dalam tabel
bernama "items". Setiap instance Item memiliki properti id sebagai primary key yang otomatis
ter-generate, serta atribut name, price, dan quantity untuk menyimpan nama, harga, dan jumlah item.
Anotasi @Entity digunakan untuk menandai kelas ini sebagai tabel, sedangkan @PrimaryKey(autoGenerate
= true) menandai id sebagai primary key yang diisi otomatis oleh Room. */


@Entity(tableName = "items")
data class Item(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val price: Double,
    val quantity: Int
)