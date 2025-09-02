package com.behnamuix.watereto.View.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.behnamuix.avacast.ui.theme.VazirFont

@Composable
fun WeightSelector(
    weight: Float,
    onWeightChange: (Float) -> Unit
) {

    var text by remember { mutableStateOf(TextFieldValue(weight.toString())) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(

            modifier = Modifier.fillMaxWidth(),
            text = "وزن خود را وارد کنید",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = VazirFont,
            textAlign = TextAlign.Center,
            style = TextStyle(textDirection = TextDirection.Rtl)
        )
        OutlinedTextField(
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF00C6FF)
            ),
            value = text,
            maxLines = 1,
            isError = weight > 150 || weight < 45,
            onValueChange = {
                text = it
                it.text.toFloatOrNull()?.let { value ->


                    onWeightChange(value)

                }
            },
            shape = RoundedCornerShape(12.dp),
            placeholder = {
                Text(
                    text = "وزن",
                    fontFamily = VazirFont,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            },
            singleLine = true,
            textStyle = TextStyle(
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                fontFamily = VazirFont
            ),
            modifier = Modifier
                .fillMaxWidth(0.4f)
                .padding(16.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "45~150 Kg",
            fontSize = 14.sp,
            fontFamily = VazirFont,

            textAlign = TextAlign.Center,
            style = TextStyle(textDirection = TextDirection.Ltr)
        )
    }
}