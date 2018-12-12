package medina.elias.mlapp.details

import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import medina.elias.mlapp.Service.RetroFitHelper
import medina.elias.mlapp.adapters.ItemDetailsAdapter
import medina.elias.mlapp.models.Product

class ItemDetailsPresenter(private val view: ItemDetailsContract.View) : ItemDetailsContract.Presenter {

    private val retroFitHelper by lazy { RetroFitHelper.create() }
    private var disposable: Disposable? = null
    private var adapter: ItemDetailsAdapter? = null

    private val subscribeScheduler = Schedulers.io()
    private val observerScheduler = AndroidSchedulers.mainThread()

    //Metodo que busca los detalles de un producto

    override fun searchDetails(itemId: String) {
        view.showLoading(true)
        disposable =
                retroFitHelper.getProductDetails(itemId)
                        .subscribeOn(subscribeScheduler)
                        .observeOn(observerScheduler)
                        .subscribe({ result -> attachToAdapter(arrayListOf(result)) },
                                { error ->
                                    Log.e("Error with product", error.message)
                                    view.error()
                                    view.showLoading(false)}
                        )
    }

    // Obtenemos una lista con los detalles del producto y la vinculamos a nuestro adapter
    override fun attachToAdapter(product: ArrayList<Product>) {
        view.showLoading(false)
        adapter = (ItemDetailsAdapter(product))
        view.updateRecyclerView(adapter!!)
    }

    // Metodo que busca la descripcion del producto
    override fun searchDescription(itemId: String) {
        view.showLoading(true)
        disposable =
                retroFitHelper.getProductDescription(itemId)
                        .subscribeOn(subscribeScheduler)
                        .observeOn(observerScheduler)
                        .subscribe(
                                { result -> getDescription(result.plain_text) },
                                { error -> Log.e("Error item Description", error.message)
                                    view.error()
                                    view.showLoading(false)
                                }
                        )
    }

    // Obtenemos la descripcion y la enviamos a la vista
    override fun getDescription(itemDescription: String) {
        view.showLoading(false)
        view.updateDescriptionText(itemDescription)
    }

}