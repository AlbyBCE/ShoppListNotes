package com.example.noteappfromcourse.main_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.noteappfromcourse.R
import com.example.noteappfromcourse.dialog.MainDialog
import com.example.noteappfromcourse.navigation.NavGraph
import com.example.noteappfromcourse.shopping_list_screen.ShoppingListViewModel
import com.example.noteappfromcourse.utils.Routes
import com.example.noteappfromcourse.utils.UiEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(
    mainNavHostController: NavHostController,
    viewModel: MainScreenViewModel = hiltViewModel()
) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { uiEvent ->
            when (uiEvent) {
                is UiEvent.NavigateMain -> {
                    mainNavHostController.navigate(uiEvent.route)
                }

                is UiEvent.Navigate -> {
                    navController.navigate(uiEvent.route)
                }

                else -> {

                }
            }
        }
    }
    Scaffold(
        bottomBar = {
            BottomNav(currentRoute) { route ->
                viewModel.onEvent(MainScreenEvent.Navigate(route))
            }
        },
        floatingActionButton = {
            if (viewModel.showFloatingButton.value)
                FloatingActionButton(
                    onClick = {
                        viewModel.onEvent(MainScreenEvent.OnNewItemClick(currentRoute ?: Routes.SHOPPING_LIST))
                    },
                    modifier = Modifier.offset(y = 50.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.add_icon),
                        contentDescription = "Add",
                        tint = Color.White
                    )
                }
        },
        floatingActionButtonPosition = FabPosition.Center

    )
    {
        NavGraph(navController) { route ->
            viewModel.onEvent(MainScreenEvent.NavigateMain(route))
        }
        MainDialog(dialogController = viewModel)
    }

}