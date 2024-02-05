package com.example.noteappfromcourse.settings_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.compose.lightText

@Composable
fun SettingsScreen(viewModel: SettingsViewModel = hiltViewModel()) {
    val list = viewModel.colorItemListState.value
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "TitleColor",
            fontSize = 16.sp
        )
        Text(
            text = "Select a title color",
            fontSize = 12.sp,
            color = lightText
        )
        LazyRow(
            Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
        ) {
            items(list) { item ->
                UiColorItem(item = item)
            }
        }
    }
}