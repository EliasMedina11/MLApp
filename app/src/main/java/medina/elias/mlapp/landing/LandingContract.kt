package medina.elias.mlapp.landing

import medina.elias.mlapp.utils.BaseContract

interface LandingContract : BaseContract{

    interface View : BaseContract.View {
        fun updateSliderView (path: String)
        fun updateItemsView ()
    }

    interface Presenter : BaseContract.Presenter {
        fun getSliders ()
        fun getItems ()
        fun updateItemView ()
        fun updateSliderView ()
    }
}