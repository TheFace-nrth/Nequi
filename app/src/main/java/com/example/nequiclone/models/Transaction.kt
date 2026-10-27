package com.example.nequiclone.models

data class Transaction(
    val title: String,
    val subtitle: String,
    val amount: Double,
    val date: String,
    val type: String // "send" | "receive"
)
