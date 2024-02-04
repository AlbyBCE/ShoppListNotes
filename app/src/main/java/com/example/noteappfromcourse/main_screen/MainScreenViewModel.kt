package com.example.noteappfromcourse.main_screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteappfromcourse.data.ShoppingListItem
import com.example.noteappfromcourse.data.ShoppingListRepository
import com.example.noteappfromcourse.dialog.DialogController
import com.example.noteappfromcourse.dialog.DialogEvent
import com.example.noteappfromcourse.utils.Routes
import com.example.noteappfromcourse.utils.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val repository: ShoppingListRepository
) : ViewModel(), DialogController {
    private val _UiEvent = Channel<UiEvent>()
    val uiEvent = _UiEvent.receiveAsFlow()
    override var dialogTitle = mutableStateOf("List name")
        private set
    override var editableText = mutableStateOf("")
        private set
    override var openDialog = mutableStateOf(false)
        private set
    override var showEditableText = mutableStateOf(true)
        private set
    var showFloatingButton = mutableStateOf(true)
        private set

    fun onEvent(event: MainScreenEvent) {
        when (event) {
            is MainScreenEvent.onItemSave -> {
                if (editableText.value.isEmpty()) return
                viewModelScope.launch {
                    repository.insertItem(
                        ShoppingListItem(
                            null,
                            name = editableText.value,
                            time = "12-12-2023 12:00",
                            0,
                            0
                        )
                    )
                }
            }

            is MainScreenEvent.OnNewItemClick -> {
                if (event.route == Routes.SHOPPING_LIST) {
                    openDialog.value = true
                } else {
                    sendUiEvent(UiEvent.NavigateMain(Routes.NEW_NOTE))
                }
            }

            is MainScreenEvent.Navigate -> {
                sendUiEvent(UiEvent.Navigate(event.route))
                showFloatingButton.value = if
                                                   (event.route == Routes.ABOUT || event.route == Routes.SETTINGS) {
                    false
                } else {
                    true
                }
            }


            is MainScreenEvent.NavigateMain -> {
                sendUiEvent(UiEvent.NavigateMain(event.route))

            }

            else -> {}
        }
    }

    override fun onDialogEvent(event: DialogEvent) {
        when (event) {
            is DialogEvent.OnCancel -> {
                openDialog.value = false
                editableText.value = ""
            }

            is DialogEvent.OnConfirm -> {
                onEvent(MainScreenEvent.onItemSave)
                openDialog.value = false
                editableText.value = ""
            }

            is DialogEvent.onTextChange -> {
                editableText.value = event.text
            }
        }
    }

    private fun sendUiEvent(event: UiEvent) {
        viewModelScope.launch {
            _UiEvent.send(event)
        }
    }
}