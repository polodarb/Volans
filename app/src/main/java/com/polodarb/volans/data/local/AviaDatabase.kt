package com.polodarb.volans.data.local

import android.content.ContentValues
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.polodarb.volans.data.local.entities.Airport
import com.polodarb.volans.data.local.entities.Client
import com.polodarb.volans.data.local.entities.Employee
import com.polodarb.volans.data.local.entities.Flight
import com.polodarb.volans.data.local.entities.Place
import com.polodarb.volans.data.local.entities.Ticket

@Database(
    entities = [
        Airport::class,
        Client::class,
        Employee::class,
        Flight::class,
        Place::class,
        Ticket::class
    ],
    version = 5
)
abstract class AviaDatabase : RoomDatabase() {
    abstract fun aviaDao(): AviaDao

    companion object {
        private var instance: AviaDatabase? = null

        @Synchronized
        fun getInstance(ctx: Context): AviaDatabase {
            if(instance == null)
                instance = Room.databaseBuilder(ctx.applicationContext, AviaDatabase::class.java,
                    "avia_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build()

            return instance!!

        }

        private val roomCallback = object : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                val clientData: Array<Array<Any>> = arrayOf(
                    arrayOf("John Smith", "1234567890", "9876543210"),
                    arrayOf("Alice Johnson", "2345678901", "8765432109"),
                    arrayOf("Michael Williams", "3456789012", "7654321098"),
                    arrayOf("Jennifer Brown", "4567890123", "6543210987"),
                    arrayOf("Christopher Davis", "5678901234", "5432109876"),
                    arrayOf("Jessica Miller", "6789012345", "4321098765"),
                    arrayOf("Matthew Wilson", "7890123456", "3210987654"),
                    arrayOf("Emily Taylor", "8901234567", "2109876543"),
                    arrayOf("Daniel Anderson", "9012345678", "1098765432"),
                    arrayOf("Olivia Thomas", "1023456789", "9876543210"),
                    arrayOf("David Martinez", "2134567890", "8765432109"),
                    arrayOf("Sophia Hernandez", "3245678901", "7654321098"),
                    arrayOf("Andrew Smith", "4356789012", "6543210987"),
                    arrayOf("Mia Johnson", "5467890123", "5432109876"),
                    arrayOf("Joseph Williams", "6578901234", "4321098765"),
                    arrayOf("Abigail Brown", "7689012345", "3210987654"),
                    arrayOf("James Davis", "8790123456", "2109876543"),
                    arrayOf("Emma Miller", "9801234567", "1098765432"),
                    arrayOf("Benjamin Wilson", "9012345678", "9876543210"),
                    arrayOf("Ava Taylor", "1123456789", "8765432109"),
                    arrayOf("Alexander Anderson", "2234567890", "7654321098"),
                    arrayOf("Samantha Thomas", "3345678901", "6543210987"),
                    arrayOf("William Martinez", "4456789012", "5432109876"),
                    arrayOf("Isabella Hernandez", "5567890123", "4321098765"),
                    arrayOf("Ethan Smith", "6678901234", "3210987654"),
                    arrayOf("Charlotte Johnson", "7789012345", "2109876543"),
                    arrayOf("Daniel Williams", "8890123456", "1098765432"),
                    arrayOf("Amelia Brown", "9901234567", "9876543210"),
                    arrayOf("Michael Davis", "1012345678", "8765432109"),
                    arrayOf("Liam Miller", "1123456789", "7654321098"),
                    arrayOf("Olivia Wilson", "2234567890", "6543210987"),
                    arrayOf("Emily Taylor", "3345678901", "5432109876"),
                    arrayOf("Noah Anderson", "4456789012", "4321098765"),
                    arrayOf("Emma Hernandez", "5567890123", "3210987654"),
                    arrayOf("Sophia Smith", "6678901234", "2109876543"),
                    arrayOf("Liam Johnson", "7789012345", "1098765432"),
                    arrayOf("Ava Williams", "8890123456", "9876543210"),
                    arrayOf("Jackson Brown", "9901234567", "8765432109"),
                    arrayOf("Isabella Davis", "1012345678", "7654321098"),
                    arrayOf("Lucas Miller", "1123456789", "6543210987"),
                    arrayOf("Mia Wilson", "2234567890", "5432109876"),
                    arrayOf("Aiden Taylor", "3345678901", "4321098765"),
                    arrayOf("Logan Anderson", "4456789012", "3210987654"),
                    arrayOf("Charlotte Hernandez", "5567890123", "2109876543"),
                    arrayOf("Mateo Smith", "6678901234", "1098765432"),
                    arrayOf("Ella Johnson", "7789012345", "9876543210"),
                    arrayOf("Jayden Williams", "8890123456", "8765432109"),
                    arrayOf("Scarlett Brown", "9901234567", "7654321098"),
                    arrayOf("Jack Davis", "1012345678", "6543210987"),
                    arrayOf("Grace Miller", "1123456789", "5432109876")
                )

                val airportData: Array<Array<Any>> = arrayOf(
                    arrayOf(1, "[KHA]", "Ukraine", "Kharkiv"),
                    arrayOf(2, "[IEV]", "Ukraine", "Kiev"),
                    arrayOf(3, "[LON]", "UK", "London"),
                    arrayOf(4, "[NYC]", "US", "NY"),
                    arrayOf(5, "[PAR]", "France", "Paris"),
                    arrayOf(6, "[BER]", "Germany", "Berlin"),
                    arrayOf(7, "[ROM]", "Italy", "Rome"),
                    arrayOf(8, "[AMS]", "Nether", "Amster"),
                    arrayOf(9, "[MAD]", "Spain", "Madrid"),
                    arrayOf(10, "[SYD]", "Australia", "Sydney"),
                    arrayOf(11, "[TYO]", "Japan", "Tokyo"),
                    arrayOf(12, "[IST]", "Turkey", "Istanbul"),
                    arrayOf(13, "[CAI]", "Egypt", "Cairo"),
                    arrayOf(14, "[ATH]", "Greece", "Athens"),
                    arrayOf(15, "[DEL]", "India", "Delhi"),
                    arrayOf(16, "[BEY]", "Lebanon", "Beirut"),
                    arrayOf(17, "[MEX]", "Mexico", "Mexico"),
                    arrayOf(18, "[TOR]", "Canada", "Toronto"),
                    arrayOf(19, "[BUE]", "Argentina", "Aires"),
                    arrayOf(20, "[SAO]", "Brazil", "Sao Paulo"),
                    arrayOf(21, "[CPT]", "South Africa", "CT"),
                    arrayOf(22, "[NBO]", "Kenya", "Nairobi"),
                    arrayOf(23, "[JKT]", "Indonesia", "Jakarta"),
                    arrayOf(24, "[BKK]", "Thailand", "Bangkok"),
                    arrayOf(25, "[SGP]", "Singapore", "Singapore"),
                    arrayOf(26, "[DXB]", "Arab", "Dubai"),
                    arrayOf(27, "[IST]", "Turkey", "Istanbul"),
                    arrayOf(28, "[ZRH]", "Switzer", "Zurich"),
                    arrayOf(29, "[VIE]", "Austria", "Vienna"),
                    arrayOf(30, "[CPH]", "Denmark", "Copenh"),
                    arrayOf(31, "[BER]", "Germany", "Berlin"),
                    arrayOf(32, "[AMS]", "Nether", "Amster"),
                    arrayOf(33, "[MAD]", "Spain", "Madrid"),
                    arrayOf(34, "[SYD]", "Australia", "Sydney"),
                    arrayOf(35, "[TYO]", "Japan", "Tokyo"),
                    arrayOf(36, "[IST]", "Turkey", "Istanbul"),
                    arrayOf(37, "[CAI]", "Egypt", "Cairo"),
                    arrayOf(38, "[ATH]", "Greece", "Athens"),
                    arrayOf(39, "[DEL]", "India", "Delhi"),
                    arrayOf(40, "[BEY]", "Lebanon", "Beirut"),
                    arrayOf(41, "[MEX]", "Mexico", "Mexico"),
                    arrayOf(42, "[TOR]", "Canada", "Toronto"),
                    arrayOf(43, "[BUE]", "Argentina", "Aires"),
                    arrayOf(44, "[SAO]", "Brazil", "Sao Paulo"),
                    arrayOf(45, "[CPT]", "Africa", "CT"),
                    arrayOf(46, "[NBO]", "Kenya", "Nairobi"),
                    arrayOf(47, "[JKT]", "Indonesia", "Jakarta"),
                    arrayOf(48, "[BKK]", "Thailand", "Bangkok"),
                    arrayOf(49, "[SGP]", "Singapore", "Singapore"),
                    arrayOf(50, "[DXB]", "Arab", "Dubai"),
                    arrayOf(51, "[ZRH]", "Switzer", "Zurich"),
                    arrayOf(52, "[VIE]", "Austria", "Vienna"),
                    arrayOf(53, "[CPH]", "Denmark", "Copenh"),
                    arrayOf(54, "[OSL]", "Norway", "Oslo"),
                    arrayOf(55, "[STO]", "Sweden", "Stockholm"),
                    arrayOf(56, "[HEL]", "Finland", "Helsinki"),
                    arrayOf(57, "[PAR]", "France", "Paris"),
                    arrayOf(58, "[ROM]", "Italy", "Rome"),
                    arrayOf(59, "[LIS]", "Portugal", "Lisbon"),
                    arrayOf(60, "[DUB]", "Ireland", "Dublin")
                )

                val employeeData: Array<Array<Any>> = arrayOf(
                    arrayOf("John Smith", "Manager"),
                    arrayOf("Alice Johnson", "Assistant Manager"),
                    arrayOf("Michael Williams", "Pilot"),
                    arrayOf("Jennifer Brown", "Pilot"),
                    arrayOf("Christopher Davis", "Accountant"),
                    arrayOf("Jessica Miller", "Marketing Specialist"),
                    arrayOf("Matthew Wilson", "IT Administrator"),
                    arrayOf("Emily Taylor", "Customer Service Representative"),
                    arrayOf("Daniel Anderson", "Operations Manager"),
                    arrayOf("Olivia Thomas", "Finance Analyst"),
                    arrayOf("David Martinez", "Project Coordinator"),
                    arrayOf("Sophia Hernandez", "Administrative Assistant")
                )

                val flightData = arrayOf(
                    arrayOf(1, 2, "2023-06-10", "2023-06-11", "09:00", "12:00", 100),
                    arrayOf(2, 3, "2023-06-11", "2023-06-12", "10:30", "13:30", 120),
                    arrayOf(3, 4, "2023-06-12", "2023-06-13", "14:15", "17:15", 150),
                    arrayOf(4, 5, "2023-06-13", "2023-06-14", "16:45", "19:45", 130),
                    arrayOf(5, 6, "2023-06-14", "2023-06-15", "08:00", "11:00", 110),
                    arrayOf(6, 7, "2023-06-15", "2023-06-16", "11:30", "14:30", 135),
                    arrayOf(7, 8, "2023-06-16", "2023-06-17", "15:45", "18:45", 145),
                    arrayOf(8, 9, "2023-06-17", "2023-06-18", "17:30", "20:30", 125),
                    arrayOf(9, 10, "2023-06-18", "2023-06-19", "09:15", "12:15", 115),
                    arrayOf(10, 11, "2023-06-19", "2023-06-20", "12:45", "15:45", 155),
                    arrayOf(11, 12, "2023-06-20", "2023-06-21", "14:30", "17:30", 145),
                    arrayOf(12, 13, "2023-06-21", "2023-06-22", "18:00", "21:00", 135),
                    arrayOf(13, 14, "2023-06-22", "2023-06-23", "08:45", "11:45", 125),
                    arrayOf(14, 15, "2023-06-23", "2023-06-24", "11:15", "14:15", 165),
                    arrayOf(15, 16, "2023-06-24", "2023-06-25", "16:30", "19:30", 155),
                    arrayOf(16, 17, "2023-06-25", "2023-06-26", "17:45", "20:45", 145),
                    arrayOf(17, 18, "2023-06-26", "2023-06-27", "10:00", "13:00", 135),
                    arrayOf(18, 19, "2023-06-27", "2023-06-28", "12:30", "15:30", 175),
                    arrayOf(19, 20, "2023-06-28", "2023-06-29", "15:00", "18:00", 165),
                    arrayOf(20, 21, "2023-06-29", "2023-06-30", "08:30", "11:30", 155),
                    arrayOf(21, 22, "2023-06-30", "2023-07-01", "11:45", "14:45", 195),
                    arrayOf(22, 23, "2023-07-01", "2023-07-02", "14:15", "17:15", 185),
                    arrayOf(23, 24, "2023-07-02", "2023-07-03", "17:30", "20:30", 175),
                    arrayOf(24, 25, "2023-07-03", "2023-07-04", "10:15", "13:15", 165),
                    arrayOf(25, 26, "2023-07-04", "2023-07-05", "13:45", "16:45", 205),
                    arrayOf(26, 27, "2023-07-05", "2023-07-06", "16:30", "19:30", 195),
                    arrayOf(27, 28, "2023-07-06", "2023-07-07", "09:00", "12:00", 185),
                    arrayOf(28, 29, "2023-07-07", "2023-07-08", "11:30", "14:30", 175),
                    arrayOf(29, 30, "2023-07-08", "2023-07-09", "14:00", "17:00", 215),
                    arrayOf(30, 31, "2023-07-09", "2023-07-10", "17:15", "20:15", 205),
                    arrayOf(31, 32, "2023-07-10", "2023-07-11", "10:30", "13:30", 195),
                    arrayOf(32, 33, "2023-07-11", "2023-07-12", "13:00", "16:00", 235),
                    arrayOf(33, 34, "2023-07-12", "2023-07-13", "16:45", "19:45", 225),
                    arrayOf(34, 35, "2023-07-13", "2023-07-14", "09:15", "12:15", 215),
                    arrayOf(35, 36, "2023-07-14", "2023-07-15", "11:45", "14:45", 205),
                    arrayOf(36, 37, "2023-07-15", "2023-07-16", "14:30", "17:30", 245),
                    arrayOf(37, 38, "2023-07-16", "2023-07-17", "17:00", "20:00", 235),
                    arrayOf(38, 39, "2023-07-17", "2023-07-18", "09:45", "12:45", 224),
                    arrayOf(39, 40, "2023-07-18", "2023-07-19", "12:15", "15:15", 264),
                    arrayOf(40, 41, "2023-07-19", "2023-07-20", "15:45", "18:45", 254),
                    arrayOf(41, 42, "2023-07-20", "2023-07-21", "08:30", "11:30", 244),
                    arrayOf(42, 43, "2023-07-21", "2023-07-22", "11:00", "14:00", 283),
                    arrayOf(43, 44, "2023-07-22", "2023-07-23", "14:15", "17:15", 273),
                    arrayOf(44, 45, "2023-07-23", "2023-07-24", "18:30", "21:30", 263),
                    arrayOf(45, 46, "2023-07-24", "2023-07-25", "09:45", "12:45", 253),
                    arrayOf(46, 47, "2023-07-25", "2023-07-26", "12:30", "15:30", 292),
                    arrayOf(47, 48, "2023-07-26", "2023-07-27", "15:00", "18:00", 282),
                    arrayOf(48, 49, "2023-07-27", "2023-07-28", "08:15", "11:15", 272),
                    arrayOf(49, 50, "2023-07-28", "2023-07-29", "10:45", "13:45", 311)
                )

                val placeData = arrayOf(
                    arrayOf(1, "Business"),
                    arrayOf(2, "Business"),
                    arrayOf(3, "Economy"),
                    arrayOf(4, "Economy"),
                    arrayOf(5, "Economy"),
                    arrayOf(6, "Economy"),
                    arrayOf(7, "Economy"),
                    arrayOf(8, "Economy"),
                    arrayOf(9, "Economy"),
                    arrayOf(10, "Economy"),
                    arrayOf(11, "Business"),
                    arrayOf(12, "Economy"),
                    arrayOf(13, "Economy"),
                    arrayOf(14, "Economy"),
                    arrayOf(15, "Business"),
                    arrayOf(16, "Economy"),
                    arrayOf(17, "Economy"),
                    arrayOf(18, "Economy"),
                    arrayOf(19, "Economy"),
                    arrayOf(20, "Economy"),
                    arrayOf(21, "Business"),
                    arrayOf(22, "Economy"),
                    arrayOf(23, "Economy"),
                    arrayOf(24, "Economy"),
                    arrayOf(25, "Business"),
                    arrayOf(26, "Economy"),
                    arrayOf(27, "Economy"),
                    arrayOf(28, "Economy"),
                    arrayOf(29, "Economy"),
                    arrayOf(30, "Economy"),
                    arrayOf(31, "Business"),
                    arrayOf(32, "Economy"),
                    arrayOf(33, "Economy"),
                    arrayOf(34, "Economy"),
                    arrayOf(35, "Business"),
                    arrayOf(36, "Economy"),
                    arrayOf(37, "Economy"),
                    arrayOf(38, "Economy"),
                    arrayOf(39, "Economy"),
                    arrayOf(40, "Economy"),
                    arrayOf(41, "Business"),
                    arrayOf(42, "Economy"),
                    arrayOf(43, "Economy"),
                    arrayOf(44, "Economy"),
                    arrayOf(45, "Economy"),
                    arrayOf(46, "Economy"),
                    arrayOf(47, "Economy"),
                    arrayOf(48, "Business"),
                    arrayOf(49, "Economy"),
                    arrayOf(50, "Economy")
                )

                val ticketData = arrayOf(
                    arrayOf(1, 1, "2023-06-15", 1, 1),
                    arrayOf(2, 2, "2023-06-16", 2, 0),
                    arrayOf(3, 3, "2023-06-17", 3, 1),
                    arrayOf(4, 4, "2023-06-18", 4, 0),
                    arrayOf(5, 5, "2023-06-19", 5, 1),
                    arrayOf(6, 6, "2023-06-20", 6, 0),
                    arrayOf(7, 7, "2023-06-21", 7, 1),
                    arrayOf(8, 8, "2023-06-22", 8, 0),
                    arrayOf(9, 9, "2023-06-23", 9, 1),
                    arrayOf(10, 10, "2023-06-24", 10, 0),
                    arrayOf(11, 11, "2023-06-25", 11, 1),
                    arrayOf(12, 12, "2023-06-26", 12, 0),
                    arrayOf(13, 13, "2023-06-27", 13, 1),
                    arrayOf(14, 14, "2023-06-28", 14, 0),
                    arrayOf(15, 15, "2023-06-29", 15, 1),
                    arrayOf(16, 16, "2023-06-30", 16, 0),
                    arrayOf(17, 17, "2023-07-01", 17, 1),
                    arrayOf(18, 18, "2023-07-02", 18, 0),
                    arrayOf(19, 19, "2023-07-03", 19, 1),
                    arrayOf(20, 20, "2023-07-04", 20, 0),
                    arrayOf(21, 21, "2023-07-05", 21, 1),
                    arrayOf(22, 22, "2023-07-06", 22, 0),
                    arrayOf(23, 23, "2023-07-07", 23, 1),
                    arrayOf(24, 24, "2023-07-08", 24, 0),
                    arrayOf(25, 25, "2023-07-09", 25, 1),
                    arrayOf(26, 26, "2023-07-10", 26, 0),
                    arrayOf(27, 27, "2023-07-11", 27, 1),
                    arrayOf(28, 28, "2023-07-12", 28, 0),
                    arrayOf(29, 29, "2023-07-13", 29, 1),
                    arrayOf(30, 30, "2023-07-14", 30, 0),
                    arrayOf(31, 31, "2023-07-15", 31, 1),
                    arrayOf(32, 32, "2023-07-16", 32, 0),
                    arrayOf(33, 33, "2023-07-17", 33, 1),
                    arrayOf(34, 34, "2023-07-18", 34, 0),
                    arrayOf(35, 35, "2023-07-19", 35, 1),
                    arrayOf(36, 36, "2023-07-20", 36, 0),
                    arrayOf(37, 37, "2023-07-21", 37, 1),
                    arrayOf(38, 38, "2023-07-22", 38, 0),
                    arrayOf(39, 39, "2023-07-23", 39, 1),
                    arrayOf(40, 40, "2023-07-24", 40, 0),
                    arrayOf(41, 41, "2023-07-25", 41, 1),
                    arrayOf(42, 42, "2023-07-26", 42, 0),
                    arrayOf(43, 43, "2023-07-27", 43, 1),
                    arrayOf(44, 44, "2023-07-28", 44, 0),
                    arrayOf(45, 45, "2023-07-29", 45, 1),
                    arrayOf(46, 46, "2023-07-30", 46, 0),
                    arrayOf(47, 47, "2023-07-31", 47, 1),
                    arrayOf(48, 48, "2023-08-01", 48, 0),
                    arrayOf(49, 49, "2023-08-02", 49, 1)
                )

                val ticketCV = ContentValues()
                for (data in ticketData) {
                    ticketCV.put("flight_code", data[0] as Int)
                    ticketCV.put("client_code", data[1] as Int)
                    ticketCV.put("ticket_buy_date", data[2] as String)
                    ticketCV.put("place_number", data[3] as Int)
                    ticketCV.put("ticket_insurance", data[4] as Int)
                    db.insert("ticket", 1, ticketCV)
                    ticketCV.clear()
                }

                val placeCV = ContentValues()
                for (data in placeData) {
                    placeCV.put("place_code", data[0] as Int)
                    placeCV.put("place_status", data[1] as String)
                    db.insert("place", 1, placeCV)
                    placeCV.clear()
                }

                val flightCV = ContentValues()
                for (data in flightData) {
                    flightCV.put("departure_code", data[0] as Int)
                    flightCV.put("arrival_code", data[1] as Int)
                    flightCV.put("departure_date", data[2] as String)
                    flightCV.put("arrival_date", data[3] as String)
                    flightCV.put("departure_time", data[4] as String)
                    flightCV.put("arrival_time", data[5] as String)
                    flightCV.put("price", data[6] as Int)
                    db.insert("flight", 1, flightCV)
                    flightCV.clear()
                }

                val employeeCV = ContentValues()
                for (data in employeeData) {
                    employeeCV.put("employee_pib", data[0] as String)
                    employeeCV.put("employee_position", data[1] as String)
                    db.insert("employee", 1, employeeCV)
                    employeeCV.clear()
                }

                val airportCV = ContentValues()
                for (data in airportData) {
                    airportCV.put("airport_code", data[0] as Int)
                    airportCV.put("airport_name", data[1] as String)
                    airportCV.put("airport_country", data[2] as String)
                    airportCV.put("airport_city", data[3] as String)
                    db.insert("airport", 1, airportCV)
                    airportCV.clear()
                }

                val clientCV = ContentValues()
                for (data in clientData) {
                    clientCV.put("client_pib", data[0] as String)
                    clientCV.put("client_passport", data[1] as String)
                    clientCV.put("client_phone", data[2] as String)
                    db.insert("client", 1, clientCV)
                    clientCV.clear()
                }
            }
        }
    }
}