package com.polodarb.volans.data.repo

import android.util.Log
import com.polodarb.volans.data.local.AviaDao
import com.polodarb.volans.data.local.FlightCard
import com.polodarb.volans.data.local.FlightDetails
import com.polodarb.volans.data.local.entities.Airport
import com.polodarb.volans.data.local.entities.BuyTicket
import com.polodarb.volans.data.local.entities.Flight
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class Repository @Inject constructor(val db: AviaDao) {

    fun getAllTickets(): Flow<List<FlightCard>> = flow {
        val flightDetailsList = withContext(Dispatchers.IO) {
            db.getFlightDetails()
        }
        emit(flightDetailsList)
    }

    fun getTicketByFlightCode(flightCode: Int): Flow<FlightDetails> = flow {
        val getFlight = withContext(Dispatchers.IO) {
            db.getFlightDetailsByFlightCode(flightCode)
        }
        emit(getFlight)
    }

    suspend fun getFlightCard(card: Int) : FlightCard {
        val getFlight = withContext(Dispatchers.IO) {
            db.getFlightCard(card)
        }
        return getFlight
    }

    fun getSities() = flow<List<String>> {
        val getSities = withContext(Dispatchers.IO) {
            db.getSities()
        }
        emit(getSities)
    }

    fun getAirports() = db.getAirports()

    suspend fun getDepartureCodeByCity(city: String): List<Int> {
        return withContext(Dispatchers.IO) {
            db.getDepartureCodeByCity(city)
        }
    }

    suspend fun getArrivalCodeByCity(city: String): List<Int> {
        return withContext(Dispatchers.IO) {
            db.getArrivalCodeByCity(city)
        }
    }

    suspend fun addAirport(airport: Airport) = db.addAirport(airport)

    suspend fun addBuyTicket(buyTicket: BuyTicket) = db.addBuyTickets(buyTicket)

    suspend fun addFlight(flight: Flight) = db.addFlight(flight)

}