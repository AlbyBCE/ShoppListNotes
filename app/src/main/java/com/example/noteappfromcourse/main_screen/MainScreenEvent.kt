package com.example.noteappfromcourse.main_screen

import com.example.noteappfromcourse.data.ShoppingListItem
import com.example.noteappfromcourse.shopping_list_screen.ShoppingListEvent

sealed class MainScreenEvent{
    object OnShowEditDialog : MainScreenEvent()
    object onItemSave : MainScreenEvent()
}
