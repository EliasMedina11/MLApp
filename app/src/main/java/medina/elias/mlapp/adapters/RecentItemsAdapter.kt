package medina.elias.mlapp.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_view_vertical.view.*
import medina.elias.mlapp.R
import medina.elias.mlapp.models.Result
import medina.elias.mlapp.utils.SearchListener
import medina.elias.mlapp.utils.inflate
import medina.elias.mlapp.utils.loadByUrl

/** Adapter para resultados de busqueda, la intencion es crear un recycler view con items recientes o destacados**/

class RecentItemsAdapter(private val results: MutableList<Result>,private val listener: SearchListener?) : RecyclerView.Adapter<ViewHolderLanding>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolderLanding(parent.inflate(R.layout.item_view_vertical))

    override fun onBindViewHolder(holder: ViewHolderLanding, position: Int) = holder.bind(results[position], listener)

    override fun getItemCount() = results.size
}

class ViewHolderLanding (itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind (result: Result, listener: SearchListener? ) = with(itemView) {
        textViewMainTitle.text = result.title
        textViewMainPrice.text = (String.format("%s$%s", result.currency_id, result.price.toString()))
        itemView.imageViewMainProduct.loadByUrl(result.thumbnail)
        setOnClickListener { listener?.onClick(result.id, adapterPosition) }
    }

}