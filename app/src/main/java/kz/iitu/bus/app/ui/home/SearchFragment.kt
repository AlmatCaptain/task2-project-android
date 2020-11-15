package kz.iitu.bus.app.ui.home

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_search.*
import kz.iitu.bus.app.PassengerActivity
import kz.iitu.bus.app.R
import kz.iitu.bus.app.db.AppDatabase
import kz.iitu.bus.app.model.Bus

class SearchFragment : Fragment() {

    private lateinit var homeViewModel: SearchViewModel

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
            ViewModelProviders.of(this).get(SearchViewModel::class.java)

        return inflater.inflate(R.layout.fragment_search, container, false)
    }
}