package medina.elias.mlapp.landing

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.fragment_landing.*
import kotlinx.android.synthetic.main.fragment_landing.view.*
import medina.elias.mlapp.R
import medina.elias.mlapp.adapters.RecentItemsAdapter

class LandingFragment : Fragment(), LandingContract.View {

    private lateinit var recycler: RecyclerView
    private val presenter by lazy { LandingPresenter(this) }
    private val layoutManager by lazy { GridLayoutManager(context,2) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Se setea por defecto una busqueda en este caso Mac book
        presenter.fetchResult("Mac book")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_landing, container, false)
        recycler = rootView.recycler_item_main as RecyclerView

        return  rootView
    }
    //Metodo para asignarle a nuestro recycler el adapter ya cargado que proviene del presenter
    override fun updateRecyclerView(adapter: RecentItemsAdapter) {
        recycler.setHasFixedSize(true)
        recycler.itemAnimator = DefaultItemAnimator()
        recycler.layoutManager = layoutManager

        recycler.adapter = adapter
    }
    // Obtencion del context para utilizarlo en el presenter
    override fun getContext(): Context {
       return activity!!.applicationContext
    }
    // Error message en el caso de fallo
    override fun showNoResultsMessage() {
    }

    override fun showLoading(showLoading: Boolean) {}

    override fun onError() {
        view!!.textViewError.visibility = View.VISIBLE
    }

}
