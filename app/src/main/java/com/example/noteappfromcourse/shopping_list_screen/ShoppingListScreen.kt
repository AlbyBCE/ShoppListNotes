package com.example.noteappfromcourse.shopping_list_screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ShoppingListScreen() {
    Text(
        text = "Shopping List Screen",
        modifier = Modifier
            .fillMaxSize()
            .wrapContentWidth()
            .wrapContentHeight()
    )
}