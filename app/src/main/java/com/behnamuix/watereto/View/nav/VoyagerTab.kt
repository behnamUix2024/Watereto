package com.behnamuix.watereto.View.nav

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.behnamuix.watereto.R

object DashboardTab : Tab {

    override val options: TabOptions
        @Composable
        get() {
            val title ="داشبورد"
            val icon = painterResource(R.drawable.icon_dashboard)

            return remember {
                TabOptions(
                    index = 0u,
                    title = title,
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        Navigator(HomeWatterSc)
    }
}
object HistoryTab : Tab {

    override val options: TabOptions
        @Composable
        get() {
            val title ="تاریخچه"
            val icon = painterResource(R.drawable.icon_history)

            return remember {
                TabOptions(
                    index = 1u,
                    title = title,
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
            Navigator(HistoryDrinksWaterSc)
    }
}