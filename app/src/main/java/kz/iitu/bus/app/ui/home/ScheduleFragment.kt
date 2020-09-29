package kz.iitu.bus.app.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_schedule.*
import kotlinx.android.synthetic.main.fragment_schedule.view.*
import kz.iitu.bus.app.R
import kz.iitu.bus.app.adapter.ItemsAdapter
import kz.iitu.bus.app.model.Bus

class ScheduleFragment : Fragment() {

    val items = listOf<Bus>(
        Bus(
            "A123",
            "Almaty-Nursultan",
            "YOKOKO",
            40,
            "https://wallpapershome.ru/images/pages/ico_v/9771.jpg",
            "2020-09-29T09:55:00",
            "2020-09-29T15:55:00"
        ),
        Bus(
            "B777",
            "Shym-Taldyk",
            "Xiaomi",
            100,
            "https://www.robertharding.com/watermark.php?type=preview&im=RM/RH/VERTICAL/83-4487",
            "2020-10-01T09:55:00",
            "2020-10-02T15:55:00"
        ),
        Bus(
            "X13PP",
            "Semey-Karagandy",
            "TOYOTA",
            50,
            "https://thumbs.dreamstime.com/z/american-school-bus-vertical-parked-street-waiting-end-class-front-door-open-dull-weather-back-view-104476388.jpg",
            "2020-10-15T09:55:00",
            "2020-10-16T15:55:00"
        )
    )

    private lateinit var homeViewModel: ScheduleViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(ScheduleViewModel::class.java)
        val rootView = inflater.inflate(R.layout.fragment_schedule, container, false)

        rootView.recycler_view.layoutManager = LinearLayoutManager(activity)
        rootView.recycler_view.adapter = ItemsAdapter(items)
        return rootView
    }
}