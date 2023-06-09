package com.polodarb.volans.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.polodarb.volans.data.local.entities.Airport
import com.polodarb.volans.data.local.entities.BuyTicket
import com.polodarb.volans.data.local.entities.Flight

@Dao
interface AviaDao {

    @Query("SELECT " +
            "a1.airport_city AS departure_city, " +
            "f.departure_time, " +
            "f.departure_date, " +
            "a2.airport_city AS arrival_city, " +
            "a2.airport_country AS arrival_country, " +
            "f.arrival_time, " +
            "f.arrival_date, " +
            "f.flight_code, " +
            "t.place_number, " +
            "f.price " +
            "FROM ticket t " +
            "JOIN flight f ON t.flight_code = f.flight_code " +
            "JOIN airport a1 ON f.departure_code = a1.airport_code " +
            "JOIN airport a2 ON f.arrival_code = a2.airport_code " +
            "WHERE t.flight_code = :flightCode")
    fun getFlightDetailsByFlightCode(flightCode: Int): FlightDetails

    @Query("SELECT " +
            "f.flight_code AS flight_code, " +
            "a1.airport_city AS airport_city1, " +
            "a2.airport_city AS airport_city2, " +
            "a1.airport_name AS airport_name1, " +
            "a2.airport_name AS airport_name2, " +
            "f.departure_time, " +
            "f.arrival_time, " +
            "f.departure_date, " +
            "f.arrival_date " +
            "FROM flight f " +
            "JOIN airport a1 ON f.departure_code = a1.airport_code " +
            "JOIN airport a2 ON f.arrival_code = a2.airport_code")
    fun getFlightDetails(): List<FlightCard>

    @Query("SELECT " +
            "f.flight_code AS flight_code, " +
            "a1.airport_city AS airport_city1, " +
            "a2.airport_city AS airport_city2, " +
            "a1.airport_name AS airport_name1, " +
            "a2.airport_name AS airport_name2, " +
            "f.departure_time, " +
            "f.arrival_time, " +
            "f.departure_date, " +
            "f.arrival_date " +
            "FROM flight f " +
            "JOIN airport a1 ON f.departure_code = a1.airport_code " +
            "JOIN airport a2 ON f.arrival_code = a2.airport_code " +
            "WHERE f.flight_code = :flightCode")
    fun getFlightCard(flightCode: Int): FlightCard

    @Query("SELECT * FROM airport WHERE airport_city = 'Kharviv'")
    fun getAirports(): List<Airport>

    @Query("SELECT DISTINCT airport_city FROM airport")
    fun getSities(): List<String>

    @Query("SELECT departure_code FROM flight WHERE departure_code IN (SELECT airport_code FROM airport WHERE airport_city = :city)")
    fun getDepartureCodeByCity(city: String): List<Int>

    @Query("SELECT arrival_code FROM flight WHERE arrival_code IN (SELECT airport_code FROM airport WHERE airport_city = :city)")
    fun getArrivalCodeByCity(city: String): List<Int>

    @Insert
    suspend fun addBuyTickets(ticket: BuyTicket)

    @Insert
    suspend fun addAirport(airport: Airport)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFlight(flight: Flight)

}