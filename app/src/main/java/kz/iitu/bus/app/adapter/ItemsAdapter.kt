package kz.iitu.bus.app.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_xml.view.*
import kz.iitu.bus.app.R
import kz.iitu.bus.app.model.Bus
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class ItemsAdapter(
    private val listItems: List<Bus> = listOf(),
    private val clickListener: (Bus) -> Unit
) : RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        @SuppressLint("NewApi", "SetTextI18n")
        fun bindItem(item: Bus, clickListener: (Bus) -> Unit) {
            view.direct.text = item.direct
            view.fromDate.text = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm").format(LocalDateTime.parse(item.fromDate)).toString()
            view.toDate.text = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm").format(LocalDateTime.parse(item.toDate)).toString()
            view.bus_brand.text = item.busBrand
            view.bus_number.text = "Bus number: ${item.busNumber}"
            view.bus_seat.text = "Seats: ${item.busSeat}"

            Picasso.get()
                .load(item.photoUrl)
                .into(view.bus_image)

            view.setOnClickListener { clickListener(item) }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder =
        ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_xml, parent, false)
        )

    override fun getItemCount() = listItems.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bindItem(listItems[position], clickListener)
    }

}