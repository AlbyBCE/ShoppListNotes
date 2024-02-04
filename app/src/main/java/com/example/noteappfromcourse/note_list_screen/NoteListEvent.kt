package com.example.noteappfromcourse.note_list_screen

import com.example.noteappfromcourse.data.NoteItem

sealed class NoteListEvent {
    data class OnShowDeleteDialog(val item: NoteItem) : NoteListEvent()
    data class OnItemClick(val route: String) : NoteListEvent()
    object UnDoneDeleteItem : NoteListEvent()

}
