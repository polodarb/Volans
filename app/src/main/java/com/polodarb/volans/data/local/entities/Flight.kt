package com.polodarb.volans.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.ColumnInfo.Companion.INTEGER
import androidx.room.ColumnInfo.Companion.REAL
import androidx.room.ColumnInfo.Companion.TEXT
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.sql.Types.DATE
import java.sql.Types.TIME

@Entity(
    tableName = "flight",
    foreignKeys = [ForeignKey(
        entity = Airport::class,
        parentColumns = arrayOf("airport_code"),
        childColumns = arrayOf("departure_code"),
        onDelete = ForeignKey.CASCADE
    ), ForeignKey(
        entity = Airport::class,
        parentColumns = arrayOf("airport_code"),
        childColumns = arrayOf("arrival_code"),
        onDelete = ForeignKey.CASCADE
    )]
)
data class Flight(
    @ColumnInfo(name = "flight_code", typeAffinity = INTEGER) @PrimaryKey(autoGenerate = true) val flightCode: Int,
    @ColumnInfo(name = "departure_code", typeAffinity = INTEGER) val departureCode: Int, //foreign key (airport_code)
    @ColumnInfo(name = "arrival_code", typeAffinity = INTEGER) val arrivalCode: Int, //foreign key (airport_code)
    @ColumnInfo(name = "departure_date", typeAffinity = TEXT) val departureDate: String,
    @ColumnInfo(name = "arrival_date", typeAffinity = TEXT) val arrivalDate: String,
    @ColumnInfo(name = "departure_time", typeAffinity = TEXT) val departureTime: String,
    @ColumnInfo(name = "arrival_time", typeAffinity = TEXT) val arrivalTime: String,
    @ColumnInfo(name = "price", typeAffinity = INTEGER) val price: Int
)
