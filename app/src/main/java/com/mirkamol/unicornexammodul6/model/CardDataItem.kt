package com.mirkamol.unicornexammodul6.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "card")
data class CardDataItem(
    @PrimaryKey
    val id: String,
    val card_name: String,
    val card_number: String,
    val cvv: String,
    val data: String,

)