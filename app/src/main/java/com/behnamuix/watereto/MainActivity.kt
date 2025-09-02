package com.behnamuix.watereto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.behnamuix.avacast.ui.theme.VazirFont
import com.behnamuix.watereto.View.nav.DashboardTab
import com.behnamuix.watereto.View.nav.HistoryTab
import com.behnamuix.watereto.ui.theme.MvpComposeTheme
import com.orhanobut.hawk.Hawk

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // تنظیمات پنجره و نوارهای سیستم
        setupSystemBars()
        Hawk.init(this).build()
        setContent {
            MvpComposeTheme {
                TabNavigator(DashboardTab) { tabNav ->
                    Scaffold(
                        bottomBar = {
                            NavigationBar(containerColor = Color.Transparent) {
                                NavigationBarItem(
                                    colors = NavigationBarItemDefaults.colors(
                                        selectedIconColor = Color(
                                            0xFF00C6FF
                                        ),
                                        indicatorColor = Color.Transparent,
                                        selectedTextColor = Color(
                                            0xFF00C6FF
                                        )
                                    ),
                                    selected = tabNav.current == DashboardTab,
                                    onClick = { tabNav.current = DashboardTab },
                                    label = {
                                        Text(
                                            text = DashboardTab.options.title,
                                            fontFamily = VazirFont,
                                            fontSize = 16.sp
                                        )
                                    },
                                    icon = {
                                        Icon(
                                            painter = DashboardTab.options.icon!!,
                                            contentDescription = ""
                                        )
                                    }

                                )
                                NavigationBarItem(
                                    colors = NavigationBarItemDefaults.colors(
                                        selectedIconColor = Color(
                                            0xFF00C6FF
                                        ),
                                        indicatorColor = Color.Transparent,
                                        selectedTextColor = Color(
                                            0xFF00C6FF
                                        )
                                    ),
                                    selected = tabNav.current == HistoryTab,
                                    onClick = { tabNav.current = HistoryTab },
                                    label = {
                                        Text(
                                            text = HistoryTab.options.title,
                                            fontFamily = VazirFont,
                                            fontSize = 16.sp
                                        )
                                    },
                                    icon = {
                                        Icon(
                                            painter = HistoryTab.options.icon!!,
                                            contentDescription = ""
                                        )
                                    }

                                )
                            }
                        }
                    ) {
                        Box(Modifier.padding(it)) {

                            tabNav.current.Content()
                        }
                    }
                }


            }
        }
    }

    private fun setupSystemBars() {
        enableEdgeToEdge()
        WindowCompat.setDecorFitsSystemWindows(window, false)

        // تنظیم رنگ نوارها
        window.apply {
            statusBarColor = Color.Black.toArgb()
            navigationBarColor = Color.Black.toArgb()
        }

        // تنظیم رنگ آیکون‌های نوار ناوبری (روشن یا تیره)
        WindowCompat.getInsetsController(window, window.decorView).apply {
            isAppearanceLightStatusBars = false // آیکون‌های status bar تیره
            isAppearanceLightNavigationBars = false // آیکون‌های navigation bar تیره
        }
    }
}