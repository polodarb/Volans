package com.polodarb.volans.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.ColumnInfo.Companion.INTEGER
import androidx.room.ColumnInfo.Companion.TEXT
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "buy_ticket")
data class BuyTicket(
    @PrimaryKey val flight_code_buy: Int,
    val airport_city1: String,
    val airport_city2: String,
    val airport_name1: String,
    val airport_name2: String,
    val departure_time: String,
    val arrival_time: String,
    val departure_date: String,
    val arrival_date: String
)
