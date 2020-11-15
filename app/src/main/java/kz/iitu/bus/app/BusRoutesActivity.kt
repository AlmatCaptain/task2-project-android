package kz.iitu.bus.app

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.bus_routes.*
import kz.iitu.bus.app.adapter.ItemsAdapter
import kz.iitu.bus.app.db.AppDatabase
import kz.iitu.bus.app.model.Bus

class BusRoutesActivity: AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bus_routes)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        run()
    }

    override fun onResume() {
        super.onResume()
        run()
    }

    private fun itemClicked(b: Bus) {
        val intent = Intent(this, BusDetailActivity::class.java)
        intent.putExtra(BusDetailActivity.EXTRA_DATA, b)
        startActivity(intent)
    }

    private fun run() {
        val direction = intent.getStringExtra(EXTRA_DATA)

        AsyncTask.execute {
            val items = AppDatabase.getInstance(this)?.getBusDao()!!.getItems(direction)

            runOnUiThread {
                println(items)
                routes_recycler_view.layoutManager = LinearLayoutManager(this)
                routes_recycler_view.adapter =
                    ItemsAdapter(items) { bus: Bus -> itemClicked(bus) }
            }
        }
    }
}