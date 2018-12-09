package medina.elias.mlapp.search


import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import medina.elias.mlapp.Service.ConnexionHandler
import medina.elias.mlapp.adapters.ItemListAdapter
import medina.elias.mlapp.Service.RetroFitHelper
import medina.elias.mlapp.models.Result
import medina.elias.mlapp.utils.SearchListener


class SearchLandingPresenter(private var view : SearchLandingContract.View) : SearchLandingContract.Presenter {


    val retroFitHelper by lazy { RetroFitHelper.create() }
    var disposable : Disposable? = null
    var resultList : MutableList<Result> = mutableListOf()
    private lateinit var adapter : ItemListAdapter


    override fun dispose() {
    }

  override fun doSearch (query : String): String{
    /*  Log.e("Comienza busqueda con",query)
        disposable =
                retroFitHelper.getSearchResult(query)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                { result -> resultList.addAll(result.results) },
                                { error -> Log.e("fallo la busqueda",error.message)})
        Log.e("resultado",resultList.toString())
        */
      return ""

  }

    override fun updateItemRecyclerView(query: String) {
        resultList = ConnexionHandler.search(query)
        adapter = ItemListAdapter(resultList,object: SearchListener {
            override fun onClick(itemId: String, position: Int) {
               Log.e("Evento", "Tocaste $itemId")
            }
        })
        view.displayItems(adapter)

    }

    override fun navToSearch(searchList: MutableList<Result>) {
        this.resultList = searchList
    }

}