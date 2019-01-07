package com.redflag.lfvg.senaikotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_home.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import org.jsoup.Jsoup

class HomeActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    fun parse(): List<User>{
        var retorno:List<User> = emptyList()
        val doc = Jsoup.connect("https://randomuser.me/api/?format=xml&results=25").get()
        val users =  doc.select("results")
        for(user in users){
            
        }
        return retorno
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(home_toolbar)

        viewManager = LinearLayoutManager(this)

        try {
            doAsync {
                var lista: List<User> = parse()
                uiThread {
                    viewAdapter = HomeRecyclerViewAdapter(lista)
                    recyclerView = findViewById<RecyclerView>(R.id.home_recycler_view).apply {
                        setHasFixedSize(true)
                        layoutManager = viewManager
                        adapter = viewAdapter
                    }
                }
            }
        }catch (e: Exception){

        }
    }
}
