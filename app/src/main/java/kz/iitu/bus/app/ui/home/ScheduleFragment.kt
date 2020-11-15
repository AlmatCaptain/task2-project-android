package kz.iitu.bus.app.ui.home

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_schedule.view.*
import kz.iitu.bus.app.PassengerActivity
import kz.iitu.bus.app.R
import kz.iitu.bus.app.adapter.ItemsAdapter
import kz.iitu.bus.app.adapter.PassengerAdapter
import kz.iitu.bus.app.db.AppDatabase
import kz.iitu.bus.app.model.Bus

class ScheduleFragment : Fragment() {

    private lateinit var homeViewModel: ScheduleViewModel

    private fun itemClicked(bus: Bus) {
        val intent = Intent(activity, PassengerActivity::class.java)
        startActivity(intent)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(ScheduleViewModel::class.java)
        val rootView = inflater.inflate(R.layout.fragment_schedule, container, false)

        AsyncTask.execute {
            val items = AppDatabase.getInstance(requireContext())?.getBusDao()!!.getItems()
            activity?.runOnUiThread {
                rootView.recycler_view.layoutManager = LinearLayoutManager(activity)
                rootView.recycler_view.adapter =
                    ItemsAdapter(items) { bus: Bus -> itemClicked(bus) }
            }
        }


        return rootView
    }
}