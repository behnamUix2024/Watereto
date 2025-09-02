package com.behnamuix.watereto.View.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
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
import com.behnamuix.avacast.ui.theme.VazirFont
import com.behnamuix.watereto.R

@Composable
fun GenderSelection(onGenderClicked: (String) -> Unit) {
    var list_gender = listOf<String>("مرد", "زن")
    var list_icon = listOf<Int>(R.drawable.icon_male, R.drawable.icon_female)
    var list_icon_color = listOf<Color>(Color(0xFF42A5F5), Color(0xFFF48FB1))
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            list_gender.forEachIndexed { index, gender ->
                ElevatedCard(
                    elevation = CardDefaults.elevatedCardElevation(4.dp),
                    modifier = Modifier

                        .clickable(onClick = { onGenderClicked(gender)})
                        .size(100.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            modifier = Modifier.size(42.dp),
                            painter = painterResource(
                                if (index.equals(0)) {
                                    list_icon.get(0)
                                } else {
                                    list_icon.get(1)

                                }
                            ),
                            tint = if (index.equals(0)) {
                                list_icon_color.get(0)
                            } else {
                                list_icon_color.get(1)

                            },
                            contentDescription = ""
                        )
                        Text(
                            text = gender,
                            fontSize = 24.sp,
                            fontFamily = VazirFont,
                            textAlign = TextAlign.Center,
                            style = TextStyle(textDirection = TextDirection.Rtl)
                        )
                    }

                }

            }


        }
    }
}