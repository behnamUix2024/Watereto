package com.behnamuix.watereto.View.nav

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import com.behnamuix.avacast.ui.theme.VazirFont
import com.behnamuix.avacast.ui.theme.VazirFontBold
import com.behnamuix.watereto.R
import com.behnamuix.watereto.View.component.WaterComp
import com.behnamuix.watereto.model.HistoryDrinks
import com.orhanobut.hawk.Hawk

object HomeWatterSc : Screen {
    @Composable
    override fun Content() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        modifier = Modifier
                            .padding(4.dp)
                            .size(36.dp),
                        painter = painterResource(R.drawable.icon_log),
                        contentDescription = "",
                        tint = Color(0xFFF44336)
                    )
                    Text(
                        text = "واترتو",
                        fontSize = 30.sp,
                        fontFamily = VazirFontBold,
                        textAlign = TextAlign.Center,
                        style = TextStyle(textDirection = TextDirection.Rtl)
                    )

                }
                WaterComp()

            }

        }
    }
}

object HistoryDrinksWaterSc : Screen {
    @Composable
    override fun Content() {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                var list: List<HistoryDrinks> = Hawk.get("savedwater", emptyList())
                Log.d("water",list.toString())
                items(items = list) {
                    Card(modifier = Modifier.fillMaxWidth()) {
                        Column {
                            Text(it.valueDrink.toString(), fontFamily = VazirFont, fontSize = 20.sp)
                            Text(it.cups.toString(), fontFamily = VazirFont, fontSize = 18.sp)
                            Text(it.date.toString(), fontFamily = VazirFont, fontSize = 14.sp)
                        }
                    }
                }
            }
        }
    }

}

