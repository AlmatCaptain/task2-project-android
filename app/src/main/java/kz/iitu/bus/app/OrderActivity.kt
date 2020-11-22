package kz.iitu.bus.app

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_order.*
import kz.iitu.bus.app.model.Bus
import kz.iitu.bus.app.model.Order
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class OrderActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        run()
    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.O)
    private fun run() {
        val order = intent.getParcelableExtra<Order>("order")

        direct.text = order!!.direct
        seat_text.text = "Seat: " + order.busSeat.toString()
        date_text.text = "Date: " +
                DateTimeFormatter.ofPattern("dd.MM.yyyy")
                    .format(LocalDateTime.parse(order.orderDate))
                    .toString()
        time_text.text = "Time: " +
                DateTimeFormatter.ofPattern("HH:mm").format(LocalDateTime.parse(order.orderDate))
                    .toString()
        sum_text.text = "Sum: " + order.tariff.toString()
        tariff_text.text = "Tariff: " + order.tariff.toString()
        pass_text.text = "Passenger: " + order.passenger
    }
}