package com.polodarb.volans.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.polodarb.volans.data.local.entities.Airport
import com.polodarb.volans.data.local.entities.Flight
import com.polodarb.volans.data.local.entities.Ticket

@Dao
interface AviaDao {

    @Query("SELECT * FROM ticket")
    fun getAllTickets(): List<Ticket>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAirport(airport: Airport)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFlight(flight: Flight)

}