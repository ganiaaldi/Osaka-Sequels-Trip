package com.aldi.osakasequelstrip.Model

data class BatchModel(
    val nomor: Int?,
    val batch: String?,
    val musim: String?,
    val durasi: String?,
    val tglawal: String,
    val tglakhir: String,
    val destinasi: String?
)