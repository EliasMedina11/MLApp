package medina.elias.mlapp.details

import android.os.Bundle

import medina.elias.mlapp.R
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import com.eliasmedina.mylibrary.ToolbarActivity
import kotlinx.android.synthetic.main.activity_item_details.*
import medina.elias.mlapp.adapters.ItemDetailsAdapter
import medina.elias.mlapp.landing.LandingActivity
import medina.elias.mlapp.utils.goToActivity

class ItemDetailsActivity : ToolbarActivity(), ItemDetailsContract.View{

    private val presenter: ItemDetailsPresenter by lazy { ItemDetailsPresenter(this) }

    private lateinit var recycler: RecyclerView
    private val layoutManager by lazy { LinearLayoutManager(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_details)

        toolbarToLoad(toolbar as Toolbar)

        recycler = recycler_view_details
        val productId : String = intent.getStringExtra("itemId")

        setupToolbar()
        searchDetails(productId)
    }

    override fun setSupportActionBar(toolbar: Toolbar?) {
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

    private fun setupToolbar() {
        _toolbar!!.setTitle(R.string.product)
        _toolbar?.setNavigationOnClickListener {
            finish()
        }
    }
}