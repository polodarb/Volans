package com.polodarb.volans.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.ColumnInfo.Companion.INTEGER
import androidx.room.ColumnInfo.Companion.TEXT
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "place")
data class Place(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "place_code", typeAffinity = INTEGER) val placeCode: Int,
    @ColumnInfo(name = "place_status", typeAffinity = TEXT) val placeNumber: String
)
