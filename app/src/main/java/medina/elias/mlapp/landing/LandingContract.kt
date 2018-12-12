package medina.elias.mlapp.landing

import android.content.Context
import medina.elias.mlapp.adapters.RecentItemsAdapter
import medina.elias.mlapp.models.Result
import medina.elias.mlapp.utils.BaseContract

interface LandingContract : BaseContract{

    interface View : BaseContract.View {
        fun updateRecyclerView(adapter: RecentItemsAdapter)
        fun getContext () : Context
        fun showNoResultsMessage ()
        fun onError ()
    }

    interface Presenter : BaseContract.Presenter {
        fun attachToAdapter(product: List<Result>)
        fun fetchResult(search: String)
    }
}