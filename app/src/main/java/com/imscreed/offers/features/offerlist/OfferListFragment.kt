package com.imscreed.offers.features.offerlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import com.imscreed.offers.R
import com.imscreed.offers.model.Offer
import kotlinx.android.synthetic.main.offer_list_fragment.*


class OfferListFragment : Fragment() {

    companion object {
        fun newInstance() = OfferListFragment()
    }

    private val TAG: String = OfferListFragment.javaClass.simpleName
    private lateinit var offerListViewModel: OfferListViewModel
    private lateinit var offerListAdapter: OfferListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        offerListViewModel = ViewModelProvider(this).get(OfferListViewModel::class.java)
        offerListViewModel.offers.observe(
            viewLifecycleOwner,
            Observer<MutableList<Offer>> { offers ->
                if (offers != null && offers.isNotEmpty()) {
                    emptyListStateView.visibility = View.GONE
                    progressBar.visibility = View.GONE
                    offerListAdapter = OfferListAdapter(offers)
                    offerRecyclerView.adapter = offerListAdapter
                    offerRecyclerView.addItemDecoration(
                        DividerItemDecoration(
                            context,
                            DividerItemDecoration.VERTICAL
                        )
                    )
                } else {
                    emptyListStateView.visibility = View.VISIBLE
                    progressBar.visibility = View.GONE
                }
            }
        )
        return inflater.inflate(R.layout.offer_list_fragment, container, false)
    }
}
