package kz.iitu.bus.app.ui.home

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.android.synthetic.main.fragment_search.view.*
import kz.iitu.bus.app.BusDetailActivity
import kz.iitu.bus.app.BusRoutesActivity
import kz.iitu.bus.app.PassengerActivity
import kz.iitu.bus.app.R
import kz.iitu.bus.app.db.AppDatabase
import kz.iitu.bus.app.model.Bus

class SearchFragment : Fragment() {

    private val items = listOf<Bus>(
        Bus(
            busNumber = "A123",
            direct = "Almaty-Nur-Sultan",
            busBrand = "Xiaomi",
            busSeat = 29,
            photoUrl = "https://www.sustainable-bus.com/wp-content/uploads/2019/12/scania-bus4.jpg",
            fromDate = "2020-11-20T09:55:00",
            toDate = "2020-11-21T15:55:00",
            seatsMap = mapOf(1 to true, 5 to true, 20 to true, 21 to true)
        ),
        Bus(
            busNumber = "B777",
            direct = "Shym-Taldyk",
            busBrand = "Xiaomi",
            busSeat = 29,
            photoUrl = "https://parking.duke.edu/sites/default/files/styles/large/public/GoDurham%20Bus1.jpg?itok=QDCNqowL",
            fromDate = "2020-12-01T09:55:00",
            toDate = "2020-12-02T15:55:00",
            seatsMap = mapOf(2 to true, 3 to true, 10 to true, 15 to true)
        ),
        Bus(
            busNumber = "X13PP",
            direct = "Semey-Karagandy",
            busBrand = "TOYOTA",
            busSeat = 29,
            photoUrl = "https://upload.wikimedia.org/wikipedia/commons/5/5b/TOYOTA_FCHV_Bus.jpg",
            fromDate = "2020-11-15T09:55:00",
            toDate = "2020-11-16T15:55:00",
            seatsMap = mapOf(5 to true, 8 to true, 9 to true, 19 to true)
        )
    )

    private lateinit var homeViewModel: SearchViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(SearchViewModel::class.java)

        val view = inflater.inflate(R.layout.fragment_search, container, false)
        view.refresh_but.setOnClickListener { insertDB() }
        view.search_button.setOnClickListener {
            val intent = Intent(activity, BusRoutesActivity::class.java)
            intent.putExtra(BusRoutesActivity.EXTRA_DATA, "${from_edit_text.text}-${to_edit_text.text}")
            startActivity(intent)
        }
        return view
    }

    private fun insertDB() {
        AsyncTask.execute {
            items.forEach { bus ->
                AppDatabase.getInstance(requireContext())?.getBusDao()?.insertBus(bus)
            }
        }
    }
}