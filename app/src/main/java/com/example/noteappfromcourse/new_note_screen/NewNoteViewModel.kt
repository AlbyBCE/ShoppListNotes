package com.example.noteappfromcourse.new_note_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteappfromcourse.data.NoteItem
import com.example.noteappfromcourse.data.NoteRepository
import com.example.noteappfromcourse.utils.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewNoteViewModel @Inject constructor(
    private val repository: NoteRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private var noteId = -1
    private var noteItem: NoteItem? = null

    private val _UiEvent = Channel<UiEvent>()
    val uiEvent = _UiEvent.receiveAsFlow()

    var title by mutableStateOf("")
        private set
    var decriprion by mutableStateOf("")
        private set

    init {
        noteId = savedStateHandle.get<String>("")?.toInt() ?: -1
        if (noteId != -1) {
            viewModelScope.launch {
                repository.getNoteItemById(noteId).let { noteItem ->
                    title = noteItem.title
                    decriprion = noteItem.description
                    this@NewNoteViewModel.noteItem = noteItem
                }
            }
        }
    }

    fun onEvent(event: NewNoteEvent) {
        when (event) {
            is NewNoteEvent.OnSave -> {
                viewModelScope.launch {
                    repository.insertItem(
                        NoteItem(
                            noteItem?.id,
                            title,
                            decriprion,
                            "12.12.2023 12:00"
                        )
                    )
                }
                sendUiEvent(UiEvent.PopBackStack)
            }

            is NewNoteEvent.OnTitleChange -> {
                title = event.title
            }

            is NewNoteEvent.OnDescriptionChange -> {
                decriprion = event.description
            }
        }
    }

    private fun sendUiEvent(event: UiEvent) {
        viewModelScope.launch {
            _UiEvent.send(event)
        }
    }
}