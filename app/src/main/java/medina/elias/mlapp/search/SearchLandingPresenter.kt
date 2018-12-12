package medina.elias.mlapp.search


import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import medina.elias.mlapp.service.RetroFitHelper
import medina.elias.mlapp.adapters.ItemListAdapter
import medina.elias.mlapp.details.ItemDetailsActivity
import medina.elias.mlapp.models.Result
import medina.elias.mlapp.utils.SearchListener


class SearchLandingPresenter(private var view: SearchLandingContract.View) : SearchLandingContract.Presenter {

    private val retroFitHelper by lazy { RetroFitHelper.create() }
    private var disposable: Disposable? = null
    var adapter: ItemListAdapter? = null
    var context: Context = view.getContext()
    var emptyResults: Boolean = false

    private val subscribeScheduler = Schedulers.io()
    private val observerScheduler = AndroidSchedulers.mainThread()

    // Obtenemos una lista de Results a partir de una query que nos provee nuestra View
    override fun doSearch(query: String) {
        Log.e("Comienza busqueda de:", query)
        view.showLoading(true)

        disposable =
                retroFitHelper.getSearchResult(query)
                        .subscribeOn(subscribeScheduler)
                        .observeOn(observerScheduler)
                        .subscribe({ result -> updateItemRecyclerView(result.results)},
                                     { error -> Log.e("Error with product", error.message)
                                         view.showLoading(false)
                                         view.error()}
                        )
    }
    /** Obtenemos esta nueva lista de Result y la vinculamos a nuestro adapter, a su vez se setea el comportamiento
     * de onClick sobre los elementos, se obtiene el itemId y se navega a ItemDetailsActivity
     */
    override fun updateItemRecyclerView(results: List<Result>) {
        if (results.isNotEmpty()) {
            view.showLoading(false)
            adapter = ItemListAdapter(results.toMutableList(), object : SearchListener {
                override fun onClick(itemId: String, position: Int) {
                    val intent = Intent(context, ItemDetailsActivity::class.java)
                    intent.putExtra("itemId", itemId)
                    startActivity(context, intent, null)
                }
            })
            view.displayItems(adapter!!)
        } else {
            emptyResults = true
            view.showNoResultsMessage()
        }

    }

}