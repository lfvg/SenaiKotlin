package com.redflag.lfvg.senaikotlin

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup

class HomeRecyclerViewAdapter(private val lista: List<User>): RecyclerView.Adapter<HomeRecyclerViewAdapter.HomeViewHolder> (){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): HomeViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(p0: HomeViewHolder, p1: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    class HomeViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

    }
}