package medina.elias.mlapp.details

import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import medina.elias.mlapp.Service.RetroFitHelper
import medina.elias.mlapp.adapters.ItemDetailsAdapter
import medina.elias.mlapp.models.Product

class ItemDetailsPresenter(private val view : ItemDetailsContract.View) : ItemDetailsContract.Presenter {

   private val retroFitHelper by lazy { RetroFitHelper.create() }
   private var disposable : Disposable? = null
   private var adapter: ItemDetailsAdapter? = null

    private val subscribeScheduler = Schedulers.io()
    private val observerScheduler = AndroidSchedulers.mainThread()

    override fun searchDetails(itemId: String) {
        disposable =
                retroFitHelper.getProductDetails(itemId)
                        .subscribeOn(subscribeScheduler)
                        .observeOn(observerScheduler)
                        .subscribe( { result -> attachToAdapter(arrayListOf(result))},
                                    { error ->  Log.e("Error with product",error.message)}
                        )
    }

    override fun attachToAdapter(product: ArrayList<Product>) {
        adapter = (ItemDetailsAdapter(product))
        view.updateRecyclerView(adapter!!)
    }

    override fun dispose() {

    }

}