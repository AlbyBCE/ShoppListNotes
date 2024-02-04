package com.example.noteappfromcourse.note_list_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.darkText
import com.example.compose.deeeeell
import com.example.compose.lightText

@Preview(showBackground = true)
@Composable
fun UiNoteItem() {
    Card(
        Modifier
            .fillMaxWidth()
            .padding(top = 3.dp, start = 3.dp, end = 3.dp)
            .clickable {

            }
    ) {
        Column(Modifier.fillMaxWidth()) {
            Row(Modifier.fillMaxWidth()) {
                Text(
                    modifier = Modifier
                        .weight(1f)
                        .padding(
                            top = 10.dp,
                            start = 10.dp
                        ),
                    text = "Note1",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    modifier = Modifier.padding(
                        top = 10.dp,
                        end = 10.dp
                    ),
                    text = "12.12.2023 12:00",
                    color = lightText,
                    fontSize = 12.sp
                )
            }
            Row(Modifier.fillMaxWidth()) {
                Text(
                    modifier = Modifier
                        .padding(
                            start = 10.dp,
                            top = 5.dp,
                            bottom = 5.dp
                        )
                        .weight(1f),
                    text = "dsfssdf",
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    color = darkText
                )
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Delete",
                        tint = deeeeell
                    )
                }
            }
        }
    }
}