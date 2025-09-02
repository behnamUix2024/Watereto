package com.behnamuix.watereto.View.component

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
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
import com.behnamuix.watereto.db.historyWater
import com.behnamuix.watereto.logic.waterCalculate_ML
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun GlassComp(glass_count: Int,weight: Float) {
    if(glass_count==0){
        Row {
            Text(
                modifier = Modifier,
                text = "هدف روزانه زده شد!",
                fontSize = 18.sp,
                fontFamily = VazirFont,
                textAlign = TextAlign.Center,
                style = TextStyle(textDirection = TextDirection.Rtl)
            )

            Icon(
                painter = painterResource(R.drawable.icon_age),
                contentDescription = "",
                modifier = Modifier.size(24.dp)
            )
        }
    }else{
        var d= SimpleDateFormat("yyyy/MM/dd", Locale.getDefault())
        var now_date=d.format(Date()).toString()
        var waterNeed_ml=waterCalculate_ML(weight)
        historyWater(waterNeed_ml,glass_count,now_date)
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy, // کمی بونس، طبیعی
                        stiffness = Spring.StiffnessLow               // نرم و آرام
                    )
                )
            ) {
                repeat(glass_count) {
                    Icon(
                        painter = painterResource(R.drawable.icon_glass),
                        contentDescription = "",
                        tint = Color(0xff1ca3ec),
                        modifier = Modifier.size(24.dp)
                    )
                }

            }
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = glass_count.toString() + "لیوان",
                fontSize = 18.sp,
                fontFamily = VazirFont,
                textAlign = TextAlign.Center,
                style = TextStyle(textDirection = TextDirection.Rtl)
            )
        }
    }


}