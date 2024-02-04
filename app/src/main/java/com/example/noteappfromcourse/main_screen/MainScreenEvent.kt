package com.example.noteappfromcourse.main_screen

import com.example.noteappfromcourse.data.ShoppingListItem
import com.example.noteappfromcourse.shopping_list_screen.ShoppingListEvent

sealed class MainScreenEvent{
    object OnShowEditDialog : MainScreenEvent()
    object onItemSave : MainScreenEvent()
    data class Navigate(val route:String) : MainScreenEvent()
    data class NavigateMain(val route:String) : MainScreenEvent()
    data class OnNewItemClick(val route:String) : MainScreenEvent()
}
