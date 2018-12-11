package medina.elias.mlapp.details

import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.View
import com.eliasmedina.mylibrary.ToolbarActivity
import kotlinx.android.synthetic.main.activity_details.*
import medina.elias.mlapp.R
import medina.elias.mlapp.adapters.ItemDetailsAdapter

class DetailsActivity : ToolbarActivity(), ItemDetailsContract.View {

    private val presenter: ItemDetailsPresenter by lazy { ItemDetailsPresenter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        toolbarToLoad(toolbar as Toolbar)

        setupToolbar()
        val productId = intent.getStringExtra("details")
        presenter.searchDescription(productId)
    }

    private fun setupToolbar() {
        _toolbar!!.setTitle(R.string.product)
        _toolbar?.setNavigationOnClickListener {
            finish()
        }
    }

    override fun updateDescriptionText(textDescription: String) {
        textViewDetails.text = textDescription
    }

    override fun updateRecyclerView(adapter: ItemDetailsAdapter) {}

    override fun showLoading(showLoading: Boolean) {
        if (showLoading) {
            progressBarDetails.visibility = View.VISIBLE
        } else {
            progressBarDetails.visibility = View.GONE
        }
    }

}
