package com.aldi.osakasequelstrip.Model

import java.util.*

data class BatchModel (
    val nomor : Int?,
    val batch : String?,
    val musim : String?,
    val durasi : String?,
    val tglawal : Date?,
    val tglakhir : Date?,
    val destinasi : String?
)