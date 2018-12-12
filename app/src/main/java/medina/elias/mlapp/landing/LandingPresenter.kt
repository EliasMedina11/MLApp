package medina.elias.mlapp.landing

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import medina.elias.mlapp.service.RetroFitHelper
import medina.elias.mlapp.adapters.RecentItemsAdapter
import medina.elias.mlapp.details.ItemDetailsActivity
import medina.elias.mlapp.models.Result
import medina.elias.mlapp.utils.SearchListener

class LandingPresenter(private val view: LandingContract.View): LandingContract.Presenter {

    private val retroFitHelper by lazy { RetroFitHelper.create() }
    private var disposable : Disposable? = null
    var adapter: RecentItemsAdapter? = null
    var context: Context = view.getContext()

    private val subscribeScheduler = Schedulers.io()
    private val observerScheduler = AndroidSchedulers.mainThread()

    // Obtenemos una lista de Results a partir de una query que nos provee nuestra View
    override fun fetchResult(search: String) {
        Log.e("Comienza busqueda de:",search)
        view.showLoading(true)

        disposable =
                retroFitHelper.getSearchResult(search)
                        .subscribeOn(subscribeScheduler)
                        .observeOn(observerScheduler)
                        .subscribe( { result -> attachToAdapter(result.results)},
                                    { error ->  Log.e("Error with product",error.message)
                                    view.onError()}
                        )
    }

    /** Obtenemos esta nueva lista de Result y la vinculamos a nuestro adapter. Tambien se setea el comportamiento
     * de onClick sobre los elementos, se obtiene el itemId y se navega a ItemDetailsActivity
     */
    override fun attachToAdapter(product: List<Result>) {
        view.showLoading(false)
        if (product.isNotEmpty()){
            adapter = RecentItemsAdapter(product.toMutableList(),object: SearchListener {
                override fun onClick(itemId: String, position: Int) {
                    val intent = Intent(context, ItemDetailsActivity::class.java)
                    intent.putExtra("itemId", itemId)
                    startActivity(context,intent,null)
                }
            })
            view.updateRecyclerView(adapter!!)
        } else {
            view.showNoResultsMessage()
        }
    }
}

