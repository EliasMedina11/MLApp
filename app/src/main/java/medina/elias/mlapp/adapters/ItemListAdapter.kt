package medina.elias.mlapp.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_view.view.*
import medina.elias.mlapp.R
import medina.elias.mlapp.models.Result
import medina.elias.mlapp.utils.SearchListener
import medina.elias.mlapp.utils.inflate

class ItemListAdapter(private val results: MutableList<Result>, private val listener: SearchListener?) : RecyclerView.Adapter<ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(parent.inflate(R.layout.item_view))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(results[position], listener)

    override fun getItemCount() = results.size
}

class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

fun bind (result: Result, listener: SearchListener? ) = with(itemView) {
    textViewProductTitle.text = result.title
    textViewPrice.text = (String.format("%s$%s", result.currency_id, result.price.toString()))
    Picasso.get().load(result.thumbnail).into(itemView.imageViewProduct)
    setOnClickListener { listener?.onClick(result.id, adapterPosition) }
}

}