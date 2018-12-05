package medina.elias.mlapp.adapters

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_landing.view.*
import medina.elias.mlapp.R
import medina.elias.mlapp.models.Product
import medina.elias.mlapp.utils.inflate

class ItemListAdapter(private val items: List<Product>): RecyclerView.Adapter<ItemListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): = RecyclerView.ViewHolder(parent.inflate(R.layout.items_recycler))
    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) = holder.bind(items[position])

}