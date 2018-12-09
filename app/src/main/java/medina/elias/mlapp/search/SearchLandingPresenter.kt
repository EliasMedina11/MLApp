package medina.elias.mlapp.search


import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import medina.elias.mlapp.adapters.ItemListAdapter
import medina.elias.mlapp.Service.RetroFitHelper
import medina.elias.mlapp.models.Result
import medina.elias.mlapp.utils.SearchListener


class SearchLandingPresenter(private var view : SearchLandingContract.View) : SearchLandingContract.Presenter {


    val retroFitHelper by lazy { RetroFitHelper.create() }
    var disposable : Disposable? = null
    var resultList : ArrayList<Result>? = null
    var adapter: ItemListAdapter? = null

    private val subscribeScheduler = Schedulers.io()
    private val observerScheduler = AndroidSchedulers.mainThread()



    override fun dispose() {
    }

  override fun doSearch (query : String){
    /*  Log.e("Comienza busqueda con",query)

  override  fun doSearch (query : String) {

        disposable =
                retroFitHelper.getSearchResult(query)
                        .subscribeOn(subscribeScheduler)
                        .observeOn(observerScheduler)
                        .subscribe(
                                { result -> resultList.addAll(result.results) },
                                { error -> Log.e("fallo la busqueda",error.message)})
        Log.e("resultado",resultList.toString())
        */

  }

    override fun updateItemRecyclerView(query: String) {

        adapter = ItemListAdapter(resultList!!,object: SearchListener {
            override fun onClick(itemId: String, position: Int) {
               Log.e("Evento", "Tocaste $itemId")
            }
        })
        view.displayItems(adapter!!)

    }

    override fun displayItemsSearch(adapter: ItemListAdapter) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }



    override fun navToSearch(searchList: ArrayList<Result>) {

    }


}