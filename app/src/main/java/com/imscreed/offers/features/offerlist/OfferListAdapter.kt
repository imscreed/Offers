package com.imscreed.offers.features.offerlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.imscreed.offers.R
import com.imscreed.offers.model.Offer
import kotlinx.android.synthetic.main.offer_list_row_item.view.*

class OfferListAdapter(
    private val offers: List<Offer>
) : RecyclerView.Adapter<OfferViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfferViewHolder {
        return OfferViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.offer_list_row_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return offers.size
    }

    override fun onBindViewHolder(holder: OfferViewHolder, position: Int) {
        val offer = offers[position]
        holder.bind(offer)
    }
}

class OfferViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var name: TextView = itemView.nameView
    private var cashback: TextView = itemView.cashbackView
    private var photo: ImageView = itemView.imageView

    fun bind(offer: Offer) {
        name.text = offer.name
        cashback.text = offer.cash_back.toString()

        photo.load(offer.image_url) {
            crossfade(true)
//            placeholder(R.drawable.placeholder)
        }
    }
}

