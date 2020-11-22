package kz.iitu.bus.app

import android.content.DialogInterface
import android.content.Intent
import android.os.AsyncTask
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_booking.*
import kotlinx.android.synthetic.main.activity_card.*
import kz.iitu.bus.app.db.AppDatabase
import kz.iitu.bus.app.model.Bus
import kz.iitu.bus.app.model.Order
import java.time.LocalDateTime


class CardActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card)

        val bus = intent.getParcelableExtra<Bus>("buss")
        val passenger = intent.getStringExtra("pass")
        val seat_id = intent.getIntExtra("seat_id", -1)

        pay_but.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Paid!")
                .setMessage("To view the purchase go to the order history.")
                .setPositiveButton("ОК") { dialog, id ->
                    dialog.cancel()
                    val order = Order(
                        busNumber = bus!!.busNumber,
                        direct = bus.direct,
                        passenger = passenger!!,
                        busSeat = seat_id,
                        tariff = bus.price,
                        orderDate = LocalDateTime.now().toString()
                    )

                    AsyncTask.execute {
                        AppDatabase.getInstance(this)?.getOrderDao()?.insertOrder(order)
                    }

                    val intent = Intent(this, OrderActivity::class.java)
                    intent.putExtra("order", order)
                    startActivity(intent)
                }
            builder.create()
            builder.show()
        }
    }
}