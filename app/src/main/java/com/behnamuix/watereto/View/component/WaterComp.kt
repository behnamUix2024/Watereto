package com.behnamuix.watereto.View.component

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.behnamuix.avacast.ui.theme.VazirFont
import com.behnamuix.avacast.ui.theme.VazirFontBold
import com.behnamuix.watereto.R
import com.behnamuix.watereto.logic.BackwardWater
import com.behnamuix.watereto.logic.drinkWater
import com.behnamuix.watereto.logic.glassCalculate
import com.behnamuix.watereto.logic.waterCalculate_ML

@Composable
fun WaterComp() {
    var weight by rememberSaveable { mutableStateOf(50f) }
    var waterNeed_ml by rememberSaveable { mutableStateOf(0f) }
    var waterProgress by rememberSaveable { mutableStateOf(0f) }
    var glassCount by rememberSaveable { mutableStateOf(0) }
    var list_color = listOf<Color>(
        Color(0xFF00C6FF),
        Color(0xFF0072FF)
    )
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(Modifier.height(20.dp))

        WeightSelector(weight = weight, onWeightChange = { weight = it })

        LaunchedEffect(weight) {
            waterProgress = 0f
            waterNeed_ml = waterCalculate_ML(weight.toFloat())
        }
        Spacer(Modifier.height(20.dp))

        Column(
            modifier = Modifier.animateContentSize()
        ) {
            if (!(weight > 150 || weight < 45)) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,

                    ) {
                    //Minus Btn
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Box(
                            contentAlignment = Alignment.BottomStart,
                            modifier = Modifier.size(350.dp)
                        ) {
                            Card(
                                border = BorderStroke(0.2.dp, Color(0xFF00C6FF)),
                                elevation = CardDefaults.elevatedCardElevation(4.dp),
                                colors = CardDefaults.cardColors(Color.White),
                                shape = RoundedCornerShape(
                                    bottomStart = 20.dp,
                                    topStart = 20.dp
                                ),
                                modifier = Modifier

                                    .width(90.dp),
                                onClick = {
                                    val state = drinkWater(waterNeed_ml, waterProgress, glassCount)
                                    waterNeed_ml = state.need
                                    waterProgress = state.progress
                                }) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(
                                        modifier = Modifier
                                            .padding(4.dp)
                                            .size(36.dp),
                                        painter = painterResource(R.drawable.icon_water_minus),
                                        contentDescription = "",
                                        tint = Color(0xFF00C6FF)
                                    )
                                    Text(
                                        modifier = Modifier
                                            .size(36.dp)
                                            .padding(4.dp),
                                        text = "-",
                                        color = Color(0xFF00C6FF),
                                        fontSize = 20.sp
                                    )

                                }
                            }
                        }
                        //Posetive btn
                        Box(
                            contentAlignment = Alignment.TopEnd,
                            modifier = Modifier.size(350.dp)
                        ) {
                            Card(
                                border = BorderStroke(0.1.dp, Color(0xFF8BC34A)),
                                enabled = waterNeed_ml < 1500,
                                elevation = CardDefaults.elevatedCardElevation(4.dp),
                                colors = CardDefaults.cardColors(containerColor = Color.White),
                                shape = RoundedCornerShape(
                                    topStart = 20.dp,
                                    bottomStart = 20.dp
                                ),
                                modifier = Modifier
                                    .rotate(180f)
                                    .width(90.dp),
                                onClick = {
                                    val state =
                                        BackwardWater(waterNeed_ml, waterProgress, glassCount)
                                    waterNeed_ml = state.need
                                    waterProgress = state.progress
                                }) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(
                                        modifier = Modifier
                                            .rotate(180f)
                                            .padding(4.dp)
                                            .size(36.dp),
                                        painter = painterResource(R.drawable.icon_water_minus),
                                        contentDescription = "",
                                        tint = Color(0xFF00C6FF)
                                    )
                                    Text(
                                        modifier = Modifier
                                            .size(36.dp)
                                            .padding(4.dp),
                                        text = "+",
                                        color = Color(0xFF00C6FF),
                                        fontSize = 20.sp
                                    )

                                }
                            }
                        }
                        Box() {

                            Column {

                                Text(
                                    color = Color(0xFF00C6FF),
                                    modifier = Modifier.fillMaxWidth(),
                                    text = waterNeed_ml.toInt().toString(),
                                    fontSize = 38.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = VazirFont,
                                    textAlign = TextAlign.Center,
                                    style = TextStyle(textDirection = TextDirection.Rtl)
                                )

                                Text(
                                    modifier = Modifier.fillMaxWidth(),
                                    text = "میلی لیتر\n مانده",
                                    fontSize = 20.sp,
                                    fontFamily = VazirFont,
                                    textAlign = TextAlign.Center,
                                    style = TextStyle(textDirection = TextDirection.Rtl)
                                )
                                Text(
                                    modifier = Modifier.fillMaxWidth(),
                                    text = "{${((waterNeed_ml.toInt() / 1000))}Liter}",
                                    fontSize = 14.sp,
                                    fontFamily = VazirFont,
                                    textAlign = TextAlign.Center,
                                    style = TextStyle(textDirection = TextDirection.Rtl)
                                )
                            }
                        }

//                        Canvas(
//                            modifier = Modifier
//                                .size(300.dp)
//                                .padding(10.dp)
//                        ) {
//                            drawArc(
//                                color = (Color.White),
//                                startAngle = 150f,
//                                sweepAngle = 240f,
//                                useCenter = false,
//                                style = Stroke(20.dp.toPx(), cap = StrokeCap.Round),
//                                size = Size(size.width, size.width)
//
//                            )
//
//                            drawArc(
//                                brush = Brush.linearGradient(
//                                    list_color
//                                ),
//                                startAngle = 150f,
//                                sweepAngle = waterProgress,
//                                useCenter = false,
//                                style = Stroke(12.dp.toPx(), cap = StrokeCap.Round),
//                                size = Size(size.width, size.height)
//                            )


//
//
//                        }
                        CircularProgressIndicator(
                            progress = { waterProgress / 360 },
                            modifier = Modifier.size(300.dp),
                            color = Color.White,
                            strokeWidth = 12.dp,
                            strokeCap = StrokeCap.Butt,
                            trackColor = Color(0xFF00C6FF),

                            )

                    }

                    Spacer(Modifier.height(20.dp))

                    glassCount = glassCalculate(waterNeed_ml.toInt())
                    GlassComp(glassCount,weight)

                    Spacer(Modifier.height(20.dp))


                }

            } else {
                Box(modifier = Modifier.fillMaxSize()) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.icon_error),
                            contentDescription = "",
                            modifier = Modifier.size(70.dp),
                            tint = Color(0xFFF44336),
                        )
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "این مقدار وزن در محدوده مجاز نیست!",
                            fontSize = 18.sp,
                            color = Color(0xFFF44336),
                            fontFamily = VazirFontBold,

                            textAlign = TextAlign.Center,
                            style = TextStyle(textDirection = TextDirection.Rtl)
                        )
                    }
                }
            }
        }

    }

}