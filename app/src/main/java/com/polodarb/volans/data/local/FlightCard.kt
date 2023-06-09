package com.polodarb.volans.data.local

data class FlightCard(
    val flight_code: Int,
    val airport_city1: String,
    val airport_city2: String,
    val airport_name1: String,
    val airport_name2: String,
    val departure_time: String,
    val arrival_time: String,
    val departure_date: String,
    val arrival_date: String
)