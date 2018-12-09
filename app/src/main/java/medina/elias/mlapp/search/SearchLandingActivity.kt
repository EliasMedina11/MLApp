package medina.elias.mlapp.search

import android.app.SearchManager
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import kotlinx.android.synthetic.main.activity_search.*
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import medina.elias.mlapp.adapters.ItemListAdapter



class SearchLandingActivity : AppCompatActivity(), SearchLandingContract.View {

    private val presenter by lazy { SearchLandingPresenter(this) }
    private val layoutManager by lazy { LinearLayoutManager(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        handleIntent(intent)

    }

    override fun onPause() {
        super.onPause()
    }

    override fun getQuery(query: String) {
    }

    override fun displayItems(adapter: ItemListAdapter) {
        recycler_item_search.layoutManager = LinearLayoutManager(this,LinearLayout.VERTICAL,false)
        recycler_item_search.setHasFixedSize(true)
        recycler_item_search.itemAnimator = DefaultItemAnimator()
        recycler_item_search.layoutManager = layoutManager

        recycler_item_search.adapter = adapter

    }

    override fun showLoading(showLoading: Boolean) {
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        handleIntent(intent)
    }
    private fun handleIntent(intent: Intent) {
        if(Intent.ACTION_SEARCH == intent.action){
            intent.getStringExtra(SearchManager.QUERY)?.also { query ->
               presenter.updateItemRecyclerView(query)
            }
        }
    }

  /*  fun doSearch (query : String): List<Result> {
        var resultList = listOf<Result>()
        Log.e("Comienza busqueda con",query)
        disposable =
                retroFitHelper.getSearchResult(query)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                { result -> resultList = result.results },
                                { error -> Log.e("fallo la busqueda",error.message)})
        Log.e("resultado",resultList.toString())
        return resultList
    }
    */

}
