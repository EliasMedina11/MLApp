package medina.elias.mlapp.search


import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import medina.elias.mlapp.adapters.ItemListAdapter
import medina.elias.mlapp.Service.RetroFitHelper
import medina.elias.mlapp.details.ItemDetailsActivity
import medina.elias.mlapp.models.Result
import medina.elias.mlapp.utils.SearchListener


class SearchLandingPresenter(private var view : SearchLandingContract.View) : SearchLandingContract.Presenter {

    val retroFitHelper by lazy { RetroFitHelper.create() }
    var disposable : Disposable? = null
    var adapter: ItemListAdapter? = null
    var context: Context = view.getContext()

    private val subscribeScheduler = Schedulers.io()
    private val observerScheduler = AndroidSchedulers.mainThread()

    override fun dispose() {
    }

  override fun doSearch (query : String){
      Log.e("Comienza busqueda de:",query)
      view.showLoading(true)

      disposable =
              retroFitHelper.getSearchResult(query)
                      .subscribeOn(subscribeScheduler)
                      .observeOn(observerScheduler)
                      .subscribe( { result -> updateItemRecyclerView(result.results)},
                              { error ->  Log.e("Error with product",error.message)}
                      )
  }

    override fun updateItemRecyclerView(results: List<Result>) {
        view.showLoading(false)
        if (results.isNotEmpty()){
            adapter = ItemListAdapter(results.toMutableList(),object: SearchListener {
                override fun onClick(itemId: String, position: Int) {
                    val intent = Intent(context,ItemDetailsActivity::class.java)
                    intent.putExtra("itemId", itemId)
                    startActivity(context,intent,null)
                }
            })
            view.displayItems(adapter!!)
        } else {
            view.showNoResultsMessage()
        }

    }

}