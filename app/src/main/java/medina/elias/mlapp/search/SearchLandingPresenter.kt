package medina.elias.mlapp.search

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import medina.elias.mlapp.Service.RetroFitHelper
import medina.elias.mlapp.adapters.ItemListAdapter
import medina.elias.mlapp.models.Result

class SearchLandingPresenter : SearchLandingContract.Presenter {

    val retroFitHelper by lazy { RetroFitHelper.create() }
    var disposable : Disposable? = null
    var adapter: ItemListAdapter? = null

    private val subscribeScheduler = Schedulers.io()
    private val observerScheduler = AndroidSchedulers.mainThread()

    override fun updateItemView() {
    }

    override fun dispose() {
    }


  override  fun doSearch (query : String) {
        disposable =
                retroFitHelper.getSearchResult(query)
                        .subscribeOn(subscribeScheduler)
                        .observeOn(observerScheduler)
                        .subscribe(
                                { result -> navToSearch(result.results)},
                                { error -> print(error.message)}
                        )
    }

    override fun navToSearch(searchList: List<Result>) {

    }


}