package medina.elias.mlapp.details

import android.os.Bundle

import medina.elias.mlapp.R
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.View
import com.eliasmedina.mylibrary.ToolbarActivity
import kotlinx.android.synthetic.main.activity_item_details.*
import medina.elias.mlapp.adapters.ItemDetailsAdapter
import medina.elias.mlapp.landing.LandingActivity
import medina.elias.mlapp.utils.goToActivity

/** Activity que obtiene el id de una busqueda para hacer luego obtener los detalles del producto**/

class ItemDetailsActivity : ToolbarActivity(), ItemDetailsContract.View{

    private val presenter: ItemDetailsPresenter by lazy { ItemDetailsPresenter(this) }

    private lateinit var recycler: RecyclerView
    private val layoutManager by lazy { LinearLayoutManager(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_details)

        toolbarToLoad(toolbar as Toolbar)
        // referenciamos nuestro recyclerView y obtenemos a travez de un intent el ItemId de la busqueda
        recycler = recycler_view_details
        val productId : String = intent.getStringExtra("itemId")

        setupToolbar()
        searchDetails(productId)
    }

    override fun setSupportActionBar(toolbar: Toolbar?) {
    }
        //Metodo que viene con nuestro adapter ya cargado desde el presenter y se le añade a nuestro recycler
    override fun updateRecyclerView(adapter: ItemDetailsAdapter) {
        recycler.setHasFixedSize(true)
        recycler.itemAnimator = DefaultItemAnimator()
        recycler.layoutManager = layoutManager
        recycler.adapter = adapter
}
    // Si showLoading = True {mostrar progress bar} si no{ ocultarlo }
    override fun showLoading(showLoading: Boolean) {
        if (showLoading) {
            progressBarMainDetails.visibility = View.VISIBLE
        } else {
            progressBarMainDetails.visibility = View.GONE
        }
    }
    // Busqueda de los detalles del producto que luego seran enviados a DetailsActivity
    private fun searchDetails(productId: String) {
        presenter.searchDetails(productId)
    }
    //Seteamos nuestro Toolbar
    private fun setupToolbar() {
        _toolbar!!.setTitle(R.string.product)
        _toolbar?.setNavigationOnClickListener {
            finish()
        }
    }
    // metodo obligatorio ya que se esta utilizando el mismo presenter para dos vistas
    override fun updateDescriptionText(textDescription: String) {

    }

}