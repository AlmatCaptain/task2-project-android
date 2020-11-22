package kz.iitu.bus.app

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.bus_detail.*
import kz.iitu.bus.app.model.Bus
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class BusDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "data"
    }

    var seat = -1

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bus_detail)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        run()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onResume() {
        super.onResume()
        run()
    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.O)
    private fun run() {
        val bus = intent.getParcelableExtra<Bus>(EXTRA_DATA)

        direct.text = bus!!.direct
        fromDate.text = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")
            .format(LocalDateTime.parse(bus.fromDate)).toString()
        toDate.text =
            DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm").format(LocalDateTime.parse(bus.toDate))
                .toString()
        bus_brand.text = bus.busBrand
        bus_number.text = "Bus number: ${bus.busNumber}"
        bus_seat.text = "Seats: ${bus.busSeat}"

        Picasso.get()
            .load(bus.photoUrl)
            .into(bus_image)

        bus.seatsMap.forEach { s ->
            if (s.value) {
                val btn =
                    findViewById<Button>(resources.getIdentifier("seat${s.key}", "id", packageName))
                btn.setBackgroundResource(R.drawable.active_btn)
            }
        }

        booking_but.setOnClickListener {
            val intent = Intent(this, BookingActivity::class.java)
            intent.putExtra(BookingActivity.ID, seat)
            intent.putExtra(BookingActivity.BUS, bus)
            startActivity(intent)
        }

        seat1.setOnClickListener { seat = 1 }
        seat2.setOnClickListener { seat = 2 }
        seat3.setOnClickListener { seat = 3 }
        seat4.setOnClickListener { seat = 4 }
        seat5.setOnClickListener { seat = 5 }
        seat6.setOnClickListener { seat = 6 }
        seat7.setOnClickListener { seat = 7 }
        seat8.setOnClickListener { seat = 8 }
        seat9.setOnClickListener { seat = 9 }
        seat10.setOnClickListener { seat = 10 }
        seat11.setOnClickListener { seat = 11 }
        seat12.setOnClickListener { seat = 12 }
        seat13.setOnClickListener { seat = 13 }
        seat14.setOnClickListener { seat = 14 }
        seat15.setOnClickListener { seat = 15 }
        seat16.setOnClickListener { seat = 16 }
        seat17.setOnClickListener { seat = 17 }
        seat18.setOnClickListener { seat = 18 }
        seat19.setOnClickListener { seat = 19 }
        seat20.setOnClickListener { seat = 20 }
        seat21.setOnClickListener { seat = 21 }
        seat22.setOnClickListener { seat = 22 }
        seat23.setOnClickListener { seat = 23 }
        seat24.setOnClickListener { seat = 24 }
        seat25.setOnClickListener { seat = 25 }
        seat26.setOnClickListener { seat = 26 }
        seat27.setOnClickListener { seat = 27 }
        seat28.setOnClickListener { seat = 28 }
        seat29.setOnClickListener { seat = 29 }
    }
}