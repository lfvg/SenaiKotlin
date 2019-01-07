package com.redflag.lfvg.senaikotlin

import android.util.Log
import org.jsoup.Jsoup

class Parse {
    fun parse(): List<User>{
        //Log.d("HomeLogs", "Entrou na funcao do parse")
        var retorno:List<User> = emptyList()
        val doc = Jsoup.connect("https://randomuser.me/api/?format=xml&results=25").get()
       // Log.d("HomeLogs", "pegou o xml")
        val users =  doc.select("results")
        var i = 0
        Log.d("HomeLogs", "tamannho do users: " + users.size)
        for(user in users){
            Log.d("HomeLogs", "tá no for")
            if(i<25){
                Log.d("HomeLogs", "entrou no if")
                retorno = retorno.plus(User(user.selectFirst("first").text() + " " +
                    user.selectFirst("last").text(), user.selectFirst("email").text(),
                    user.selectFirst("date").text(), user.selectFirst("phone").text(),
                    user.selectFirst("cell").text(), user.selectFirst("latitude").text().toDouble(),
                    user.selectFirst("longitude").text().toDouble(), user.selectFirst("large").text()))
            }
            Log.d("HomeLogs", "saiu do if")
            i += 1
        }
        return retorno
    }
}