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

class RecentItemsAdapter(private val results: MutableList<Result>,private val listener: SearchListener?) : RecyclerView.Adapter<ViewHolderLanding>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolderLanding(parent.inflate(R.layout.item_view_vertical))

    override fun onBindViewHolder(holder: ViewHolderLanding, position: Int) = holder.bind(results[position], listener)

    override fun getItemCount() = results.size
}

class ViewHolderLanding (itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind (result: Result, listener: SearchListener? ) = with(itemView) {
        textViewMainTitle.text = result.title
        textViewMainPrice.text = (String.format("%s$%s", result.currencyId, result.price.toString()))
        Picasso.get().load(result.thumbnail).into(itemView.imageViewMainProduct)
        setOnClickListener { listener?.onClick(result.id, adapterPosition) }
    }

}