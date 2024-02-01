package com.example.noteappfromcourse.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.noteappfromcourse.about_screen.AboutScreen
import com.example.noteappfromcourse.note_list_screen.NoteListScreen
import com.example.noteappfromcourse.settings_screen.SettingsScreen
import com.example.noteappfromcourse.shopping_list_screen.ShoppingListScreen
import com.example.noteappfromcourse.utils.Routes
import com.example.noteappfromcourse.utils.UiEvent

@Composable
fun NavGraph(navController: NavHostController, onNavigate: (String) -> Unit) {

    NavHost(navController = navController, startDestination = Routes.SHOPPING_LIST) {
        composable(Routes.SHOPPING_LIST) {
            ShoppingListScreen() { route ->
                onNavigate(route)
            }
        }
        composable(Routes.NOTE_LIST) {
            NoteListScreen()
        }
        composable(Routes.ABOUT) {
            AboutScreen()
        }
        composable(Routes.SETTINGS) {
            SettingsScreen()
        }
    }
}