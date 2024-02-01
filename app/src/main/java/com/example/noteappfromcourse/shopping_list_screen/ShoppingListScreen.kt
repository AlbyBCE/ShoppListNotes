package com.example.noteappfromcourse.shopping_list_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.compose.md_theme_light_primaryContainer
import com.example.noteappfromcourse.dialog.MainDialog
import com.example.noteappfromcourse.utils.UiEvent
import kotlinx.coroutines.flow.collect

@Composable
fun ShoppingListScreen(
    viewModel: ShoppingListViewModel = hiltViewModel(),
//    onNavigate: (UiEvent) -> Unit
    onNavigate: (String) -> Unit
) {
    val itemList = viewModel.list.collectAsState(initial = emptyList())
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect() { uiEvent ->
            when (uiEvent) {
                is UiEvent.Navigate -> {
//                    onNavigate(uiEvent)
                    onNavigate(uiEvent.route)
                }

                else -> {}
            }
        }
    }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = md_theme_light_primaryContainer),
        contentPadding = PaddingValues(bottom = 100.dp)
    )
    {
        items(itemList.value) { item ->
            UIShoppingListItem(item) { event ->
                viewModel.onEvent(event)
            }
        }
    }
    MainDialog(dialogController = viewModel)
}