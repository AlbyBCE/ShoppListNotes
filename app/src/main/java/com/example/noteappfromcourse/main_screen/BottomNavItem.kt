package com.example.noteappfromcourse.main_screen

import com.example.noteappfromcourse.R
import com.example.noteappfromcourse.utils.Routes

sealed class BottomNavItem(
    val title: String,
    val iconId: Int,
    val route: String
){
     object ListItem:BottomNavItem("List", R.drawable.list_icon,Routes.SHOPPING_LIST )
     object NoteItem:BottomNavItem("Note", R.drawable.note_icon,Routes.NOTE_LIST )
     object AboutItem:BottomNavItem("About", R.drawable.about_icon,Routes.ABOUT)
     object SettingsItem:BottomNavItem("Settings", R.drawable.settings_icon,Routes.SETTINGS )
}
