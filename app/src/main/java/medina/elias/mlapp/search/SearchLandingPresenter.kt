package medina.elias.mlapp.search

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import medina.elias.mlapp.api.RetroFitHelper
import medina.elias.mlapp.models.Result

class SearchLandingPresenter : SearchLandingContract.Presenter {

    val retroFitHelper by lazy { RetroFitHelper.create() }
    var disposable : Disposable? = null
   lateinit var resultList : List<Result>

    override fun updateItemView() {
    }

    override fun dispose() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


  override  fun doSearch (query : String): List<Result> {
        disposable =
                retroFitHelper.getSearchResult(query)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                { result -> resultList = result.results },
                                { error -> print(error.message)}
                        )

      return resultList
    }

    override fun navToSearch(searchList: List<Result>) {
        this.resultList = searchList

    }
}