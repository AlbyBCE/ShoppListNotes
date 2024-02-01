package com.example.noteappfromcourse.shopping_list_screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteappfromcourse.data.ShoppingListItem
import com.example.noteappfromcourse.data.ShoppingListRepository
import com.example.noteappfromcourse.dialog.DialogEvent
import com.example.noteappfromcourse.dialog.DialogController
import com.example.noteappfromcourse.utils.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShoppingListViewModel @Inject constructor(
    private val shoppingListRepo: ShoppingListRepository
) : ViewModel(), DialogController {
     val list = shoppingListRepo.getAllItems()
    private var listItem: ShoppingListItem? = null
    private val _UiEvent = Channel<UiEvent>()
    val uiEvent = _UiEvent.receiveAsFlow()
    override var dialogTitle = mutableStateOf("")
        private set
    override var editableText = mutableStateOf("")
        private set
    override var openDialog = mutableStateOf(false)
        private set
    override var showEditableText = mutableStateOf(false)
        private set

    fun onEvent(event: ShoppingListEvent) {
        when (event) {
            is ShoppingListEvent.onItemSave -> {
                if (editableText.value.isEmpty()) return
                viewModelScope.launch {
                    shoppingListRepo.insertItem(
                        ShoppingListItem(
                            listItem?.id,
                            name = editableText.value,
                            time = "12-12-2023 12:00",
                            listItem?.allItemsCount ?: 0,
                            listItem?.allSelectedItemCount ?: 0
                        )
                    )
                }
            }

            is ShoppingListEvent.OnItemClick -> {
                sendUiEvent(UiEvent.Navigate(event.route))
            }

            is ShoppingListEvent.OnShowEditDialog -> {
                listItem = event.item
                openDialog.value = true
                editableText.value = listItem?.name ?: ""
                dialogTitle.value = "List name: "
                showEditableText.value = true
            }

            is ShoppingListEvent.OnShowDeleteDialog -> {
                listItem = event.item
                openDialog.value = true
                dialogTitle.value = "Delete this item?"
                showEditableText.value = false
            }
        }
    }

    override fun onDialogEvent(event: DialogEvent) {
        when (event) {
            is DialogEvent.OnCancel -> {
                openDialog.value = false
            }

            is DialogEvent.OnConfirm -> {
                if (showEditableText.value) {
                    onEvent(ShoppingListEvent.onItemSave)
                } else {
                    viewModelScope.launch {
                        listItem?.let { shoppingListRepo.deleteItem(it) }
                    }
                }
                openDialog.value = false
            }

            is DialogEvent.onTextChange -> {
                editableText.value = event.text
            }
        }
    }
    private fun sendUiEvent(event: UiEvent){
        viewModelScope.launch {
            _UiEvent.send(event)
        }
    }
}