package medina.elias.mlapp.landing

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.provider.Settings.Global.getString
import android.support.v4.content.ContextCompat.startActivity
import android.util.Log
import android.widget.ArrayAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import medina.elias.mlapp.R
import medina.elias.mlapp.Service.RetroFitHelper
import medina.elias.mlapp.adapters.RecentItemsAdapter
import medina.elias.mlapp.details.ItemDetailsActivity
import medina.elias.mlapp.models.Result
import medina.elias.mlapp.utils.SearchListener

class LandingPresenter(private val view: LandingContract.View): LandingContract.Presenter {

    val retroFitHelper by lazy { RetroFitHelper.create() }
    var disposable : Disposable? = null
    var adapter: RecentItemsAdapter? = null
    var context: Context = view.getContext()

    private val subscribeScheduler = Schedulers.io()
    private val observerScheduler = AndroidSchedulers.mainThread()

    override fun fetchResult(search: String) {
        Log.e("Comienza busqueda de:",search)
        view.showLoading(true)

        disposable =
                retroFitHelper.getSearchResult(search)
                        .subscribeOn(subscribeScheduler)
                        .observeOn(observerScheduler)
                        .subscribe( { result -> attachToAdapter(result.results)},
                                    { error ->  Log.e("Error with product",error.message)}
                        )
    }

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
    override fun dispose() {}

}

