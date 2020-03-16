package com.imscreed.offers.model

/*
"offers": [
    {
      "offer_id": "40408",
      "name": "Buy 2: Select TRISCUIT Crackers",
      "image_url": "https://d3bx4ud3idzsqf.cloudfront.net/public/production/6840/67561_1535141624.jpg",
      "cash_back": 1.0
    }
*/
data class Offer (
    val offer_id: String,
    val name: String,
    val image_url: String,
    val cash_back: Double
)

data class OffersResponse (
    val offers: List<Offer>
)