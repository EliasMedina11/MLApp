package medina.elias.mlapp.details

import medina.elias.mlapp.adapters.ItemDetailsAdapter
import medina.elias.mlapp.models.Product
import medina.elias.mlapp.utils.BaseContract

interface ItemDetailsContract : BaseContract {

    interface View: BaseContract.View {
      fun  updateRecyclerView(adapter: ItemDetailsAdapter)
    }

    interface Presenter: BaseContract.Presenter{
      fun searchDetails(itemId : String)
      fun attachToAdapter(product: ArrayList<Product>)
    }
}