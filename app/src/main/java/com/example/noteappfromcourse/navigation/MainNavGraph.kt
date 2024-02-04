package com.example.noteappfromcourse.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.noteappfromcourse.about_screen.AboutScreen
import com.example.noteappfromcourse.add_item_screen.AddItemScreen
import com.example.noteappfromcourse.main_screen.MainScreen
import com.example.noteappfromcourse.new_note_screen.NewNoteScreen
import com.example.noteappfromcourse.note_list_screen.NoteListScreen
import com.example.noteappfromcourse.settings_screen.SettingsScreen
import com.example.noteappfromcourse.shopping_list_screen.ShoppingListScreen
import com.example.noteappfromcourse.utils.Routes

@Composable
fun MainNavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.MAIN_SCREEN) {
        composable(Routes.ADD_ITEM + "/{listId}") {
//            Log.d("My Log" , "List Id: ${it.savedStateHandle.get<String>("listId")}") передача аргументов, но тк  у нас вью модел оттуда будет идти получение аргументов.
            AddItemScreen()
        }
        composable(Routes.NEW_NOTE + "/{noteId}") {
            NewNoteScreen() {
                navController.popBackStack() // для возврата назад
            }
        }
        composable(Routes.MAIN_SCREEN) {
            MainScreen(navController)
        }

    }
}