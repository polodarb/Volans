package com.polodarb.volans.data.local

import androidx.room.ColumnInfo

data class FlightDetails(
    @ColumnInfo(name = "departure_city") val departureCity: String,
    @ColumnInfo(name = "departure_time") val departureTime: String,
    @ColumnInfo(name = "departure_date") val departureDate: String,
    @ColumnInfo(name = "arrival_city") val arrivalCity: String,
    @ColumnInfo(name = "arrival_country") val arrivalCountry: String,
    @ColumnInfo(name = "arrival_time") val arrivalTime: String,
    @ColumnInfo(name = "arrival_date") val arrivalDate: String,
    @ColumnInfo(name = "flight_code") val flightCode: Int,
    @ColumnInfo(name = "place_number") val placeNumber: Int,
    @ColumnInfo(name = "price") val price: Int
)