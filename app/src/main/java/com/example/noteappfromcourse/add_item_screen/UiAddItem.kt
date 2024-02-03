package com.example.noteappfromcourse.add_item_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.noteappfromcourse.R
import com.example.noteappfromcourse.data.AddItem


@Composable
fun UiAddItem(item: AddItem, onEvent: (AddItemEvent) -> Unit) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 3.dp)
        .clickable {
            onEvent(AddItemEvent.OnShowEditDialog(item))
        }) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .weight(1f),
                text = item.name, fontSize = 12.sp
            )
            Checkbox(checked = item.isCheck,
                onCheckedChange = { isChecked ->
                    onEvent(AddItemEvent.OnCheckedChange(item.copy(isCheck = isChecked)))// когда возьмем айтем нужно перезаписать состояние изменения
                })
            IconButton(onClick = {
                onEvent(AddItemEvent.OnDelete(item))
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.delete_button),
                    contentDescription = "delete"
                )//если не импортируется класс R его можно добавить в импорте через путь всего проекта
            }
        }
    }
}