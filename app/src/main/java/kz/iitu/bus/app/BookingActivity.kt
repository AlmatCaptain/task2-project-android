package kz.iitu.bus.app

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_booking.*
import kz.iitu.bus.app.model.Bus

class BookingActivity : AppCompatActivity() {

    companion object {
        const val ID = "data"
        const val BUS = "buss"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        run()
    }

    @SuppressLint("SetTextI18n")
    private fun run() {
        val seat_id = intent.getIntExtra(ID, -1)
        val bus = intent.getParcelableExtra<Bus>(BUS)

        seat_text.text = "Seat: $seat_id"
        tariff_text.text = "Tariff: ${bus!!.price}"

        ticket_text.text = ticket_text.text.toString() + bus.price.toString()
        service_text.text = service_text.text.toString() + 0
        total_text.text = total_text.text.toString() + bus.price.toString()

        next_but.setOnClickListener {
            val intent = Intent(this, CardActivity::class.java)
            intent.putExtra("pass", full_name_input.text.toString())
            intent.putExtra("seat_id", seat_id)
            intent.putExtra("buss", bus)
            startActivity(intent)
        }
    }
}