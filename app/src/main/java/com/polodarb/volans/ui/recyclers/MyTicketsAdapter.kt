package com.polodarb.volans.ui.recyclers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.polodarb.volans.R
import com.polodarb.volans.data.local.FlightCard
import com.polodarb.volans.databinding.RvHomeCardBinding
import com.polodarb.volans.databinding.RvHomeCardBuyBinding


class MyTicketsAdapter(
    private val list: List<FlightCard>,
    private val mItemClickListener: ItemClickListener
): RecyclerView.Adapter<MyTicketsAdapter.HomeFlightCardViewHolder>(), View.OnClickListener {

    class HomeFlightCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val card: CardView = itemView.findViewById<CardView>(R.id.flightCard)
        val textDeparture = itemView.findViewById<TextView>(R.id.town_departure)
        val textLanding = itemView.findViewById<TextView>(R.id.town_landing)
        val textCodeDeparture = itemView.findViewById<TextView>(R.id.code_airport_departure)
        val textCodeLanding = itemView.findViewById<TextView>(R.id.code_airport_landing)
        val textDateDeparture = itemView.findViewById<TextView>(R.id.tv_date_departure)
        val textDateLanding = itemView.findViewById<TextView>(R.id.tv_date_landing)
        val textTimeDeparture = itemView.findViewById<TextView>(R.id.tv_time_departure)
        val textTimeLanding = itemView.findViewById<TextView>(R.id.tv_time_landing)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeFlightCardViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = RvHomeCardBuyBinding.inflate(inflater, parent, false)

        view.root.setOnClickListener(this)

        return HomeFlightCardViewHolder(view.root)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: HomeFlightCardViewHolder, position: Int) {
        val item = list[position]
        with (holder) {
            holder.textDeparture.text = item.airport_city1
            holder.textCodeDeparture.text = item.airport_name1
            holder.textLanding.text = item.airport_city2
            holder.textCodeLanding.text = item.airport_name2
            holder.textTimeDeparture.text = item.departure_time
            holder.textTimeLanding.text = item.arrival_time
            holder.textDateDeparture.text = item.departure_date
            holder.textDateLanding.text = item.arrival_date
            itemView.tag = position
        }
    }

    override fun onClick(v: View?) {
        val item = v?.tag as Int
        mItemClickListener.itemOnClick(item)
    }
}