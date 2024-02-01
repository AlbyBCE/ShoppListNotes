package com.example.noteappfromcourse.dialog


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.darkText
import com.example.compose.md_theme_light_inversePrimary
import com.example.compose.textFieldMainColor


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainDialog(dialogController: DialogController) {
    if (dialogController.openDialog.value) {
        AlertDialog(
            onDismissRequest = { dialogController.onDialogEvent(DialogEvent.OnCancel) },
            confirmButton = {
                TextButton(onClick = {
                    dialogController.onDialogEvent(DialogEvent.OnConfirm)
                }) {
                    Text(text = "OK")
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    dialogController.onDialogEvent(DialogEvent.OnCancel)
                }) {
                    Text(text = "Cancel")
                }
            },
            title = null,
            text = {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = dialogController.dialogTitle.value,
                        style = TextStyle(
                            color = darkText,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    if (dialogController.showEditableText.value)
                        TextField(
                            value = dialogController.editableText.value,
                            onValueChange = {
                                dialogController.onDialogEvent(DialogEvent.onTextChange(it))
                            },
                            label = {
                                Text(text = "List name:")
                            },
                            colors = TextFieldDefaults.textFieldColors(
                                containerColor = textFieldMainColor,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            ),
                            shape = RoundedCornerShape(9.dp),
                            singleLine = true,
                            textStyle = TextStyle(color = darkText, fontSize = 16.sp)
                        )
                }
            }

        )
    }
}