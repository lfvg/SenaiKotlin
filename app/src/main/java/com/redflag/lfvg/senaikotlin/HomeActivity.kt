package com.redflag.lfvg.senaikotlin

import android.app.SearchManager
import android.content.ComponentName
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.SearchView
import android.util.Log
import android.view.Menu
import kotlinx.android.synthetic.main.activity_home.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import org.jsoup.Jsoup

class HomeActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    val parser: Parse = Parse()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(home_toolbar)

        viewManager = LinearLayoutManager(this)

        try {
            doAsync {
                var lista: List<User> = parser.parse()
                //Log.d("HomeLogs", "Saiu do parse")
                uiThread {
                    Log.d("HomeLogs", "saiu")
                    viewAdapter = HomeRecyclerViewAdapter(lista)
                    recyclerView = findViewById<RecyclerView>(R.id.home_recycler_view).apply {
                        setHasFixedSize(true)
                        layoutManager = viewManager
                        adapter = viewAdapter
                    }
                }
            }
        }catch (e: Exception){
            Log.d("HomeLogs", "deu erro")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_page_toolbar, menu)
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        (menu?.findItem(R.id.app_bar_search)?.actionView as SearchView).apply {
            setSearchableInfo(searchManager.getSearchableInfo(ComponentName(context, SearchActivity::class.java)))
            queryHint = getString(R.string.search_hint)
        }
        return super.onCreateOptionsMenu(menu)
    }
}
