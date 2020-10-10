package kz.iitu.bus.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_item.*
import kz.iitu.bus.app.adapter.PassengerAdapter
import kz.iitu.bus.app.model.Passenger

class PassengerActivity : AppCompatActivity() {

    val passengers = listOf<Passenger>(
        Passenger("Aigerim", "0 A", "off"),
        Passenger("Arlan", "O B", "off"),
        Passenger("Assel", "1", "on"),
        Passenger("Temirlan", "2", "on")
    )

    val freeSeats = listOf<Passenger>(
        Passenger("", "1 B", ""),
        Passenger("", "2 B", ""),
        Passenger("", "3 A", ""),
        Passenger("", "3 B", "")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        run()
    }

    fun run() {
        item_recycler_view.layoutManager = LinearLayoutManager(this)
        free_seat_recycler.layoutManager = LinearLayoutManager(this)
        item_recycler_view.adapter = PassengerAdapter(passengers)
        free_seat_recycler.adapter = PassengerAdapter(freeSeats)
    }
}