package medina.elias.mlapp.details

import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.View
import com.eliasmedina.mylibrary.ToolbarActivity
import kotlinx.android.synthetic.main.activity_details.*
import medina.elias.mlapp.R
import medina.elias.mlapp.adapters.ItemDetailsAdapter

/** Activity que recibe el id de un producto y luego obtiene su description**/

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
    // Setup de nuestro Toolbar
    override fun setSupportActionBar(toolbar: Toolbar?) {
    }

    private fun setupToolbar() {
        _toolbar!!.setTitle(R.string.detalles)
        _toolbar?.setNavigationOnClickListener {
            finish()
        }
    }
    // Seteamos el texto obtenido a nuestro TextView
    override fun updateDescriptionText(textDescription: String) {
        textViewDetails.text = textDescription
    }
    // metodo obligatorio ya que se esta utilizando el mismo presenter para dos vistas
    override fun updateRecyclerView(adapter: ItemDetailsAdapter) {}
    // Si showLoading = True {mostrar progress bar} si no{ ocultarlo }
    override fun showLoading(showLoading: Boolean) {
        if (showLoading) {
            progressBarDetails.visibility = View.VISIBLE
        } else {
            progressBarDetails.visibility = View.GONE
        }
    }

    override fun error() {
        textViewError.visibility = View.VISIBLE
    }

}
