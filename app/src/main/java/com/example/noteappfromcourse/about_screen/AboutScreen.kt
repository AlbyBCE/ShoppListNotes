package com.example.noteappfromcourse.about_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.about_background
import com.example.compose.darkText
import com.example.noteappfromcourse.R


@Preview(showBackground = true)
@Composable
fun AboutScreen() {
    val uriHandler = LocalUriHandler.current // для перехода по ссылке в браузере
    Column(
        Modifier
            .fillMaxSize()
            .background(about_background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "",
            modifier = Modifier.size(100.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "This App developer by A.K. \n" +
                    "Version 1.0.3 \n" +
                    "To get more information \n",
            textAlign = TextAlign.Center
        )
        Text(
            modifier = Modifier
                .clickable {
                    uriHandler.openUri("")
                }
                .padding(top = 10.dp),
            text = ">>> Click here <<< ",
            color = darkText
        )
    }
}