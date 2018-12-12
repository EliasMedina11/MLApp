package medina.elias.mlapp.search

import android.os.Bundle
import android.support.v7.widget.*
import kotlinx.android.synthetic.main.activity_search.*
import android.view.Menu
import android.view.View
import com.eliasmedina.mylibrary.ToolbarActivity
import medina.elias.mlapp.R
import medina.elias.mlapp.adapters.ItemListAdapter
import medina.elias.mlapp.landing.LandingActivity
import medina.elias.mlapp.utils.goToActivity


class SearchLandingActivity : ToolbarActivity(), SearchLandingContract.View {

    private val presenter by lazy { SearchLandingPresenter(this) }
    private val layoutManager by lazy { LinearLayoutManager(this) }
    private lateinit var recycler: RecyclerView
    private lateinit var query : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        toolbarToLoad(toolbar as Toolbar)
        //Obtenemos lo ingresado por el usuario y lo guardamos en una variable
        query = intent.getStringExtra("query")
        //Se llama el metodo doSearch del Presenter y se le da como parametro la query obtenida
        presenter.doSearch(query)
        setupToolbar()

        recycler = recycler_item_search
    }
        //Se vuelve a suscribir el comportamiento en el caso de que el usuario haga una busqueda
    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.toolbar_actions,menu)
        val searchItem = menu.findItem(R.id.action_search_button)
        if (searchItem != null) {
            val searchView = searchItem.actionView as SearchView
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String): Boolean {
                    presenter.doSearch(query)
                    return true
                }
                override fun onQueryTextChange(newText: String?): Boolean {
                    return true
                }
            })
        }
        return true
    }

    private fun setupToolbar() {
        _toolbar?.setNavigationOnClickListener {
            goToActivity<LandingActivity> {  }
        }
    }
    //Metodo para asignarle a nuestro recycler el adapter ya cargado que proviene del presenter
    override fun displayItems(adapter: ItemListAdapter) {
        recycler.setHasFixedSize(true)
        recycler.itemAnimator = DefaultItemAnimator()
        recycler.layoutManager = layoutManager

        recycler.adapter = adapter

    }

    override fun showLoading(showLoading: Boolean) {
        if (!showLoading){
            progressBar.visibility = View.GONE
        }
    }

    override fun getContext() = this

    //En caso de que no se encuentren resultados se muestra un mensaje al usuario
    override fun showNoResultsMessage() {
        textViewNoResults.visibility = View.VISIBLE
    }

    override fun error() {
        textViewNoResults.text = getString(R.string.error_with_search).toString()
        textViewNoResults.visibility = View.VISIBLE
    }


}
