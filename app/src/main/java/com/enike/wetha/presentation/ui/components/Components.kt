package com.enike.wetha.presentation.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun CustomInputField(
    modifier: Modifier = Modifier
        .padding(5.dp)
        .fillMaxWidth(),
    text: String,
    singleLine: Boolean = true,
    onTextChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions =
        KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
    shapes: Shape = MaterialTheme.shapes.small.copy(all = CornerSize(15.dp)),
    leadingIcon: @Composable (() -> Unit)? = null,
    hint: String = "8140252210"
) {
    Surface(
        modifier = Modifier.padding(20.dp),
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.3f),
        shape = shapes
    ) {
        TextField(
            modifier = modifier.padding(horizontal = 20.dp, vertical = 2.dp),
            value = text,
            onValueChange = onTextChange,
            textStyle = MaterialTheme.typography.subtitle1,
            placeholder = {
                Text(
                    text = hint,
                    style = MaterialTheme.typography.subtitle1,
                )
            },
            singleLine = singleLine,
            keyboardOptions = keyboardOptions,
            colors = TextFieldDefaults.textFieldColors(
                disabledTextColor = Color.Transparent,
                backgroundColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            leadingIcon = leadingIcon
        )
    }

}