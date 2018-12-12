package medina.elias.mlapp.search

import android.content.Context
import medina.elias.mlapp.adapters.ItemListAdapter
import medina.elias.mlapp.models.Result
import medina.elias.mlapp.utils.BaseContract

interface SearchLandingContract : BaseContract {

    interface View : BaseContract.View {
        fun displayItems(adapter: ItemListAdapter)
        fun getContext () : Context
        fun showNoResultsMessage ()
        fun error()
    }

    interface Presenter : BaseContract.Presenter {
        fun doSearch (query: String)
        fun updateItemRecyclerView(results:List<Result>)
    }

}