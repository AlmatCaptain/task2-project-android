package kz.iitu.bus.app.model

import java.time.Instant


class Bus(
    val busNumber: String,
    val direct: String,
    val busBrand: String,
    val busSeat: Int,
    val photoUrl: String,
    val fromDate: String,
    var toDate: String
)



