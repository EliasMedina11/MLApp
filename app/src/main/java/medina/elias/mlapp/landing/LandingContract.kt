package medina.elias.mlapp.landing

import medina.elias.mlapp.utils.BaseContract

interface LandingContract : BaseContract{

    interface View : BaseContract.View {
        fun displaySliderView (path: String)
        fun displayItems ()
    }

    interface Presenter : BaseContract.Presenter {
        fun getSliders ()
        fun getItems ()
        fun updateItemView ()
        fun updateSliderView ()
        fun navToSearch ()
    }
}