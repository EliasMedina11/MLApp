package medina.elias.mlapp.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import ir.apend.slider.model.Slide
import kotlinx.android.synthetic.main.product_details.view.*
import medina.elias.mlapp.R
import medina.elias.mlapp.models.Product
import medina.elias.mlapp.utils.inflate

class ItemDetailsAdapter (val items: ArrayList<Product>) :RecyclerView.Adapter<ItemDetailsAdapter.ViewHolderProduct>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolderProduct(parent.inflate(R.layout.product_details))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolderProduct, position: Int) = holder.bind(items[position])

    class ViewHolderProduct (view: View) : RecyclerView.ViewHolder(view){

        fun bind (item: Product) = with(itemView){
         val slide:  MutableList<Slide> = mutableListOf()
            for (i in item.pictures.indices){
                slide.add(Slide(i,item.pictures[i].url,R.dimen.slider_image_corner)) }
            imageViewProduct.addSlides(slide)
            textViewTitle.text = item.title
            textViewDetails.text = item.condition
        }

    }

}