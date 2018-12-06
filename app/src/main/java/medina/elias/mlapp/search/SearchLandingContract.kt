package medina.elias.mlapp.search

import medina.elias.mlapp.models.Result
import medina.elias.mlapp.utils.BaseContract

interface SearchLandingContract : BaseContract {

    interface View : BaseContract.View {
        fun getQuery (query: String)
        fun displayItems ()
    }

    interface Presenter : BaseContract.Presenter {
        fun doSearch (query: String) : List<Result>
        fun updateItemView ()
        fun navToSearch (searchList : List<Result>)
    }
}