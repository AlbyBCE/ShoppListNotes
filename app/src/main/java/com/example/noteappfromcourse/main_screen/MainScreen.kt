package com.example.noteappfromcourse.main_screen

import android.annotation.SuppressLint
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.noteappfromcourse.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    Scaffold(
        bottomBar = {

        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
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

    }
}