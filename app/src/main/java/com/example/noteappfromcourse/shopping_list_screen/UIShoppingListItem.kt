package com.example.noteappfromcourse.shopping_list_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.compose.darkText
import com.example.compose.lightText
import com.example.compose.md_theme_dark_errorContainer
import com.example.compose.md_theme_dark_primary
import com.example.compose.md_theme_light_secondary
import com.example.compose.progressBar
import com.example.noteappfromcourse.R
import com.example.noteappfromcourse.data.ShoppingListItem
import com.example.noteappfromcourse.utils.ProgressHelper
import com.example.noteappfromcourse.utils.Routes


@Composable
fun UIShoppingListItem(
    item: ShoppingListItem,
    onEvent: (ShoppingListEvent) -> Unit
) {
    ConstraintLayout(
        modifier = Modifier.padding(
            start = 3.dp, top = 18.dp, end = 3.dp
        )
    ) {
        val (card, deleteButton, editButton, counter) = createRefs()
        Card(modifier = Modifier
            .fillMaxWidth()
            .constrainAs(card) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
            .clickable {
                onEvent(
                    ShoppingListEvent.OnItemClick(
                        Routes.ADD_ITEM + "/${item.id}"
                    )
                )
            },
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.tertiaryContainer
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    text = item.name,
                    style = TextStyle(color = darkText),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    text = item.time,
                    style = TextStyle(color = lightText),
                    fontSize = 12.sp
                )
                LinearProgressIndicator(
                    progress = ProgressHelper.getProgress(
                        item.allItemsCount,
                        item.allSelectedItemCount
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    color = progressBar
                )
            }
        }
        IconButton(
            onClick = {
                onEvent(ShoppingListEvent.OnShowDeleteDialog(item))
            },
            modifier = Modifier.constrainAs(deleteButton) {
                top.linkTo(card.top)
                end.linkTo(card.end)
                bottom.linkTo(card.top)
            }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.delete_button),
                contentDescription = "delete button",
                modifier = Modifier
                    .padding(end = 10.dp)
                    .clip(CircleShape)
                    .background(md_theme_dark_primary)
                    .size(30.dp),
                tint = md_theme_dark_errorContainer
            )
        }
        IconButton(
            onClick = {
                onEvent(ShoppingListEvent.OnShowEditDialog(item))
            },
            modifier = Modifier.constrainAs(editButton) {
                top.linkTo(card.top)
                end.linkTo(deleteButton.start)
                bottom.linkTo(card.top)
            }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.edit_note_button_icon),
                modifier = Modifier
                    .clip(CircleShape)
                    .background(md_theme_dark_primary)
                    .size(30.dp)
                    .padding(end = 5.dp),
                contentDescription = "delete button",
                tint = md_theme_light_secondary


            )
        }
        Card(shape = RoundedCornerShape(5.dp),
            modifier = Modifier
                .constrainAs(counter) {
                    top.linkTo(card.top)
                    end.linkTo(editButton.start)
                    bottom.linkTo(card.top)
                }
                .padding(end = 5.dp)
        ) {
            Text(
                text = "${item.allItemsCount}/${item.allSelectedItemCount}",
                modifier = Modifier
                    .background(md_theme_dark_errorContainer)
                    .padding(
                        top = 3.dp,
                        bottom = 3.dp,
                        start = 5.dp,
                        end = 5.dp
                    ),
                color = Color.White
            )
        }
    }
}