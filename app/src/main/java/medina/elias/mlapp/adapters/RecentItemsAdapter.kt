package medina.elias.mlapp.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import medina.elias.mlapp.R
import medina.elias.mlapp.models.Result
import medina.elias.mlapp.utils.inflate

class RecentItemsAdapter (val recentItems: ArrayList<Result>) : RecyclerView.Adapter<RecentItemsAdapter.LandingViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewtype: Int) = LandingViewHolder(parent.inflate(R.layout.item_view_vertical))

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(p0: LandingViewHolder, p1: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    class LandingViewHolder (view : View) : RecyclerView.ViewHolder(view){}
}