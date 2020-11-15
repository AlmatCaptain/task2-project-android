package kz.iitu.bus.app

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.bus_detail.*
import kotlinx.android.synthetic.main.layout_xml.view.*
import kz.iitu.bus.app.model.Bus
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class BusDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "data"
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bus_detail)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        run()
    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.O)
    private fun run() {
        val bus = intent.getParcelableExtra<Bus>(EXTRA_DATA)

        direct.text = bus!!.direct
        fromDate.text = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm").format(LocalDateTime.parse(bus.fromDate)).toString()
        toDate.text = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm").format(LocalDateTime.parse(bus.toDate)).toString()
        bus_brand.text = bus.busBrand
        bus_number.text = "Bus number: ${bus.busNumber}"
        bus_seat.text = "Seats: ${bus.busSeat}"

        Picasso.get()
            .load(bus.photoUrl)
            .into(bus_image)

        bus.seatsMap.forEach { s ->
            if (s.value) {
                val btn =  findViewById<Button>(resources.getIdentifier("seat${s.key}", "id", packageName))
                btn.setBackgroundResource(R.drawable.active_btn)
            }
        }
    }
}