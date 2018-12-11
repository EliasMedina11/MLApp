package medina.elias.mlapp.details

import medina.elias.mlapp.adapters.ItemDetailsAdapter
import medina.elias.mlapp.models.Product
import medina.elias.mlapp.utils.BaseContract

/** Contract de nuestro MVP**/

interface ItemDetailsContract : BaseContract {

    interface View: BaseContract.View {
      fun  updateRecyclerView(adapter: ItemDetailsAdapter)
      fun  updateDescriptionText(textDescription: String)
    }

    interface Presenter: BaseContract.Presenter{
      fun searchDetails(itemId : String)
      fun searchDescription (itemId: String)
      fun getDescription (itemDescription: String)
      fun attachToAdapter(product: ArrayList<Product>)
    }
}