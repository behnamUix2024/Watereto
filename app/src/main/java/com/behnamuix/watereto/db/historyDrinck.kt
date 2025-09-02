package com.behnamuix.watereto.db

import com.behnamuix.watereto.model.HistoryDrinks
import com.orhanobut.hawk.Hawk

fun historyWater(need: Float, glassCount: Int, nowDate: String) {
    var listHistory=listOf<HistoryDrinks>(
        HistoryDrinks(valueDrink = need,glassCount,nowDate.toString())
    )
    Hawk.put("savedwater",listHistory)

}