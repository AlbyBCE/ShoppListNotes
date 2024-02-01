package com.example.noteappfromcourse.add_item_screen

import androidx.compose.runtime.MutableState
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.noteappfromcourse.data.AddItemRepository
import com.example.noteappfromcourse.dialog.DialogController
import com.example.noteappfromcourse.dialog.DialogEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddItemViewModel @Inject constructor(
    repository: AddItemRepository,
    savedStateHandle: SavedStateHandle// для получения доступа к аргументам, при открытии экрана
) : ViewModel(), DialogController {
    override val dialogTitle: MutableState<String>
        get() = TODO("Not yet implemented")
    override val editableText: MutableState<String>
        get() = TODO("Not yet implemented")
    override val openDialog: MutableState<Boolean>
        get() = TODO("Not yet implemented")
    override val showEditableText: MutableState<Boolean>
        get() = TODO("Not yet implemented")

    override fun onDialogEvent(event: DialogEvent) {
        TODO("Not yet implemented")
    }
}