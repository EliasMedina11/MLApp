package medina.elias.mlapp.details

import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import com.eliasmedina.mylibrary.R.layout.toolbar
import com.eliasmedina.mylibrary.ToolbarActivity
import kotlinx.android.synthetic.main.activity_item_details.*
import medina.elias.mlapp.R
import medina.elias.mlapp.adapters.ItemDetailsAdapter

class ItemDetailsActivity : ToolbarActivity(), ItemDetailsContract.View{

    private val presenter: ItemDetailsPresenter by lazy { ItemDetailsPresenter(this) }

    private lateinit var recycler: RecyclerView
    private val layoutManager by lazy { LinearLayoutManager(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_details)
        toolbarToLoad(toolbar as Toolbar)

        recycler = recycler_view_details

        searchDetails("MLA722803144")
    }

    override fun updateRecyclerView(adapter: ItemDetailsAdapter) {
        recycler.setHasFixedSize(true)
        recycler.itemAnimator = DefaultItemAnimator()
        recycler.layoutManager = layoutManager
        recycler.adapter = adapter
}

    override fun showLoading(showLoading: Boolean) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}

    private fun searchDetails(productId: String) {
        presenter.searchDetails(productId)
    }
}