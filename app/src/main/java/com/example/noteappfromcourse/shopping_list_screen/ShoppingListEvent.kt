package com.example.noteappfromcourse.shopping_list_screen

import com.example.noteappfromcourse.data.ShoppingListItem

sealed class ShoppingListEvent {
    data class OnShowDeleteDialog(val item: ShoppingListItem) : ShoppingListEvent()
    data class OnShowEditDialog(val item: ShoppingListItem) : ShoppingListEvent()
    data class OnItemClick(val route: String) : ShoppingListEvent()
    object onItemSave : ShoppingListEvent() {

    }
}

//fun onEvent(event: ShoppingListEvent){} передача в параметр всего класса, чтобы можно было передавать все события в этом классе