package medina.elias.mlapp.landing

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_landing.view.*

import medina.elias.mlapp.R
import medina.elias.mlapp.adapters.RecentItemsAdapter

class LandingFragment : Fragment(), LandingContract.View {

    private lateinit var recycler: RecyclerView
    private val presenter by lazy { LandingPresenter(this) }
    private val layoutManager by lazy { GridLayoutManager(context,2) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.fetchResult("Bateria")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_landing, container, false)

        recycler = rootView.recycler_item_main as RecyclerView

        return  rootView
    }

    override fun updateRecyclerView(adapter: RecentItemsAdapter) {
        recycler.setHasFixedSize(true)
        recycler.itemAnimator = DefaultItemAnimator()
        recycler.layoutManager = layoutManager

        recycler.adapter = adapter
    }

    override fun getContext(): Context {
       return activity!!.applicationContext
    }

    override fun showNoResultsMessage() {
    }

    override fun showLoading(showLoading: Boolean) {
    }

}
