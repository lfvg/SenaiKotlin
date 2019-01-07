package com.redflag.lfvg.senaikotlin


import android.content.Intent
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bumptech.glide.Glide


class HomeRecyclerViewAdapter(private val lista: List<User>): RecyclerView.Adapter<HomeRecyclerViewAdapter.HomeViewHolder> (){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.home_user, parent,
            false))
    }
    override fun getItemCount(): Int {
        Log.d("HomeLogs", "Tamanho da lista recebida " + lista.size)
        return lista.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.home_user_name).setText(lista[position].nome)
        Glide.with(holder.itemView).load(lista[position].avatar).into(holder.itemView.findViewById(R.id.home_user_avatar))
        holder.itemView.setOnClickListener {
            Log.d("HomeLogs","Foi clicado " + position)
            /*val myIntent = Intent(it.context, ArticlePageActivity::class.java)
            myIntent.putExtra("urlArticle", lista[position].link)
            ContextCompat.startActivity(it.context, myIntent, null)*/
        }
    }


    class HomeViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

    }
}