package kz.iitu.bus.app.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.passenger_item.view.*
import kz.iitu.bus.app.R
import kz.iitu.bus.app.model.Passenger

class PassengerAdapter(
    private val listPassengers: List<Passenger> = listOf()
) : RecyclerView.Adapter<PassengerAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        @SuppressLint("SetTextI18n", "ResourceAsColor")
        fun bindItem(passenger: Passenger) {

            if(passenger.name.isEmpty())
                view.pass_name.text = "No name"
            else
                view.pass_name.text = passenger.name

            view.pass_seat_num.text = passenger.seat

            when (passenger.type) {
                "off" -> {
                    view.pass_type.text = "OFFLINE"
                    view.pass_type.setBackgroundColor(R.color.gray_color)
                }
                "on" -> {
                    view.pass_type.text = "ONLINE"
                }
                else -> {
                    view.pass_type.text = "no type"
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder =
        ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.passenger_item, parent, false)
        )

    override fun getItemCount() = listPassengers.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bindItem(listPassengers[position])
    }

}